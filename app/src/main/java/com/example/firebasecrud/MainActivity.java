package com.example.firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
//    EditText mName, mAddress, mUpdateName, mUpdateAddress;
//    DatabaseReference mDatabaseReference;
//    Student student_from_firebase;
//    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_to_student).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentIntent = new Intent(v.getContext(), StudentActivity.class);
                startActivity(studentIntent);
            }
        });

        findViewById(R.id.btn_to_subject).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subjectIntent = new Intent(v.getContext(), SubjectActivity.class);
                startActivity(subjectIntent);
            }
        });

//        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Student.class.getSimpleName());
//
//        mName = findViewById(R.id.input_name);
//        mAddress = findViewById(R.id.input_address);
//
//        mUpdateName = findViewById(R.id.update_name);
//        mUpdateAddress = findViewById(R.id.update_address);
//
//        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                insertData();
//            }
//        });
//
//        findViewById(R.id.btn_read).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showData();
//            }
//        });
//
//        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                updateData();
//            }
//        });
//
//        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteData();
//            }
//        });
    }

//    private void insertData() {
//        Student student = new Student();
//        String name = mName.getText().toString();
//        String address = mAddress.getText().toString();
//
//        if (name != "" && address != ""){
//            student.setName(name);
//            student.setAddress(address);
//
//            mDatabaseReference.push().setValue(student);
//            Toast.makeText(this, "Insert Success", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void showData() {
//        student_from_firebase = new Student();
//        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.hasChildren()){
//                    for (DataSnapshot currentData : snapshot.getChildren()){
//                        key = currentData.getKey();
//                        student_from_firebase.setName(currentData.child("name").getValue().toString());
//                        student_from_firebase.setAddress(currentData.child("address").getValue().toString());
//                    }
//                }
//                mUpdateName.setText(student_from_firebase.getName());
//                mUpdateAddress.setText(student_from_firebase.getAddress());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//
//    private void updateData() {
//        Student updateStudent = new Student();
//        updateStudent.setName(mUpdateName.getText().toString());
//        updateStudent.setAddress(mUpdateAddress.getText().toString());
//
//        mDatabaseReference.child(key).setValue(updateStudent);
//        Toast.makeText(this, "Update Success", Toast.LENGTH_SHORT).show();
//    }
//
//    private void deleteData(){
//        Student deleteStudent = new Student();
//        deleteStudent.setName(mUpdateName.getText().toString());
//        deleteStudent.setAddress(mUpdateAddress.getText().toString());
//        mDatabaseReference.child(key).removeValue();
//        Toast.makeText(this, "Delete Success", Toast.LENGTH_SHORT).show();
//    }
}