package com.example.congressionalappchallenge;

import android.app.DownloadManager;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AttendanceRetrieverHelper {
    String name;

    public AttendanceRetrieverHelper(String userName) {
        name = userName;
    }

    public AttendanceHelper getStudentIsPresent() {
        Query checkUser = FirebaseDatabase.getInstance().getReference("users").orderByChild("userName").equalTo(name);
        final AttendanceHelper[] result = new AttendanceHelper[1];

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    result[0] = snapshot.getValue(AttendanceHelper.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                result[0] = null;
            }
        });

        return result[0];
    }
}
