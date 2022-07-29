package com.example.todayquote

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SharedPreferenceStudyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference_study)

        val sp : SharedPreferences = getSharedPreferences("file_name",
                                Context.MODE_PRIVATE)

        val editor : SharedPreferences.Editor = sp.edit()
        editor.putInt("key1",1)
        editor.putFloat("key2",3.14F)
        editor.putString("hello","world")

        //apply는 저장하는 메서드
        editor.apply()

        val key1Value = sp.getInt("key1",-1)
        val key2Value = sp.getFloat("key2",0.0F)
        val helloValue = sp.getString("hello","default")

        Log.d("tag_name",key1Value.toString())
        Log.d("tag_name",key2Value.toString())
        Log.d("tag_name",helloValue!!)

        val contains : Boolean = sp.contains("key2")
        editor.remove("key1")
        editor.clear()
        editor.apply()

    }
}