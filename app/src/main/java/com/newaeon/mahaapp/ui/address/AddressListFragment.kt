package com.newaeon.mahaapp.ui.address

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.newaeon.mahaapp.MainActivity
import com.newaeon.mahaapp.base_ui.BaseFragment
import com.newaeon.mahaapp.databinding.AddressesListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class AddressListFragment : BaseFragment() {
    private var binding: AddressesListBinding? = null

    private var userAddressesvViewModel: AddressListViewModel? = null

    // shared preference for token
    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null


//     override fun initToolbar() {
//         super.initToolbar()
//         (activity as MainActivity).setTitleToolbar("eofjewifjewi")
//         (activity as MainActivity).setTitleToolbar("eofjewifjewi")
//         (activity as MainActivity).setTitleToolbar("eofjewifjewi")
//         (activity as MainActivity).setTitleToolbar("eofjewifjewi")
//     }

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




        // to send data from screen to another
        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        );  // private to prevent share it  with another app

        userAddressesvViewModel =
            ViewModelProvider(this)[AddressListViewModel::class.java]

        userAddressesvViewModel?.getAddresses?.observe(viewLifecycleOwner) { addressResponse ->
            addressResponse.data?.let {
                addressesAdapter(it)
            }
        }

        userAddressesvViewModel?.isAddressDeleted?.observe(viewLifecycleOwner) {
            adapter?.items?.remove(it)
            adapter?.notifyDataSetChanged()
        }
//        userAddressesvViewModel?.getAddresses?.observe(viewLifecycleOwner) {
//
//            adapter?.items?.remove(it)
//            adapter?.notifyDataSetChanged()
//
//        }
        userAddressesvViewModel?.getAddressesError?.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() { // used to prevent hit api every open the screen; only first time access it "if delete or edit
        //keep the user in same scrolling
        super.onResume()
//      if(userAddressesvViewModel?.getAddresses?.value==null)

        CoroutineScope(Dispatchers.IO).launch {
            userAddressesvViewModel?.getUserAdresses(
                sharedPreferences?.getString(KEY_NAME, "") ?: ""
            )
        }
    }

    private var adapter: AddressesAdapter? = null
    private fun addressesAdapter(items: ArrayList<GetCustomerAddressesData>) {
        adapter = AddressesAdapter(items, deleteClicked = {
            CoroutineScope(Dispatchers.IO).launch {
                userAddressesvViewModel?.deleteCustomerAddress(
                    it,
                    sharedPreferences?.getString(KEY_NAME, "") ?: ""
                )
            }

        }, editClicked = {

            findNavController().navigate(
                AddressListFragmentDirections.actionUserAddressesToEditAddress(
                    it
                )
            )
        })
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = adapter


    }

}