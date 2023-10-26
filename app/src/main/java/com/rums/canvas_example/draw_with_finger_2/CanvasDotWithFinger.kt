package com.rums.canvas_example.draw_with_finger_2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.rums.canvas_example.utils.logE


class CanvasDotWithFinger @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val grayPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val point: PointF = PointF()

    init {
        grayPaint.color = Color.RED
        grayPaint.strokeWidth = 1.5f
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action!! and event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                logE("Action was DOWN")
                point.x = event.x
                point.y = event.y
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                logE("Action was UP")
            }
        }

        return super.onTouchEvent(event)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(point.x, point.y, 14f, grayPaint)
    }
}