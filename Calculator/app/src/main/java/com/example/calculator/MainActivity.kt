package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val operator = findViewById<EditText>(R.id.operator)
        val calcbtn = findViewById<Button>(R.id.calcbtn)

        //TODO: 계산 버튼에 onClick 리스너 붙여서 Logcat으로
        //num1, num2, operator 값 출력하게 하기

        calcbtn.setOnClickListener {
            Log.d("mytag",num1.text.toString())
            Log.d("mytag",num2.text.toString())
            Log.d("mytag",operator.text.toString())

            //TODO: num1, num2 텍스트는 숫자로 변환해야 함
            //자료형 변환해서 변수(n1, n2)에 저장하기기
            val n1 = num1.text.toString().toInt()
            val n2 = num2.text.toString().toInt()

            //TODO: 새 엑티비티 (CalculateResultActivity) 만들고
            //Intent랑 startActivity 이용해서 해당 엑티비티로 이동하게 만들기
            //그 과정에서 putExtra로 인텐트에 n1, n2 연산자 문자열 전달
            val intent = Intent(this, CalculateResultActivity::class.java)
            intent.putExtra("num1", n1)
            intent.putExtra("num2", n2)
            intent.putExtra("operator",operator.text.toString())
            startActivity(intent)
        }
   }
}