package com.example.congressionalappchallenge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AttendanceHelper {
    public String studentEmail;
    public String studentName;
    public int periodReturning = -1;
    public String attendanceReason = "None";

    private final FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    private final DatabaseReference reference = rootNode.getReference("users");

    public AttendanceHelper() {}

    public AttendanceHelper(String email) {
        setStudentEmail(email);
    }

    public AttendanceHelper(String email, int periodReturning) {
        setStudentEmail(email);
        setPeriodReturning(periodReturning);
    }

    public void setStudentEmail(String email) {
        studentEmail = email;
    }

    public void setStudentAbsentReason(String absentReason) {
        attendanceReason = absentReason;
    }

    public void setStudentName(String sName) {
        studentName = sName;
    }

    public void setPeriodReturning(int periodReturn) {
        periodReturning = periodReturn;
    }

    public int getPeriodReturning() { return periodReturning; }
    public String getStudentName() { return studentName; }
    public String getAttendanceReason() { return attendanceReason; }

    public void save() {
        Map<String, Object> hm = new HashMap<>();
        hm.put("periodReturning", getPeriodReturning());
        hm.put("attendanceReason", getAttendanceReason());

        reference.child("test").updateChildren(hm);
    }
}
