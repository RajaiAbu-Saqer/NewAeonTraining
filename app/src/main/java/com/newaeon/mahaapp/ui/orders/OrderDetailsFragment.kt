package com.newaeon.mahaapp.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.newaeon.mahaapp.databinding.OrderDetailsBinding

class OrderDetailsFragment : Fragment() {
    private var binding : OrderDetailsBinding ?=null
    private val navArgs by navArgs<OrderDetailsFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OrderDetailsBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(context, navArgs.myOrdersData.toString(), Toast.LENGTH_LONG).show()
    }
}