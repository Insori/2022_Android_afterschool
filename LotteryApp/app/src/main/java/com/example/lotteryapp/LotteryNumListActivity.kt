package com.example.lotteryapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LotteryNumListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottery_num_list)

        val pref = getSharedPreferences("nums", Context.MODE_PRIVATE)
        var lottoNums = pref.getString("lottonums","")
        //준비물 => numList
        var numList = if(lottoNums == "") {
            mutableListOf<String>()
        }else {
            lottoNums!!.split(",").toMutableList()
        }

        val listView = findViewById<RecyclerView>(R.id.num_list)
        listView.setHasFixedSize(true)
        //준비물 => 레이아웃 매니저
        listView.layoutManager = LinearLayoutManager(this)

        //준비물 4,5
        listView.adapter = LotteryListAdapter(numList)

        listView.setHasFixedSize(true)
    }
}