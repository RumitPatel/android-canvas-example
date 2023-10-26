package com.rums.canvas_example.move_dot_with_finger

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


class CanvasMoveDotWithFinger @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val touchPoint: PointF = PointF()

    init {
        paint.color = Color.RED
        paint.strokeWidth = 1.5f
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action!! and event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                logE("Action was DOWN")
            }

            MotionEvent.ACTION_UP -> {
                logE("Action was UP")
            }

            MotionEvent.ACTION_MOVE -> {
                logE("Action was MOVE")
                touchPoint.x = event.x
                touchPoint.y = event.y
                invalidate()
            }
        }

        return true

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(touchPoint.x, touchPoint.y, 14f, paint)
    }
}