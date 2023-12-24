package com.example.madnfm;
// NextActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the activity to display the list of placed students
                Intent intent = new Intent(NextActivity.this, PlacedStudentsActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the HigherEducationStudentsActivity
                Intent intent = new Intent(NextActivity.this, HigherEducationStudentsActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the HigherEducationStudentsActivity
                Intent intent = new Intent(NextActivity.this, CompetativeStudentActivity.class);
                startActivity(intent);
            }
        });


    }
}
