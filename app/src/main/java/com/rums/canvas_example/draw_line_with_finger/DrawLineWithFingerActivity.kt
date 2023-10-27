package com.rums.canvas_example.draw_line_with_finger

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rums.canvas_example.R

class DrawLineWithFingerActivity : AppCompatActivity() {

    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_line_with_finger)

        initComponents()
    }

    private fun initComponents() {
        mContext = this
    }
}