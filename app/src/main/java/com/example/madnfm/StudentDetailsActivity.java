package com.example.madnfm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class StudentDetailsActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView rollNumberTextView;
    private TextView emailTextView;
    private TextView phoneNumberTextView;
    private TextView placedCompanyTextView;
    private Button viewPdfButton;
    private Map<String, Student> studentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        nameTextView = findViewById(R.id.nameTextView);
        rollNumberTextView = findViewById(R.id.rollNumberTextView);
        emailTextView = findViewById(R.id.emailTextView);
        phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
        placedCompanyTextView = findViewById(R.id.placedCompanyTextView);
        viewPdfButton = findViewById(R.id.offerLetterButton);

        // Initialize the student details map
        studentDetails = new HashMap<>();
        studentDetails.put("SUBHASH K V", new Student("SUBHASH K V", "1SJ19CS125", "subhashreddys178@gmail.com", "9876543210", "Wipro", "https://drive.google.com/file/d/1TAkAvCmkbFqXsym81Q7aZ_VYBiLnm6cZ/view?usp=sharing"));
        studentDetails.put("Harsha Prasanna", new Student("Harsha Prasanna", "1SJ19CS56", "jane.smith@example.com", "9876543210", "TEACHNOOK", "https://drive.google.com/file/d/1QFwVA94eeGOHvGD6EHGDemridDBl5ER0/view?usp=sharing"));
        studentDetails.put("Vaibhav Mishra", new Student("Vaibhav Mishra", "1SJ19CS89", "vibhav.johnson@example.com", "6785554358", "Alten Calsoft LabsIndia", "https://drive.google.com/file/d/1sz55e6mE5JKI5feAfAhODVLDn7uNv2ly/view?usp=sharing"));
        // Add more students and their PDF URLs as needed
        studentDetails.put("Arbaz Pasha P", new Student("Arbaz Pasha P", "1SJ19CS59", "arbaz.pasha@example.com", "9885554358", "Concentrix", "https://drive.google.com/file/d/1XLOw62-3qXrlyRTPnsSB7989voEpMH7L/view?usp=sharing"));
        studentDetails.put("Naveen A", new Student("Naveen A", "1SJ19CS159", "naveen.p123@example.com", "7685554358", "TEACHNOOK", "https://drive.google.com/file/d/1O69strGk5kSAK3HzY8-HEs5mCpWa-j6C/view?usp=sharing"));
        studentDetails.put("Swathi G", new Student("Swathi G", "1SJ19CS169", "swathi.g23@example.com", "8885554358", "ServiceNow", "https://drive.google.com/file/d/1J5RY0koUhh04XHIfOsHXh7rG6y4Vme38/view?usp=sharing"));
        studentDetails.put("Manju H", new Student("Manju H", "1SJ19CS119", "manju.g23@example.com", "9985554358", "Subex", "https://drive.google.com/file/d/1S6ju1xf0Oq8Xy_osKHOeJ4qf_VwamUgx/view?usp=sharing"));
        studentDetails.put("SREEDEEPTHI R", new Student("SREEDEEPTHI R", "1SJ19CS049", "shreedepthi.g23@example.com", "9685554358", "Wipro", "https://drive.google.com/file/d/1y4QEeN8eWLV-y7Txq43JmBk_imrds_86/view?usp=sharing"));



        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("studentName")) {
            String studentName = intent.getStringExtra("studentName"); // Replace with the desired student's name
            Student student = studentDetails.get(studentName);

            if (student != null) {
                // Set the student details in the TextViews
                nameTextView.setText("Name: " + student.getName());
                rollNumberTextView.setText("Roll Number: " + student.getRollNumber());
                emailTextView.setText("Email: " + student.getEmail());
                phoneNumberTextView.setText("Phone Number: " + student.getPhoneNumber());
                placedCompanyTextView.setText("Placed Company: " + student.getPlacedCompany());

                viewPdfButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(StudentDetailsActivity.this, WebViewActivity.class);
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
        private String placedCompany;
        private String pdfUrl;

        public Student(String name, String rollNumber, String email, String phoneNumber, String placedCompany, String pdfUrl) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.placedCompany = placedCompany;
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

        public String getPlacedCompany() {
            return placedCompany;
        }

        public String getPdfUrl() {
            return pdfUrl;
        }
    }
}
