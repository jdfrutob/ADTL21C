package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar title
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("\t\t\t\tSimple Calculator");

        // Find the EditText fields and the Buttons
        editTextNumber1 = findViewById(R.id.editTextNumberDecimal);
        editTextNumber2 = findViewById(R.id.editTextNumberDecimal2);

        Button addButton = findViewById(R.id.add);
        Button subtractButton = findViewById(R.id.subtract);
        Button multiplyButton = findViewById(R.id.multiply);
        Button divideButton = findViewById(R.id.divide);

        // Set OnClickListener for the Buttons
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation("Sum =", '+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation("Difference =", '-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation("Product =", '*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation("Quotient =", '/');
            }
        });
    }

    private void performCalculation(String resultPrefix, char operator) {
        // Get the numbers from the EditText fields
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();

        // Check if the EditText fields are not empty
        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            // Convert the input to numbers
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);

            double result = 0;

            // Perform the calculation based on the operator
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    // Check for division by zero
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            // Display the result using a Toast
            Toast.makeText(MainActivity.this, resultPrefix + " " + result, Toast.LENGTH_SHORT).show();
        } else {
            // Show a toast if EditText fields are empty
            Toast.makeText(MainActivity.this, "Please enter numbers in both fields", Toast.LENGTH_SHORT).show();
        }
    }
}
