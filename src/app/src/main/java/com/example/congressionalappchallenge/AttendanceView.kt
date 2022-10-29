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
        setFragmentResultListener("currentClass") { requestKey, bundle ->
            val classString = bundle.getString("Class")
            var periodNumber = bundle.getString("Class Number")

            binding.textviewFirst.text = classString

            binding.submitAttendanceReport.setOnClickListener {
                // Person pressed the button
                val attendanceReason = (binding.attendanceReason.text).toString()
                val attendancePeriod = (binding.attendancePeriod.text).toString()
                val numAttendancePeriod = attendancePeriod.toInt()

                var attendanceTab = booleanArrayOf(false, false, false, false)

                if (attendanceReason == "None") {
                    attendanceTab = booleanArrayOf(false, false, false, false)
                }
                else {
                    for (i in 0..numAttendancePeriod - 1) {
                        attendanceTab[i] = false
                    }

                    for (i in numAttendancePeriod - 1..3) {
                        attendanceTab[i] = true
                    }
                }

                attendance.setStudentAttendanceData(attendanceTab)
                attendance.save()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}