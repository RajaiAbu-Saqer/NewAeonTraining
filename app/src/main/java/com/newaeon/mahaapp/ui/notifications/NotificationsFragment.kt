package com.newaeon.mahaapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.newaeon.mahaapp.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

private lateinit var binding: FragmentNotificationsBinding

override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    binding = FragmentNotificationsBinding.inflate(inflater, container, false)
    return binding.root
}

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    val itemClickListener = View.OnClickListener { view ->
        // Handle item button click here
        val position = binding.recyclerView.getChildAdapterPosition(view)
        val selectedItem = items[position]
        // Do something with the selected item
    }

    val adapter = com.newaeon.mahaapp.ui.notifications.ListAdapter(items)
    binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    binding.recyclerView.adapter = adapter
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