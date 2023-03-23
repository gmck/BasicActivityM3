package com.companyname.basicactivitym3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.companyname.basicactivitym3.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

//        ChatGPT suggested this - but it doesn't work - you don't get the predictive back gesture.
//        val onBackPressedCallback = object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                if (isEnabled) {
//                    isEnabled = false // disable the callback
//                    requireActivity().onBackPressedDispatcher.onBackPressed() // trigger the predictive back gesture
//                }
//            }
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,onBackPressedCallback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}