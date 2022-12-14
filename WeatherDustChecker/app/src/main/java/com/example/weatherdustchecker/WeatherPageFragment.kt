package com.example.weatherdustchecker

import android.graphics.Path
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.net.URL

@JsonDeserialize(using=MyDeserializer::class)
data class OpenWeatherAPIJSONResponse(val temp: Double, val id: Int)

class MyDeserializer : StdDeserializer<OpenWeatherAPIJSONResponse>(
    OpenWeatherAPIJSONResponse::class.java
) {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?
    ): OpenWeatherAPIJSONResponse {
        val node = p?.codec?.readTree<JsonNode>(p)

//        val weather = node?.get("weather")
//        val firstWeather = weather?.elements()?.next()
//        val id = firstWeather?.get("id")?.asInt()

//        val main = node?.get("main")
//        val temp = main?.get("temp")?.asDouble()

        val id = node?.get("weather")?.elements()?.next()?.get("id")?.asInt()
        val temp = node?.get("main")?.get("temp")?.asDouble()

        return OpenWeatherAPIJSONResponse(temp!!, id!!)
    }
}

class WeatherPageFragment : Fragment() {
    lateinit var weatherImage : ImageView
    lateinit var statusText : TextView
    lateinit var temperatureText : TextView
    var APP_ID = "0d30adfc8ad70b893e99fc30039fdbbe"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater
            .inflate(R.layout.weather_page_fragment,
                    container, false)

        //TODO : arguments ??? ???????????? ??? ??? ??? ????????????, ???????????? ?????? ???????????????
        statusText = view.findViewById<TextView>(R.id.weather_status_text)
        temperatureText = view.findViewById<TextView>(R.id.weather_temp_text)
        weatherImage = view.findViewById<ImageView>(R.id.weather_icon)
        
//        statusText.text = arguments?.getString("status")
//        temperatureText.text = arguments?.getString("temperature").toString()

        //TODO : ImageView ???????????? sun ????????? ????????????
//        weatherImage.setImageResource(R.drawable.sun);
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lat = arguments?.getDouble("lat")
        val lon = arguments?.getDouble("lon")
        val url = "https://api.openweathermap.org/data/2.5/weather?units=metric&lat=37.58&lon=126.98&appid=${APP_ID}&lat=${lat}&lon${lon}"

        APICall(object: APICall.APICallback {
            override fun onComplete(result: String) {
                //Log.d("mytag",result)
                var mapper = jacksonObjectMapper()
                var data = mapper?.readValue<OpenWeatherAPIJSONResponse>(result)

                temperatureText.text = data.temp.toString()

                val id = data.id.toString()
                    if(id != null) {
                        statusText.text = when {
                            id.startsWith("2") -> {
                                weatherImage.setImageResource(R.drawable.flash)
                                "??????, ??????"
                            }
                            id.startsWith("3") -> {
                                weatherImage.setImageResource(R.drawable.rain)
                                "?????????"
                            }
                            id.startsWith("5") -> {
                                weatherImage.setImageResource(R.drawable.rain)
                                "???"
                            }
                            id.startsWith("6") -> {
                                weatherImage.setImageResource(R.drawable.snow)
                                "???"
                            }
                            id.startsWith("7") -> {
                                weatherImage.setImageResource(R.drawable.cloudy)
                                "??????"
                            }
                            id.equals("800") -> {
                                weatherImage.setImageResource(R.drawable.sun)
                                "??????"
                            }
                            id.startsWith("8") -> {
                                weatherImage.setImageResource(R.drawable.cloud)
                                "?????? ???"
                            }
                            else -> "??? ??? ??????"
                        }
                    }
                }
        }).execute(URL(url))
    }

    companion object {
        fun newInstance(lat: Double, lon: Double)
            : WeatherPageFragment
        {
            val fragment = WeatherPageFragment()
            //?????? ????????? ????????? ????????? ??????
            val args = Bundle()
            args.putDouble("lat", lat)
            args.putDouble("lon", lon)
            fragment.arguments = args

            return fragment
        }
    }
}
