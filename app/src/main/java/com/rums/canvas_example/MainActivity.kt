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
import kotlin.random.Random


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

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                goNext()
                handler.postDelayed(this, 1000)//1 sec delay
            }
        }, 0)

    }

    private fun setListeners() {
        btn1.setOnClickListener {
            goNext()
        }
    }

    private fun prepareCircleArray() {
        repeat(25) {
            arraylist.add(0)
        }
    }

    private fun resetCircleArray() {
        for (i in arraylist.indices) {
            arraylist[i] = 0
        }
    }

    private fun drawAllLines() {
        createLeftRows()
        createUpRows()
        createRightRows()
    }

    private fun clearAllCircles() {
        linLeft.removeAllViews()
        linUp.removeAllViews()
        linRight.removeAllViews()
    }

    private fun createLeftRows() {
        for (item in arraylist.subList(0, 10)) {
            val iv = View(mContext)
            iv.setBGDrawable(mContext, getDrawlFromType(item))
            iv.layoutParams = getRoundLp()
            linLeft.addView(iv)
        }
    }

    private fun createUpRows() {
        for (item in arraylist.subList(10, 14)) {
            val iv = View(mContext)
            iv.setBGDrawable(mContext, getDrawlFromType(item))
            iv.layoutParams = getRoundLp()
            linUp.addView(iv)
        }
    }

    private fun createRightRows() {
        for (item in arraylist.subList(14, 24)) {
            val iv = View(mContext)
            iv.setBGDrawable(mContext, getDrawlFromType(item))
            iv.layoutParams = getRoundLp()
            linRight.addView(iv)
        }
    }

    private fun goNext() {
        resetCircleArray()
        clearAllCircles()


        arraylist[Random.nextInt(25)] = Random.nextInt(4)



        drawAllLines()
    }
}