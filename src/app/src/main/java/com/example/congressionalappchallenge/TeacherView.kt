package com.example.congressionalappchallenge

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.congressionalappchallenge.databinding.TeacherBinding
import com.example.congressionalappchallenge.databinding.TeacherRowBinding
import com.google.firebase.database.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.Objects
import kotlin.reflect.typeOf

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TeacherView : Fragment() {

    private var _binding: TeacherBinding? = null
    private var mRef: DatabaseReference? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = TeacherBinding.inflate(inflater, container, false)
        mRef = FirebaseDatabase.getInstance().getReference("users")

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRef?.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.linearlayout.removeAllViews()
                for (dataSnap in snapshot.children) {
                    val user = JSONObject(dataSnap.value.toString())

                    val newBinding = TeacherRowBinding.inflate(layoutInflater)
                    newBinding.textStudentName.text = user.getString("studentName")
                    newBinding.textStudentRollno.text = "Returning period " + user.getInt("periodReturning").toString()
                    newBinding.textStudentEmail.text = user.getString("studentEmail")

                    binding.linearlayout.addView(newBinding.root)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showStudents() {
        binding.linearlayout.removeAllViews()

        val teacherBinding = TeacherRowBinding.inflate(layoutInflater)
        teacherBinding.textStudentName.text = "Rikhil"
        teacherBinding.textStudentRollno.text = "1"

        //val attendanceColorRes = if (student.present) android.R.color.holo_green_light else android.R.color.holo_red_light
        //studentBinding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), attendanceColorRes))
        binding.linearlayout.addView(teacherBinding.root)
    }
}