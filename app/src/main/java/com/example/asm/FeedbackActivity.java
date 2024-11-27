package com.example.asm;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    private CheckBox checkboxFeedback, checkboxFeature;
    private RadioGroup radioGroupInterface;
    private RatingBar ratingBar;
    private SeekBar seekBarSatisfaction;
    private Switch switchRecommend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back); // Assuming your XML file is named activity_feedback.xml

        // Initialize views
        checkboxFeedback = findViewById(R.id.checkbox_feedback);
        checkboxFeature = findViewById(R.id.checkbox_feature);
        radioGroupInterface = findViewById(R.id.radio_group_interface);
        ratingBar = findViewById(R.id.rating_bar);
        seekBarSatisfaction = findViewById(R.id.seek_bar_satisfaction);
        switchRecommend = findViewById(R.id.switch_recommend);

        // Set listeners and actions
        setupListeners();
    }

    private void setupListeners() {
        // Checkbox listeners
        checkboxFeedback.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String message = isChecked ? "You enjoyed the app!" : "You didn't enjoy the app.";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });

        checkboxFeature.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String message = isChecked ? "You want more features." : "No additional features requested.";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });

        // RadioGroup listener
        radioGroupInterface.setOnCheckedChangeListener((group, checkedId) -> {
            String selectedOption = "";
            if (checkedId == R.id.radio_good) {
                selectedOption = "Good";
            } else if (checkedId == R.id.radio_average) {
                selectedOption = "Average";
            } else if (checkedId == R.id.radio_poor) {
                selectedOption = "Poor";
            }
            Toast.makeText(this, "Interface rating: " + selectedOption, Toast.LENGTH_SHORT).show();
        });

        // RatingBar listener
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                Toast.makeText(this, "Overall rating: " + rating, Toast.LENGTH_SHORT).show()
        );

        // SeekBar listener
        seekBarSatisfaction.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(FeedbackActivity.this, "Satisfaction level: " + progress + "%", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional: Do something when tracking starts
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional: Do something when tracking stops
            }
        });

        // Switch listener
        switchRecommend.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String message = isChecked ? "You would recommend this app!" : "You wouldn't recommend this app.";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });
    }
}
