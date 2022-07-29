package com.example.todayquote

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuoteListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quote_list_activity)

        val size = intent.getIntExtra("quote_size",-1)
        Log.d("mytag",size.toString())

        val pref = getSharedPreferences("quotes",Context.MODE_PRIVATE)
        // 준비물 1
        val quotes = Quote.getQuotesFromPreference(pref)

        //준비물 3
        val layoutManager = LinearLayoutManager(this)
        val quotelist = findViewById<RecyclerView>(R.id.quote_list)

        //준비물 4,5
        val adapter = QuoteAdapter(quotes)
        quotelist.setHasFixedSize(false)
        quotelist.layoutManager = layoutManager
        quotelist.adapter = adapter
    }
}