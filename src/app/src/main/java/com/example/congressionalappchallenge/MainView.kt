package com.example.congressionalappchallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.congressionalappchallenge.databinding.HomeBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainView : Fragment() {

    private var _binding: HomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst6.setOnClickListener {
            val email = (binding.editTextTextEmailAddress.text).toString()
            val pass = (binding.editTextTextPassword.text).toString()
            if (email == "student@example.com" && pass == "test") {
                findNavController().navigate(R.id.mainToAttendance)
            }
            if (email == "admin@example.com" && pass == "test"){
                findNavController().navigate(R.id.action_FirstFragment_to_adminView)
            }
            if (email == "teacher@example.com" && pass == "test"){
                findNavController().navigate(R.id.action_FirstFragment_to_TeacherView)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}