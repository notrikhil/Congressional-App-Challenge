package com.example.congressionalappchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.congressionalappchallenge.databinding.TeacherBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TeacherView : Fragment() {

    private var _binding: TeacherBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = TeacherBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.button5.setOnClickListener {
            findNavController().navigate(R.id.action_TeacherView_to_attendanceView)
            val bundle = Bundle()
            bundle.putString("Class", "Class 1")
            setFragmentResult("currentClass", bundle)
            }
        binding.button6.setOnClickListener {
            findNavController().navigate(R.id.action_TeacherView_to_attendanceView)
            val bundle = Bundle()
            bundle.putString("Class", "Class 2")
            setFragmentResult("currentClass", bundle)
        }
        binding.button7.setOnClickListener {
            findNavController().navigate(R.id.action_TeacherView_to_attendanceView)
            val bundle = Bundle()
            bundle.putString("Class", "Class 3")
            setFragmentResult("currentClass", bundle)
        }
        binding.button8.setOnClickListener {
            findNavController().navigate(R.id.action_TeacherView_to_attendanceView)
            val bundle = Bundle()
            bundle.putString("Class", "Class 4")
            setFragmentResult("currentClass", bundle)
        }

//        binding.button6.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}