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

public class CompetativeStudentDetails extends AppCompatActivity {
    private TextView nameTextView;
    private TextView rollNumberTextView;
    private TextView emailTextView;
    private TextView phoneNumberTextView;
    private TextView competativeExamTextView;
    private Button viewPdfButton;


    private Map<String, Student> studentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competative_student_details);
        nameTextView = findViewById(R.id.nameTextView);
        rollNumberTextView = findViewById(R.id.rollNumberTextView);
        emailTextView = findViewById(R.id.emailTextView);
        phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
        competativeExamTextView = findViewById(R.id.competativeExamTextView);
        viewPdfButton = findViewById(R.id.offerLetterButton);

        // Initialize the student details map
        studentDetails = new HashMap<>();
        studentDetails.put("Venu C", new Student("Venu C", "1sj19cs163", "venugopals5587@gmail.com", "8739464092", "GATE", "https://drive.google.com/file/d/16zr3MjcSqFh6Md83qRSSvZOTuc0nubJj/view?usp=sharing"));
        studentDetails.put("Akash Pratap Gowda", new Student("Akash Pratap Gowda", "1sj19cs013", "akashpratap@gmail.com", "9939464092", "GRE", "https://drive.google.com/file/d/1VY8BHBDSsizWfpYXOS5bcTpedBSdt9bS/view?usp=sharing"));
        studentDetails.put("Vamshi Reddy M L", new Student("Vamshi Reddy M L", "1sj19cs163", "vamshi@gmail.com", "8939464092", "PGCET", "https://drive.google.com/file/d/11UH-lXhS29o1QC1Iw-XnuF5PM-xfzQKj/view?usp=sharing"));
        studentDetails.put("Prakash H A", new Student("Prakash H A", "6000655", "prakash@gmail.com", "7939464092", "State Government Exams", "https://drive.google.com/file/d/1lPjAWqUsWAWRcR4hXtytSFHq7JVh51va/view?usp=sharing"));
        studentDetails.put("Shravani K P", new Student("Shravani K P", "EB365", "sharavani@gmail.com", "6639464092", "PGCET", "https://drive.google.com/file/d/12bIrCersU9nUWhBM_kfvqZznfdzh7pIt/view?usp=sharing"));

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
                competativeExamTextView.setText("Competitive Exam: " + student.getCompetativeExam());

                viewPdfButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(CompetativeStudentDetails.this, WebViewActivity.class);
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
        private String competativeExam;
        private String pdfUrl;


        public Student(String name, String rollNumber, String email, String phoneNumber, String competativeExam, String pdfUrl) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.competativeExam = competativeExam;
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

        public String getCompetativeExam() {
            return competativeExam;
        }

        public String getPdfUrl() {
            return pdfUrl;
        }
    }
}
