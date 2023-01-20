package com.rums.canvas_example

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        setListeners()
    }

    private fun initComponents() {
        mContext = this
    }

    private fun setListeners() {
        val myCanvasView = findViewById<MyCanvasView>(R.id.canvasView)

        val btnUndo = findViewById<Button>(R.id.btnUndo)
        btnUndo.setOnClickListener {

            myCanvasView.undoCanvasDrawing()
        }

        val btnRedo = findViewById<Button>(R.id.btnRedo)
        btnRedo.setOnClickListener {
            myCanvasView.redoCanvasDrawing()
        }

        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener {
            myCanvasView.resetCanvasDrawing()
        }
    }
}