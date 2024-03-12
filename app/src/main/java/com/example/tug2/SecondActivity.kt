package com.example.tug2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var resulting : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val resText = String.format("Your name is %s\nYour Gender is %s\nYour age is around %s",
            intent.extras?.getString("NAME"), intent.extras?.getString("RADIO"), intent.extras?.getString("DROP")
        )
        resulting = findViewById(R.id.resultText)
        resulting.text = resText
    }
}