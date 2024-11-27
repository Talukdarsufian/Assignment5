package com.example.asm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;

public class FormActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone;
    Button btnSubmit;
    TextView tvMessage;

    // Regular Expressions for validation
    private static final String NAME_REGEX = "^[a-zA-Z\\s]+$"; // Only letters and spaces
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"; // Basic email pattern
    private static final String PHONE_REGEX = "^[+]?[0-9]{10,13}$"; // Valid phone number format

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Initialize the views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvMessage = findViewById(R.id.tvMessage);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate each field
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();

                if (!validateName(name)) {
                    tvMessage.setText("Invalid name. Only letters and spaces are allowed.");
                } else if (!validateEmail(email)) {
                    tvMessage.setText("Invalid email format.");
                } else if (!validatePhone(phone)) {
                    tvMessage.setText("Invalid phone number.");
                } else {
                    tvMessage.setText("");
                    Toast.makeText(FormActivity.this, "Form Submitted Successfully!", Toast.LENGTH_SHORT).show();
                    // You can proceed with your form submission logic here
                }
            }
        });
    }

    // Method to validate the name using Regex
    private boolean validateName(String name) {
        return Pattern.matches(NAME_REGEX, name);
    }

    // Method to validate the email using Regex
    private boolean validateEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    // Method to validate the phone number using Regex
    private boolean validatePhone(String phone) {
        return Pattern.matches(PHONE_REGEX, phone);
    }
}
