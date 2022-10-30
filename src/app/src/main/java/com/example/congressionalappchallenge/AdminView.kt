package com.example.congressionalappchallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.congressionalappchallenge.databinding.AdminBinding
import com.example.congressionalappchallenge.databinding.LayoutStudentBinding
import com.example.congressionalappchallenge.databinding.StudentBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AdminView : Fragment() {

    private var _binding: AdminBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = AdminBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchView.addTextChangedListener { editable ->
            if (editable.isNullOrEmpty()) {
                showStudents(StudentRepository.students)
                return@addTextChangedListener
            }

            val filteredStudents = StudentRepository.students.filter { it.name.contains(editable.toString().lowercase()) }
            if (filteredStudents.isNotEmpty()) {
                showStudents(filteredStudents)
            }
        }
        binding.buttonSecond.setOnClickListener(){ editable ->
            binding.editStudentName.error = null

            val present = binding.editStudentStatus.isChecked
            val name = binding.editStudentName.text .toString()

            if(name.isEmpty()){
                binding.editStudentName.error = "Please enter any value"
                return@setOnClickListener
            }

            StudentRepository.addStudent(
                Student(
                    status = present,
                    name = name,
                    id = "0"
                )
            )
            val filteredStudents = StudentRepository.students.filter { it.name.contains(editable.toString().lowercase()) }
            if (filteredStudents.isNotEmpty()) {
                showStudents(filteredStudents)
            }

        }
        }

    override fun onResume() {
        super.onResume()
        showStudents(StudentRepository.students)
    }
    private fun showStudents(students: List<Student>) {
        binding.linearlayout.removeAllViews()

        students.forEach { student ->
            val studentBinding = LayoutStudentBinding.inflate(layoutInflater)
            studentBinding.textStudentName.text = student.name
            studentBinding.textStudentStatus.text = student.id

            val attendanceColorRes = if (student.status) android.R.color.holo_green_light else android.R.color.holo_red_light
            studentBinding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), attendanceColorRes))
            binding.linearlayout.addView(studentBinding.root)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}