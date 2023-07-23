package com.newaeon.mahaapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.newaeon.mahaapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        homeViewModel.jokeLiveData.observe(viewLifecycleOwner) { joke ->
            // Update UI with the retrieved joke
           binding?.textHome?.text=joke
        }

//        binding.callApi.setOnClickListener{
//            CoroutineScope(Dispatchers.IO).launch {
//                homeViewModel.fetchRandomJoke("MyApp/1.0")
//
//            }
//
//        }
        // Fetch a random joke when the activity starts
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}