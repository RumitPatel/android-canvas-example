package com.rums.canvas_example.utils

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.rums.canvas_example.R

object Utils {

}

fun View.setBGDrawable(context: Context, resourceId: Int) {
    this.background = ContextCompat.getDrawable(context, resourceId)
}

fun Context.getRoundLp(): LinearLayout.LayoutParams {
    val lpRound = LinearLayout.LayoutParams(roundHW(), roundHW())
    lpRound.setMargins(10, 10, 10, 10)
    return lpRound
}

fun Context.roundHW(): Int {
    return resources.getDimension(R.dimen.btn_h_w).toInt()
}

fun getDrawlFromType(type: Int): Int {
    return when (type) {
        0 -> {
            R.drawable.round_default
        }
        1 -> {
            R.drawable.round_blue
        }
        2 -> {
            R.drawable.round_green
        }
        3 -> {
            R.drawable.round_red
        }
        else -> {
            R.drawable.round_else
        }
    }
}