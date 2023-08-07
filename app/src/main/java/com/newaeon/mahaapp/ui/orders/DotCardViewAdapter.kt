package com.newaeon.mahaapp.ui.orders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.newaeon.mahaapp.R

class  DotCardViewAdapter(private val context: Context, private val items: List<DotCardItem>) :
RecyclerView.Adapter<DotCardViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.layout_dot_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        // Bind card content here (e.g., holder.cardView.title.text = item.title)

        setupDots(holder, items.size, position)
    }

    private fun setupDots(holder: ViewHolder, count: Int, selectedPosition: Int) {
        holder.dotsLayout.removeAllViews()

        val dotSize = context.resources.getDimensionPixelSize(R.dimen.dot_size)
        val dotMargin = context.resources.getDimensionPixelSize(R.dimen.dot_margin)

        for (i in 0 until count) {
            val dot = View(context)
            dot.setBackgroundResource(if (i == selectedPosition) R.drawable.selected_dot else R.drawable.default_dots)
            val params = LinearLayout.LayoutParams(dotSize, dotSize)
            params.marginStart = dotMargin
            params.marginEnd = dotMargin
            dot.layoutParams = params
            holder.dotsLayout.addView(dot)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.cardView
        val dotsLayout = itemView.dotsLayout
    }

}