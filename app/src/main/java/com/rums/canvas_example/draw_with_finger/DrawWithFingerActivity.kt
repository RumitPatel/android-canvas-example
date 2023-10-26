package com.rums.canvas_example.draw_with_finger

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.rums.canvas_example.R

class DrawWithFingerActivity : AppCompatActivity() {

    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_with_finger)

        initComponents()
        setListeners()
    }

    private fun initComponents() {
        mContext = this
    }

    private fun setListeners() {
        val undoCanvasView = findViewById<UndoCanvasCustomView>(R.id.undoCanvasView)

        val btnUndo = findViewById<Button>(R.id.btnUndo)
        btnUndo.setOnClickListener {

            undoCanvasView.undoCanvasDrawing()
        }

        val btnRedo = findViewById<Button>(R.id.btnRedo)
        btnRedo.setOnClickListener {
            undoCanvasView.redoCanvasDrawing()
        }

        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener {
            undoCanvasView.resetCanvasDrawing()
        }
    }
}