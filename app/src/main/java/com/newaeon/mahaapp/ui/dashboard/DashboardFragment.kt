package com.newaeon.mahaapp.ui.dashboard
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)


        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        binding.textDashboard.setOnClickListener {
            val bottomSheetFragment = BottomSheet(object : BottomSheet.BottomSheetCallBack{
                override fun navigate() {
           findNavController().navigate(DashboardFragmentDirections.firstNaivgation())
                }

            })
            bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}