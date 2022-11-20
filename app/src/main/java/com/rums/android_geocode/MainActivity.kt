package com.rums.android_geocode

import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myCanvasView = MyCanvasView(this)
        myCanvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        myCanvasView.contentDescription = getString(R.string.app_name)
        setContentView(myCanvasView)


    }
}