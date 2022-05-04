package com.silva.murillo.developingandroid.digital.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.silva.murillo.developingandroid.digital.enumClass.SharedType
import com.silva.murillo.developingandroid.R

class SharedAdapter(
    val listType: MutableList<SharedType>
) : RecyclerView.Adapter<SharedAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgResource: ImageView
        init {
            imgResource = view.findViewById(R.id.imgItemShared)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.container_items_shared, parent, false)
        return MyViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = listType.size
}
