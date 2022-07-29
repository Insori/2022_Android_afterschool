package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class LifecycleStudyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_study)
        Log.d("my_tag","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("my_tag","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("my_tag","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("my_tag","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("my_tag","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("my_tag","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("my_tag","onRestart")
    }
}