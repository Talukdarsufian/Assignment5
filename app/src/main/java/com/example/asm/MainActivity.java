package com.example.asm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the views
        TextView textView = findViewById(R.id.myTextView);
        ImageView imageView = findViewById(R.id.myImageView);
        Button button = findViewById(R.id.myButton);
        Button openFeedBackbutton = findViewById(R.id.feedBackButton);
        Button openListbutton = findViewById(R.id.formButton);
        Button openFormBackbutton = findViewById(R.id.listButton);


        // Set up Button click listener to display a Toast
        button.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Welcome to Sylhet!", Toast.LENGTH_SHORT).show()
        );


        openFeedBackbutton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
            startActivity(intent);
        });
        openFormBackbutton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, FormActivity.class);
            startActivity(intent);
        });

        openListbutton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });
    }
}
