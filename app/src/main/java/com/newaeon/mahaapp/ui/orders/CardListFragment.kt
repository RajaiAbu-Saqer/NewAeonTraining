package com.newaeon.mahaapp.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.newaeon.mahaapp.R
import com.newaeon.mahaapp.databinding.OrderListBinding

class CardListFragment : Fragment() {

    private  var binding :OrderListBinding ?=null
    private lateinit var adapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding = OrderListBinding.inflate(inflater,container,false)
return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = CardAdapter()
        binding.recyclerView.adapter = adapter
        val items = listOf(
            Item("Item 1", "Description for Item 1"),
            Item("Item 2", "Description for Item 2"),
            Item("Item 3", "Description for Item 3")
        )
        adapter.submitList(items)
    }
}