package com.newaeon.mahaapp.ui.address

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.newaeon.mahaapp.databinding.AddressesListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddressListFragment : Fragment() {
    private var binding: AddressesListBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddressesListBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userAddressesvViewModel =
            ViewModelProvider(this)[AddressListViewModel::class.java]
        CoroutineScope(Dispatchers.IO).launch {
            userAddressesvViewModel.getUserAdresses()

        }

        userAddressesvViewModel.getAddresses.observe(viewLifecycleOwner) { addressResponse ->
            addressesAdapter(addressResponse.data)
        }
        userAddressesvViewModel.getAddressesError.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    private fun addressesAdapter(items: List<GetCustomerAddressesData>) {
        val adapter = AddressesAdapter(items)
        binding?.recyclerView?.setOnClickListener() {
            findNavController().navigate(AddressListFragmentDirections.actionUserAddressesToEditAddress())
        }

        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = adapter


    }
}