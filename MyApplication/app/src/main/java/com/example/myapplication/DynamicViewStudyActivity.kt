package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import java.lang.reflect.Type

class DynamicViewStudyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

 /*       //동적 뷰 생성 => XML 레이아웃 말고 코드로 뷰 객체를 직접 생성
        val root = LinearLayout(this)
        //android:orientation="vertical"과 동일한 역할
        root.orientation = LinearLayout.VERTICAL
        //각각 android:width, android:height => "match_parent"
        root.layoutParams = LinearLayout.LayoutParams (
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        //10dp를 해당 단말기에서 사용될 pixel 단위값(정수)으로 변환
        val DPToPX = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            20f,
            resources.displayMetrics
        ).toInt()
        Log.d("my_tag",DPToPX.toString())

        val btn = Button(this)
        //부모가 LinearLayout이 될 것이라서 LinearLayout
        //내부의 LayoutParams 사용
        val params = LinearLayout.LayoutParams (
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        //setMargins(int left, int top, int right, int bottom) {
        //마진값은 "부모"와 연관이 있는 여백값
        params.setMargins(DPToPX,DPToPX,DPToPX,DPToPX)
        btn.layoutParams = params
        //패딩값은 뷰 내부적으로 사용되는 여백값
        btn.setPadding(DPToPX,DPToPX,DPToPX,DPToPX)
        btn.text = "Hello"
        //android:textSize="26sp"
        btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,26f)
        btn.setTextColor(Color.RED)


        val editText = EditText(this)
        //editText의 높이를 100dp로 할 것이므로 100dp에 대한 pixel 값 구하기
        val height = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            100f,
            resources.displayMetrics
        ).toInt()
        Log.d("my_tag",height.toString())

        //너비는 match_parent, 높이는 height로 정하기
        //layoutParams에는 부모와 연관되어있는 android: 속성들을 정의하기 위해서 사용
        //ex) width, height, margin
        editText.layoutParams = LinearLayout.LayoutParams (
            LinearLayout.LayoutParams.MATCH_PARENT,
            height
        )
        //EditText 배경 색상 바꿔보기(노란색으로)
        editText.setBackgroundColor(Color.YELLOW)

        root.addView(editText)
        root.addView(btn)

        //레이아웃 리소스 id 혹은 뷰그룹 객체 전달 가능
        setContentView(root)
        */

        var count = 1
        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        val btn = Button(this)
        btn.text = "add"
        btn.setOnClickListener{
            val t = TextView(this)
            t.text = "Hello ${count}"
            count++
            root.addView(t)
        }

        root.addView(btn)
        setContentView(root)


    }
}