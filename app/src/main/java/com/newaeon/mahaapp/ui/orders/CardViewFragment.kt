package com.newaeon.mahaapp.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.newaeon.mahaapp.databinding.OrderCellBinding

class CardViewFragment : Fragment() {

    private  var binding: OrderCellBinding ?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OrderCellBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access the CardView and modify its content if needed
        val cardView: CardView = binding?.cardView!!
        // Modify the content of the CardView, e.g., set text, images, etc.
    }
}