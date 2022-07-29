package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CalculateResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_result)

        //TODO: 전달받은 intent에 데이터 3개 다 꺼내서 로그로 출력
        val num1 = intent.getIntExtra("num1",-1)
        Log.d("mytag", num1.toString())

        val num2 = intent.getIntExtra("num2",-1)
        Log.d("mytag", num2.toString())

        val op = intent.getStringExtra("operator")!!
        Log.d("mytag", op)

        //TODO: 결과를 보여줄 TextView 추가
        val result = findViewById<TextView>(R.id.result)

        //TODO: 연산자에 따라 분기문 넣고 계산 후 TODO 2의 TextView에 결과 출력
        if (op == "+") result.text = ((num1+num2).toString())
        else if (op == "-") result.text = ((num1-num2).toString())
        else {
            Toast.makeText(this, "잘못된 연산자 입력", Toast.LENGTH_SHORT).show()
            finish()
        }

        //TODO: "종료" 버튼 만들어서 onClick 리스터 붙이고 버튼 누르면 엑티비티 꺼지게 하기
        val endbtn = findViewById<Button>(R.id.endbtn)
        endbtn.setOnClickListener {
            finish()
        }
    }
}
