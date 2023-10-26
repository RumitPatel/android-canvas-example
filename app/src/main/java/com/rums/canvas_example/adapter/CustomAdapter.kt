package com.rums.gestures_example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rums.canvas_example.R
import com.rums.gestures_example.adapter.CustomAdapter.MyViewHolder

class CustomAdapter(
    private val context: Context,
    arrTitles: ArrayList<String>,
    onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<MyViewHolder>() {
    private val inflater: LayoutInflater
    private var mArrTitles = ArrayList<String>()
    private lateinit var mOnItemClickListener: OnItemClickListener

    init {
        inflater = LayoutInflater.from(context)
        mArrTitles = arrTitles
        mOnItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.list_itme, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.serial_number.text = mArrTitles[holder.adapterPosition]

        holder.serial_number.setOnClickListener {
            mOnItemClickListener.onItemClick(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return mArrTitles.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var serial_number: TextView

        init {
            serial_number = itemView.findViewById<View>(R.id.serialNo_CL) as TextView
        }
    }
}

interface OnItemClickListener {
    fun onItemClick(position: Int)
}