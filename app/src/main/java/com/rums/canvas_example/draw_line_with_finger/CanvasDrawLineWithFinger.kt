package com.rums.canvas_example.draw_line_with_finger

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.core.content.res.ResourcesCompat
import com.rums.canvas_example.R

class CanvasDrawLineWithFinger @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    companion object {
        private const val STROKE_WIDTH = 12f
    }

    private var path = Path()

    private val paths = ArrayList<Path>()

    private val extraCanvas: Canvas? = null

    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f

    private var currentX = 0f
    private var currentY = 0f

    private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop

    private val paint = Paint().apply {
        color = ResourcesCompat.getColor(resources, R.color.black, null)
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = STROKE_WIDTH
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (path in paths) {
            canvas.drawPath(path, paint)
        }
        canvas.drawPath(path, paint)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false

        motionTouchEventX = event.x
        motionTouchEventY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.reset()
                path.moveTo(motionTouchEventX, motionTouchEventY)
                currentX = motionTouchEventX
                currentY = motionTouchEventY
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                val distanceX = kotlin.math.abs(motionTouchEventX - currentX)
                val distanceY = kotlin.math.abs(motionTouchEventY - currentY)

//                if (distanceX >= touchTolerance || distanceY >= touchTolerance) { //comment due to (print dot issue on touch)
                    path.quadTo(
                        currentX,
                        currentY,
                        (motionTouchEventX + currentX) / 2,
                        (currentY + motionTouchEventY) / 2
                    )
                    currentX = motionTouchEventX
                    currentY = motionTouchEventY
//                }
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                path.lineTo(currentX, currentY)
                extraCanvas?.drawPath(path, paint)
                paths.add(path)
                path = Path()
            }
        }
        return true
    }
}