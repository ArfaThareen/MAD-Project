package com.example.madnfm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class PlacedStudentsActivity extends AppCompatActivity {
    private ListView studentsListView;
    private ArrayAdapter<String> adapter;
    private String[] placedStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placed_students);
        studentsListView = findViewById(R.id.studentsListView);

        placedStudents = new String[]{
                "SUBHASH K V",
                "Harsha Prasanna",
                "Vaibhav Mishra",
                "Arbaz Pasha P",
                "Naveen A",
                "Swathi G",
                "Manju H",
                "SREEDEEPTHI R"
        };

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, placedStudents);
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
                String studentName = placedStudents[position];
                // Start the activity to display the student details
                Intent intent = new Intent(PlacedStudentsActivity.this, StudentDetailsActivity.class);
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