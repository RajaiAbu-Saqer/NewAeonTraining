package com.newaeon.mahaapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.newaeon.mahaapp.databinding.FragmentNotificationsBinding

class NotificationsFragment() : Fragment() {

    private lateinit var binding: FragmentNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun getAdapterList() =
        listOf(
            NotificationModel("title 1", "title 2 ", "title 3 "),
            NotificationModel("title 4", "title 5 ", "title 6 "),
            NotificationModel("title 7", "title 8 ", "title 9 ")


        )

    fun onResume(value: String, value2: String) {

        Toast.makeText(activity, "OnResume", Toast.LENGTH_SHORT).show()
    }

    fun onResume(value: Int, value2: String) {

        Toast.makeText(activity, "OnResume", Toast.LENGTH_SHORT).show()
    }
    companion object{
        val sara="Sara"
    }
    private val maha="Sara"
    override fun onResume() {
        super.onResume()

        Toast.makeText(activity, "OnResume", Toast.LENGTH_SHORT).show()
    }

    //    override fun onResume() {
//        super.onResume()
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NotificationAdapter(getAdapterList(),
            object : NotificationAdapter.NotificationCallback {
                override fun itemClicked(item: NotificationModel) {
                    findNavController().navigate(
                        NotificationsFragmentDirections.actionNavigationNotificationsToFragmentNews2(
                            item
                        )
                    )
                }
            })
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter


        // Show the bottom sheet when a button is clicked (for demonstration purposes)
//        binding.btnBtmSheet.setOnClickListener {
//            val bottomSheetFragment = BottomSheet()
//            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
//        }


    }
}


// This property is only valid between onCreateView and
// onDestroyView.
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val notificationsViewModel =
//            ViewModelProvider(this).get(NotificationsViewModel::class.java)
//
//        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        val textView: TextView = binding.textNotifications
//        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
//        return root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}