package com.rums.canvas_example

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.rums.canvas_example.utils.getRoundLp
import com.rums.canvas_example.utils.setBGDrawable


class MainActivity : AppCompatActivity() {

    private lateinit var mContext: Context
    private lateinit var linLeft: LinearLayout
    private lateinit var linUp: LinearLayout
    private lateinit var linRight: LinearLayout
    private lateinit var btn1: Button

    var arraylist = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

        createLeftRows()
        createUpRows()
        createRightRows()
    }

    private fun initComponents() {
        mContext = this
        linLeft = findViewById(R.id.linLeft)
        linUp = findViewById(R.id.linUp)
        linRight = findViewById(R.id.linRight)
        btn1 = findViewById(R.id.btn1)

        setListeners()
    }

    private fun setListeners() {
        btn1.setOnClickListener{
            goNext()
        }
    }


    private fun createLeftRows() {
        repeat(10) {
            val iv = View(mContext)
            iv.setBGDrawable(mContext, R.drawable.round_default)
            iv.layoutParams = getRoundLp()
            linLeft.addView(iv)
        }
    }

    private fun createUpRows() {
        repeat(4) {
            val iv = View(mContext)
            iv.setBGDrawable(mContext, R.drawable.round_default)
            iv.layoutParams = getRoundLp()
            linUp.addView(iv)
        }
    }
    private fun createRightRows() {
        repeat(10) {
            val iv = View(mContext)
            iv.setBGDrawable(mContext, R.drawable.round_default)
            iv.layoutParams = getRoundLp()
            linRight.addView(iv)
        }
    }

    private fun goNext() {

    }
}