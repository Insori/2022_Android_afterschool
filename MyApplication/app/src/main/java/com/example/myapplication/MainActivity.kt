package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_study2)

        //식별자를 이용한 뷰 접근
/*        var myButton : Button = findViewById(R.id.my_button)
        var myTextView = findViewById<TextView>(R.id.my_textview)
        var myEditText = findViewById<EditText>(R.id.my_edittext)*/


//        myButton.setOnClickListener(
//            object: View.OnClickListener {
//                override fun onClick(p0: View?) {
//                    Toast.makeText(this@MainActivity,
//                    "클릭!",Toast.LENGTH_SHORT).show()
//                }
//            }
//        )
/*        myButton.setOnClickListener {
//          Toast.makeText(this@MainActivity, "클릭!",Toast.LENGTH_SHORT).show()
            Log.d("my_tag","Hello") //Log.d("태그명","메시지")
        }
 */

        // 체크박스 뷰 가져오기
        val checkBox = findViewById<CheckBox>(R.id.checkbox1)
        checkBox.setOnCheckedChangeListener {
                compoundButton, b ->
            if(b) {
                //체크박스가 체크되었을 때 로직
                Log.d("my_tag","checked")
            }
            else {
                //아닌 경우 로직
                Log.d("my_tag","unchecked")
            }
        }

        val group = findViewById<RadioGroup>(R.id.radio_group)
        group.setOnCheckedChangeListener {
            radioGroup, id ->
            Log.d("my_tag",id.toString())
            //when - case
            when(id) {
                R.id.radio_button1 -> {
                    Log.d("my_tag","버튼 1 선택")
                }
                R.id.radio_button2 -> {
                    Log.d("my_tag","버튼 2 선택")
                }
            }

        }

        val spinner = findViewById<Spinner>(R.id.my_spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.my_str_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = adapter

        //익명 클래스 쓰면 클래스 정의와 객체 생성을 한꺼번에
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?,
                                        p1: View?,
                                        p2: Int, //position
                                        p3: Long) {
                Log.d("my_tag",p2.toString())
                val selected = p0?.getItemAtPosition(p2).toString()
                Log.d("my_tag",selected)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}