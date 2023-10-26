package com.rums.canvas_example

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rums.canvas_example.draw_with_finger.DrawWithFingerActivity
import com.rums.canvas_example.draw_with_finger_2.DotWithFingerActivity
import com.rums.canvas_example.move_dot_with_finger.MoveDotWithFingerActivity
import com.rums.gestures_example.adapter.CustomAdapter
import com.rums.gestures_example.adapter.OnItemClickListener

class MainActivity : Activity() {

    private lateinit var mContext: Context
    private lateinit var rv: RecyclerView
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
    }

    private fun initComponents() {
        mContext = this

        rv = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(mContext)

        val adapter = CustomAdapter(mContext, getTempTitles(), mOnItemClickListener)
        rv.adapter = adapter
    }

    private fun getTempTitles(): ArrayList<String> {
        val arrayList: ArrayList<String> = ArrayList()
        arrayList.add("Draw with finger")
        arrayList.add("Dot with finger")
        arrayList.add("Move dot with finger")

        return arrayList
    }

    private val mOnItemClickListener: OnItemClickListener = object : OnItemClickListener {
        override fun onItemClick(position: Int) {
            when (position) {
                0 -> {
                    startActivity(Intent(mContext, DrawWithFingerActivity::class.java))
                }

                1 -> {
                    startActivity(Intent(mContext, DotWithFingerActivity::class.java))
                }

                2 -> {
                    startActivity(Intent(mContext, MoveDotWithFingerActivity::class.java))
                }
            }
        }
    }
}