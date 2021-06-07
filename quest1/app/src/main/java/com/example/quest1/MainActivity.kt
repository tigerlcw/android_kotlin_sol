package com.example.quest1

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<Button>(R.id.button)
        tv.text = "학번:1971543_이찬우"

     /*   tv.setOnClickListener {
            println("view.onClickListener")
        }

        tv.apply {
            text = "new hihihihi"
            setOnClickListener { println("TEST") }
            typeface = Typeface.SERIF
            textSize = 20.0F
            setTextColor(Color.WHITE)
        }

      */
        //1971543이찬우 실습 코드
        tv.setOnClickListener {
            count ++ // 버튼이 눌릴 때마다 증가
          //  tv.text ="TEXT " + count.toInt() // count++를 인코딩 메소드를 활용하여 문자열 "TEXT"뒤에 정수 출력
            tv.text ="TEXT ${count}" // 교수님의 조언을 받아 다시 작성한 코드
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        println("destroyed")
    }

}