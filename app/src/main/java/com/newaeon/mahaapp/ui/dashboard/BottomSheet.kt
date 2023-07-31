package com.newaeon.mahaapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.newaeon.mahaapp.R
import com.newaeon.mahaapp.databinding.BottomSheetBinding

class BottomSheet(val bottomSheetCallBack: BottomSheetCallBack) : BottomSheetDialogFragment() {
    private var binding: BottomSheetBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btn?.setOnClickListener {
            bottomSheetCallBack.navigate()
            dismiss()
        }
    }

    interface BottomSheetCallBack {
        fun navigate()
    }

}