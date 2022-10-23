package com.example.congressionalappchallenge;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AttendanceHelper {
    public String studentEmail;
    public boolean isPresentPeriod1;
    public boolean isPresentPeriod2;
    public boolean isPresentPeriod3;
    public boolean isPresentPeriod4;

    private final FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    private final DatabaseReference reference = rootNode.getReference("users");

    public AttendanceHelper(String email, boolean[] present) {
        setStudentEmail(email);
        setStudentAttendanceData(present);
    }

    public void setStudentEmail(String email) {
        studentEmail = email;
    }

    public void setStudentAttendanceData(boolean[] present) {
        isPresentPeriod1 = present[0];
        isPresentPeriod2 = present[1];
        isPresentPeriod3 = present[2];
        isPresentPeriod4 = present[3];
    }

    public void save() {
        reference.child("test").setValue(this);
    }
}
