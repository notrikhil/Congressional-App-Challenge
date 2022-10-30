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
    private var attendance = AttendanceHelper("student@example.com")

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
        binding.submitAttendanceReport.setOnClickListener {
            // Person pressed the button
            val attendanceReason = (binding.attendanceReason.text).toString()
            val attendancePeriod = (binding.attendancePeriod.text).toString()

            var numAttendancePeriod = -1
            if (attendancePeriod != "") {
                numAttendancePeriod = attendancePeriod.toInt()
            }

            attendance.setPeriodReturning(numAttendancePeriod)
            attendance.setStudentAbsentReason(attendanceReason)
            attendance.save()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}