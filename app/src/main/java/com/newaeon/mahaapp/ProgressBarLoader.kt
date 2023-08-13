package com.newaeon.mahaapp

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import com.bumptech.glide.Glide
import com.newaeon.mahaapp.databinding.ProgressDialogBinding

class ProgressBarLoader(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val binding = ProgressDialogBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)
        Glide.with(context)
            .load(R.raw.loader)
            .into(binding.gifLoader)
    }
}