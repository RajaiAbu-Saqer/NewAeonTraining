package com.newaeon.mahaapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.R
import com.newaeon.mahaapp.databinding.MenuBinding

class MenuFragment : Fragment(), OnClickListener, WebViewFragment.FragmentCommunication {
    private var binding: MenuBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetJavaScriptEnabled")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.tvPrivacyPolicy?.setOnClickListener(this)
        binding?.tvAboutUs?.setOnClickListener(this)
        binding?.tvAddress?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding?.tvPrivacyPolicy?.id -> {
                webview1()
            }

            binding?.tvAboutUs?.id -> {
                webview2()
            }

            binding?.tvAddress?.id -> {
                findNavController().navigate(MenuFragmentDirections.actionMenuToUserAddresses())
            }
        }
    }


    private inner class MyWebViewClient : WebViewClient() {
        // Override URL loading to load all URLs within the WebView
        @Deprecated("Deprecated in Java")
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url ?: "")
            return true
        }
    }

    override fun webview1() {
        binding?.webView1?.apply {
            settings.javaScriptEnabled = true
            webViewClient = MyWebViewClient()
            loadUrl("http://www.alesayidistribution.com/mobilehtml/privacy.html")
        }
    }

    override fun webview2() {
        binding?.webView2?.apply {
            settings.javaScriptEnabled = true
            webViewClient = MyWebViewClient()
            loadUrl("http://www.alesayidistribution.com/mobilehtml/aboutAR.html")
        }
    }
}