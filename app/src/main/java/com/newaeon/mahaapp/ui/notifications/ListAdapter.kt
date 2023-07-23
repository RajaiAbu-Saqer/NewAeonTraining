package com.newaeon.mahaapp.ui.notifications

import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.newaeon.mahaapp.R

class ListAdapter (private val items: List<String>) :
    RecyclerView.Adapter<ListAdapter.ItemViewHolder>(), android.widget.ListAdapter {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_layout, parent, false)
        return ItemViewHolder(view)
    }



    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemButton: Button = itemView.findViewById(R.id.btn)
        private val itemTextView: TextView = itemView.findViewById(R.id.tv_description)

        fun bind(item: String) {
            itemTextView.text = item
            itemButton.setOnClickListener {
                // Perform action when the button is clicked
            }
        }
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
       return 10
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun areAllItemsEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(position: Int): Boolean {
        TODO("Not yet implemented")
    }
}