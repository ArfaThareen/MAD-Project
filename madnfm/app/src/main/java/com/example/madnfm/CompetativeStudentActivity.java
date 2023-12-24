package com.example.madnfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.madnfm.CompetativeStudentActivity;

import android.os.Bundle;

public class CompetativeStudentActivity extends AppCompatActivity {
    private ListView studentsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competative_student);
        studentsListView = findViewById(R.id.studentsListView);

        // Replace the following code with your logic to fetch the list of placed students from a data source
        String[] competativeExam = {
                "Venu C",
                "Akash Pratap Gowda",
                "Prakash H A",
                "Shravani K P",
                " kiran"
        };
        // Create an ArrayAdapter to display the list of placed students
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, competativeExam);

        // Set the adapter for the ListView
        studentsListView.setAdapter(adapter);
        studentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Start the activity to display the student details
                Intent intent = new Intent(CompetativeStudentActivity.this, CompetativeStudentDetails.class);
                intent.putExtra("studentName", competativeExam[position]);
                startActivity(intent);
            }
        });
    }
}