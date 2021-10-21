package com.example.multipleactivities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class RVAdapter ( private val names: List<Contact>):  RecyclerView.Adapter<RVAdapter.ItemViewHolder>(){
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var list1 = names[position]

        holder.itemView.apply {
            textView4.text = list1.name
            textView5.text = list1.location
            textView6.text = list1.phone

        }
    }
    override fun getItemCount() = names.size
}