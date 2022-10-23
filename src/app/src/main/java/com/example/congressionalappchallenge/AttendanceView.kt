package com.example.congressionalappchallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.congressionalappchallenge.databinding.AdminBinding
import com.example.congressionalappchallenge.databinding.AttendanceBinding
import com.example.congressionalappchallenge.databinding.StudentBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AttendanceView : Fragment() {

    private var _binding: AttendanceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = AttendanceBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener("currentClass") { requestKey, bundle ->
            var ClassString = bundle.getString("Class")
            binding.textviewFirst.text = ClassString
            binding.button7.setOnClickListener {
                // Person Clicked Absent create function(ClassString, Absent)
            }
            binding.button4.setOnClickListener {
                // Person Clicked Present create function(ClassString, Present)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}