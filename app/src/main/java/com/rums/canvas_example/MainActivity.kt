package com.rums.canvas_example

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.rums.canvas_example.utils.getDrawlFromType
import com.rums.canvas_example.utils.getRoundLp
import com.rums.canvas_example.utils.setBGDrawable


class MainActivity : AppCompatActivity() {

    private lateinit var mContext: Context
    private lateinit var linLeft: LinearLayout
    private lateinit var linUp: LinearLayout
    private lateinit var linRight: LinearLayout
    private lateinit var btn1: Button

    private var arrList = ArrayList<Int>()

    private var currentHead = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

    }

    private fun initComponents() {
        mContext = this
        linLeft = findViewById(R.id.linLeft)
        linUp = findViewById(R.id.linUp)
        linRight = findViewById(R.id.linRight)
        btn1 = findViewById(R.id.btn1)

        setListeners()
        prepareCircleArray()
        drawAllLines()

        setRepeat()
    }

    private fun setListeners() {
        btn1.setOnClickListener {
            goNext()
        }
    }

    private fun setRepeat() {
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                goNext()
                handler.postDelayed(this, 500)//half sec delay
            }
        }, 0)
    }

    private fun prepareCircleArray() {
        repeat(25) {
            if (it == 0 || it == 1 || it == 2 || it == 3) {
                arrList.add(it)
                currentHead = it
            } else {
                arrList.add(0)
            }
        }
    }

    private fun drawAllLines() {
        createLeftRows()
        createUpRows()
        createRightRows()
    }

    private fun clearAllCircleViews() {
        linLeft.removeAllViews()
        linUp.removeAllViews()
        linRight.removeAllViews()
    }

    private fun createLeftRows() {
        for (item in arrList.subList(0, 10).reversed()) {
            val iv = View(mContext)
            iv.setBGDrawable(mContext, getDrawlFromType(item))
            iv.layoutParams = getRoundLp()
            linLeft.addView(iv)
        }
    }

    private fun createUpRows() {
        for (item in arrList.subList(10, 14)) {
            val iv = View(mContext)
            iv.setBGDrawable(mContext, getDrawlFromType(item))
            iv.layoutParams = getRoundLp()
            linUp.addView(iv)
        }
    }

    private fun createRightRows() {
        for (item in arrList.subList(14, 24)) {
            val iv = View(mContext)
            iv.setBGDrawable(mContext, getDrawlFromType(item))
            iv.layoutParams = getRoundLp()
            linRight.addView(iv)
        }
    }

    private fun goNext() {
//        resetCircleArray()
        clearAllCircleViews()

        calculateNext()

        drawAllLines()
    }

    private fun calculateNext() {
        if (currentHead == 25) {
            currentHead = 4
        } else {
            currentHead += 1
        }

        for (i in arrList.indices) {
            if (i == currentHead) {
                arrList[i] = 1
            } else if (i == (currentHead - 1)) {
                arrList[i - 1] = 2
            } else if (i == (currentHead - 2)) {
                arrList[i - 2] = 3
            } else {
                arrList[i] = 0
            }
        }
    }
}