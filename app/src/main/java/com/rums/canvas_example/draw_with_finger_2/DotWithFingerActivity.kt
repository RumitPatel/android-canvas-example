package com.rums.canvas_example.draw_with_finger_2

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rums.canvas_example.R

class DotWithFingerActivity : AppCompatActivity() {

    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dot_with_finger)

        initComponents()
    }

    private fun initComponents() {
        mContext = this
    }
}