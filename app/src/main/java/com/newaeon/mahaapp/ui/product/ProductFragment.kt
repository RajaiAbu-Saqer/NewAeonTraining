package com.newaeon.mahaapp.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.newaeon.mahaapp.databinding.FragmentProductBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductFragment : Fragment() {
    private var binding: FragmentProductBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productViewModel =
            ViewModelProvider(this)[ProductViewModel::class.java]
        CoroutineScope(Dispatchers.IO).launch {
            productViewModel.getAllProduct()

        }

        productViewModel.productResponse.observe(viewLifecycleOwner) { productResponse ->
            productAdapter(productResponse.data)
        }
        productViewModel.productResponseError.observe(viewLifecycleOwner) { productResponseError ->

        }
    }

    private fun productAdapter(items: List<GetAllProductsData>) {
        val adapter = ProductAdapter(items)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = adapter
    }
}