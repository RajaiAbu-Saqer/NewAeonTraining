package com.newaeon.mahaapp.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.newaeon.mahaapp.R

class NotificationAdapter(private val items: List<NotificationModel>,val notificationCallback:NotificationCallback) :
    RecyclerView.Adapter<NotificationAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_layout, parent, false)
        return ItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.setOnClickListener {}
        val item = items[position]
        holder.xxxx(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemButton: Button = itemView.findViewById(R.id.btn)
        private val itemTextView: TextView = itemView.findViewById(R.id.tv_description)
        private val itemTextView2: TextView = itemView.findViewById(R.id.tv_2)
        private val itemTextView3: TextView = itemView.findViewById(R.id.tv_3)

        fun xxxx(item: NotificationModel) {
            itemTextView.text = item.title
            itemTextView2.text = item.firstDescription
            itemTextView3.text = item.secondDescription
//            itemButton.setOnClickListener {
//                notificationCallback.itemClicked(item)
//            }
            itemButton.setOnClickListener(object :View.OnClickListener{
                override fun onClick(v: View?) {
                    TODO("Not yet implemented")
                }
            })
        }
    }


    interface NotificationCallback {
        fun itemClicked(item: NotificationModel)

    }
}