//package com.newaeon.mahaapp.ui
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.newaeon.mahaapp.R
//import com.newaeon.mahaapp.databinding.RecyclerViewBinding
//
//class RecyclerViewAdapter(private val dataList: List<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
//{
//    private lateinit var Binding : RecyclerViewBinding
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): RecyclerViewAdapter.ViewHolder {
//        TODO("Not yet implemented")
//    }
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = dataList[position]
//        holder.bind(item)
//    }
//
//    override fun getItemCount(): Int = dataList.size
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
//
//        fun bind(item: String) {
//            textViewTitle.text = item
//        }
//    }
//}
//
//
//
//
