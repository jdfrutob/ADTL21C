package com.example.addtwonumbers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar title
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("\t\t\t\tSum of Two Numbers");

        // Find the EditText fields and the Button
        EditText editTextNumber1 = findViewById(R.id.editTextNumberDecimal);
        EditText editTextNumber2 = findViewById(R.id.editTextNumberDecimal2);
        Button addButton = findViewById(R.id.button);

        // Set OnClickListener for the Button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the numbers from the EditText fields
                String num1Str = editTextNumber1.getText().toString();
                String num2Str = editTextNumber2.getText().toString();

                // Check if the EditText fields are not empty
                if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                    // Convert the input to numbers
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);

                    // Add the numbers
                    double sum = num1 + num2;

                    // Display the result using a Toast
                    Toast.makeText(MainActivity.this, "Sum = " + sum, Toast.LENGTH_SHORT).show();
                } else {
                    // Show a toast if EditText fields are empty
                    Toast.makeText(MainActivity.this, "Please enter numbers in both fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
