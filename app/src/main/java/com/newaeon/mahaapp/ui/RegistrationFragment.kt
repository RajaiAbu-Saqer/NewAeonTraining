package com.newaeon.mahaapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.newaeon.mahaapp.R
import com.newaeon.mahaapp.databinding.RegistrationBinding

class RegistrationFragment : Fragment() {
    //send arg from screen to another
    private val args by navArgs<RegistrationFragmentArgs>()

    private lateinit var binding: RegistrationBinding
    private val tabTitles by lazy {
        arrayOf( getString(R.string.login), getString(R.string.register))
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = activity?.let {
            ViewPagerAdapter(it, LoginFragment(), CreateAccountFragment())
        }

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()


        Toast.makeText(activity, args.name, Toast.LENGTH_SHORT).show()

    }
}