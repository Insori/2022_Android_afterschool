package com.example.githubusersearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEdit = findViewById<EditText>(R.id.search_text)
        val searchButton = findViewById<Button>(R.id.search_button)

        searchButton.setOnClickListener {

        }
    }
}