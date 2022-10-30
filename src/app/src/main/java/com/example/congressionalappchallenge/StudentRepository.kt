package com.example.congressionalappchallenge

data class Student(
    val id: String,
    val name: String,
    val status: Boolean = false
)

object StudentRepository {

    val students = mutableListOf<Student>()

    init {
        students.add(
            Student(
                id = "",
                name = "",
                status = false
            ))
    }
    fun addStudent(student: Student) {
        students.add(student)
    }

}