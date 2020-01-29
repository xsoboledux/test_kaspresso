package ru.asobol.testkaspresso.main

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.asobol.testkaspresso.R

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var count = 1
        testTextView.text = count.toString()

        testButton.setOnClickListener {
            count++
            testTextView.text = count.toString()
        }
    }
}