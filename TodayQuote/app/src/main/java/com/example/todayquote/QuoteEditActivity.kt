package com.example.todayquote

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuoteEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_edit)

        //TODO: 프리퍼런스 통해서 명언 다 가져오는 Quote의 클래스 메소드 호출하기
        val pref = getSharedPreferences("quotes", Context.MODE_PRIVATE)
        val quotes = Quote.getQuotesFromPreference(pref)

        val editQuotes = mutableListOf<Quote>()
        for(i in 0 until 20) {
            editQuotes.add(Quote(i,"",""))
        }
        for(q in quotes) {
            editQuotes[q.idx].idx = q.idx
            editQuotes[q.idx].text = q.text
            editQuotes[q.idx].from = q.from
        }

        val layoutManager = LinearLayoutManager(this)
        val adapter = QuoteEditAdapter(editQuotes)

        val listView = findViewById<RecyclerView>(R.id.quote_edit_list)
        listView.setHasFixedSize(false) // true? false?
        listView.layoutManager = layoutManager
        listView.adapter = adapter

    }

}