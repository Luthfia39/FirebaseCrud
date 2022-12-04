package com.example.firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SubjectActivity extends AppCompatActivity {
    EditText mInputSubject, mInputTeacher, mUpdateSubject, mUpdateTeacher;
    DatabaseReference mDatabaseReference;
    Subject subject_from_firebase;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Subject.class.getSimpleName());

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(v.getContext(), MainActivity.class);
                startActivity(backIntent);
            }
        });

        mInputSubject = findViewById(R.id.input_subject);
        mInputTeacher = findViewById(R.id.input_teacher);

        mUpdateSubject = findViewById(R.id.update_subject);
        mUpdateTeacher = findViewById(R.id.update_teacher);

        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        findViewById(R.id.btn_read).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
            }
        });

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
    }

    private void insertData() {
        Subject subject = new Subject();
        String subject_name = mInputSubject.getText().toString();
        String teacher_name = mInputTeacher.getText().toString();

        if (subject_name != "" && teacher_name != ""){
            subject.setSubject(subject_name);
            subject.setTeacher(teacher_name);

            mDatabaseReference.push().setValue(subject);
            Toast.makeText(this, "Insert Success", Toast.LENGTH_SHORT).show();
        }
    }

    private void showData() {
        subject_from_firebase = new Subject();
        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()){
                    for (DataSnapshot currentData : snapshot.getChildren()){
                        key = currentData.getKey();
                        subject_from_firebase.setSubject(currentData.child("subject").getValue().toString());
                        subject_from_firebase.setTeacher(currentData.child("teacher").getValue().toString());
                    }
                }
                mUpdateSubject.setText(subject_from_firebase.getSubject());
                mUpdateTeacher.setText(subject_from_firebase.getTeacher());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void updateData() {
        Subject updateSubject = new Subject();
        updateSubject.setSubject(mUpdateSubject.getText().toString());
        updateSubject.setTeacher(mUpdateTeacher.getText().toString());

        mDatabaseReference.child(key).setValue(updateSubject);
        Toast.makeText(this, "Update Success", Toast.LENGTH_SHORT).show();
    }

    private void deleteData(){
        Subject deleteSubject = new Subject();
        deleteSubject.setSubject(mUpdateSubject.getText().toString());
        deleteSubject.setTeacher(mUpdateTeacher.getText().toString());
        mDatabaseReference.child(key).removeValue();
        Toast.makeText(this, "Delete Success", Toast.LENGTH_SHORT).show();
    }
}