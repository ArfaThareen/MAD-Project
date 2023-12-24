package com.example.madnfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class StudentHigherDetails extends AppCompatActivity {
    private TextView nameTextView;
    private TextView rollNumberTextView;
    private TextView emailTextView;
    private TextView phoneNumberTextView;
    private TextView courseNameTextView;
    private Button viewPdfButton;
    private Map<String, Student> studentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_higher_details);

        nameTextView = findViewById(R.id.nameTextView);
        rollNumberTextView = findViewById(R.id.rollNumberTextView);
        emailTextView = findViewById(R.id.emailTextView);
        phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
        courseNameTextView = findViewById(R.id.courseNameTextView);
        viewPdfButton = findViewById(R.id.offerLetterButton);

        // Initialize the student details map
        studentDetails = new HashMap<>();

        studentDetails.put("Rakshith Prasad", new Student("Rakshith Prasad", "1sj19cs113", "rakshit5587@gmail.com", "9739464092", "Master's in Business Analytics", "https://drive.google.com/file/d/1HbNfYixp0_xoC-OHGjBLMwhGsWSRKtVz/view?usp=sharing"));
        studentDetails.put("Raghavendraraju S K", new Student("Raghavendraraju S K", "1sj19cs183", "raghavendra5587@gmail.com", "7739464092",  " M Tech", "https://drive.google.com/file/d/1qYPlI39xHksL5m6-75cNt16oHHAzgZdF/view?usp=sharing"));
        studentDetails.put("Chandan A S", new Student("Chandan A S", "1sj19cs013", "chandan5587@gmail.com", "9039464092",  " M Tech", "https://drive.google.com/file/d/1USdeGgoKw5Eqi9S6CriHM8ztPYllEDXw/view?usp=sharing"));
        studentDetails.put("Abin Willington", new Student("Abin Willington", "1sj19cs010", "willington5587@gmail.com", "8039464092",  " M Tech", "https://drive.google.com/file/d/1oSAphMjabDo_vX9r5kA8oK6PoMi3Xh8e/view?usp=sharing"));
        studentDetails.put("Tek Rajkhati", new Student("Tek Rajkhati", "1sj19cs110", "teakrajkhati@gmail.com", "6639464092",  " MS", "https://drive.google.com/file/d/1MfsRZ2sWllMXQgeFjUYtMaNEbNo7jJNf/view?usp=sharing"));


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("studentName")) {
            String studentName = intent.getStringExtra("studentName");
            Student student = studentDetails.get(studentName);

            if (student != null) {
                // Set the student details in the TextViews
                nameTextView.setText("Name: " + student.getName());
                rollNumberTextView.setText("Roll Number: " + student.getRollNumber());
                emailTextView.setText("Email: " + student.getEmail());
                phoneNumberTextView.setText("Phone Number: " + student.getPhoneNumber());
                courseNameTextView.setText("Course Name: " + student.getCourseName());

                viewPdfButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(StudentHigherDetails.this, WebViewActivity.class);
                        intent.putExtra("pdfUrl", student.getPdfUrl());
                        startActivity(intent);
                    }
                });

            }
        }
    }

    // Student class to hold the student details
    private static class Student {
        private String name;
        private String rollNumber;
        private String email;
        private String phoneNumber;
        private String courseName;
        private String pdfUrl;

        public Student(String name, String rollNumber, String email, String phoneNumber, String courseName, String pdfUrl) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.courseName = courseName;
            this.pdfUrl = pdfUrl;
        }

        public String getName() {
            return name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getCourseName() {
            return courseName;
        }

        public String getPdfUrl() {
            return pdfUrl;
        }
    }
}
