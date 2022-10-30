package com.example.congressionalappchallenge;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AttendanceRetrieverHelper {
    ArrayList<AttendanceHelper> arr;

    public AttendanceRetrieverHelper() {}

    public ArrayList<AttendanceHelper> getStudents(DatabaseReference mRef) {
        arr = new ArrayList<>();
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnap: snapshot.getChildren()) {
                    AttendanceHelper user = dataSnap.getValue(AttendanceHelper.class);

                    if (user != null) {
                        System.out.println("HERE");
                        arr.add(user);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return arr;
    }
}
