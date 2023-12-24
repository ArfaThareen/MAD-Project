package com.example.madnfm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

public class HigherEducationStudentsActivity extends AppCompatActivity {
    private ListView studentsListView;
    private ArrayAdapter<String> adapter;
    private String[]  higherEducation  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_higher_education_students);
        studentsListView = findViewById(R.id.studentsListView);


        // Replace the following code with your logic to fetch the list of placed students from a data source
         higherEducation = new String[]{
                "Rakshith Prasad",
                "Raghavendraraju S K",
                "Chandan A S",
                "Abin Willington",
                "Tek Rajkhati"

        };
        // Create an ArrayAdapter to display the list of placed students
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,higherEducation );
        // Set the adapter for the ListView
        studentsListView.setAdapter(adapter);
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterStudents(newText);
                return false;
            }
        });
        studentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Start the activity to display the student details
                String studentName = higherEducation[position];
                Intent intent = new Intent(HigherEducationStudentsActivity.this, StudentHigherDetails.class);
                intent.putExtra("studentName", studentName);
                startActivity(intent);
            }
        });

    }
    private void filterStudents(String query) {
        adapter.getFilter().filter(query);

        if (adapter.getCount() == 0) {
            Toast.makeText(this, "No students found", Toast.LENGTH_SHORT).show();
        }
    }
}