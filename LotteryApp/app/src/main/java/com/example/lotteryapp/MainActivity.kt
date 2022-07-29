package com.example.lotteryapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var currentNums: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences 객체 만들기
        val pref = getSharedPreferences("nums", Context.MODE_PRIVATE)

        //1. 랜덤하게 숫자를 하나 구하기(1~45 범위)
        val nums = mutableListOf<Int>()
        //2. 반복문을 통해서 숫자를 연결시켜서 문자열 만들기
        for(i in 1..6) nums.add((1..45).random())
        val lottoNum = nums.joinToString("-")
        //3. TextView를 통해서 출력하기
        Log.d("mytag",lottoNum.toString())
        var lottoNumView = findViewById<TextView>(R.id.lotto_num)
        currentNums = generateRandomLottoNum(6,"-")
        lottoNumView.text = currentNums

        val generateNumBtn = findViewById<Button>(R.id.lotto_btn)
        generateNumBtn.setOnClickListener {
            currentNums = generateRandomLottoNum(5,"-")
            lottoNumView.text = currentNums
        }

        val saveNumberBtn = findViewById<Button>(R.id.lotto_save_btn)
        saveNumberBtn.setOnClickListener {
            var lottoNums = pref.getString("lottonums","")
            var numList = if(lottoNums == "") {
                mutableListOf<String>()
            }else {
                lottoNums!!.split(",").toMutableList()
            }
            numList.add(currentNums)
            Log.d("mytag",numList.size.toString())
            Log.d("mytag",numList.toString())

            val editor = pref.edit()
            editor.putString("lottonums",numList.joinToString(","))
            editor.apply()
        }

        findViewById<Button>(R.id.num_list).setOnClickListener {
            val intent = Intent(this,
                LotteryNumListActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.check_num).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://m.dhlottery.co.kr/gameResult.do?method=byWin&wiselog=M_A_1_8"))
            startActivity(intent)
        }

    }
    fun generateRandomLottoNum(count: Int, sep: String): String {
        val nums = mutableListOf<Int>()
        for(i in 1..count) nums.add((1..45).random())
        return nums.joinToString(sep)
    }
}