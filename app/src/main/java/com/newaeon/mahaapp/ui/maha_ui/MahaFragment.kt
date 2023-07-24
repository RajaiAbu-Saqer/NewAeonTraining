package com.newaeon.mahaapp.ui.maha_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.FragmentMahaBinding

class MahaFragment : Fragment() {
    private lateinit var _binding: FragmentMahaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMahaBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.name.setOnClickListener{
            findNavController().navigate(MahaFragmentDirections.actionNavigationMahaToNavigationNew(null))

        }
    }
}