package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ToggleButton
import androidx.core.widget.addTextChangedListener

class ViewGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*        setContentView(R.layout.relative_study1)*/
/*        setContentView(R.layout.nested_viewgroup)*/
          setContentView(R.layout.view_study1)

        //setContentView보다 아래에 써야됨
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            Log.d("my_tag","OnClick")
        }
        //true는 일처리를 잘했는지를 알려줌
        button.setOnLongClickListener{
            Log.d("my_tag","OnLongClick")
            true
        }

        val toggle = findViewById<ToggleButton>(R.id.my_toggle_button)
        toggle.setOnCheckedChangeListener {
                compoundButton, isChecked ->
            Log.d("my_tag","checked : ${isChecked}")
        }

        val editText = findViewById<EditText>(R.id.edittext2)
        editText.addTextChangedListener {
            Log.d("my_tag",it.toString())
        }
        editText.setOnFocusChangeListener { view, b ->
            Log.d("my_tag","focused : ${b}")
            if(b) view.setBackgroundColor(Color.YELLOW)
            else view.setBackgroundColor(Color.WHITE)
        }

    }
}