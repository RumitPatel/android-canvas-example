package com.rums.canvas_example

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.core.content.res.ResourcesCompat
import kotlin.math.abs

class UndoCanvasCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    companion object {
        private const val STROKE_WIDTH = 12f
    }

    private var path = Path()

    private val paths = ArrayList<Path>()
    private val undonePaths = ArrayList<Path>()

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

    fun resetCanvasDrawing() {
        path.reset() // Avoiding saving redo from Path()
        paths.clear()
        invalidate()
    }

    fun undoCanvasDrawing() {
        if (paths.size > 0) {
            undonePaths.add(paths.removeAt(paths.size - 1))
            invalidate()
        } else {
            Log.d("UNDO_ERROR", "Something went wrong with UNDO action")
        }
    }

    fun redoCanvasDrawing() {
        if (undonePaths.size > 0) {
            paths.add(undonePaths.removeAt(undonePaths.size - 1))
            invalidate()
        } else {
            Log.d("REDO_ERROR", "Something went wrong with REDO action")
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (Path in paths) {
            canvas?.drawPath(Path, paint)
        }
        canvas?.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false

        motionTouchEventX = event.x
        motionTouchEventY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                undonePaths.clear()
                path.reset()
                path.moveTo(motionTouchEventX, motionTouchEventY)
                currentX = motionTouchEventX
                currentY = motionTouchEventY
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                val distanceX = abs(motionTouchEventX - currentX)
                val distanceY = abs(motionTouchEventY - currentY)

                if (distanceX >= touchTolerance || distanceY >= touchTolerance) {
                    path.quadTo(
                        currentX,
                        currentY,
                        (motionTouchEventX + currentX) / 2,
                        (currentY + motionTouchEventY) / 2
                    )
                    currentX = motionTouchEventX
                    currentY = motionTouchEventY
                }
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