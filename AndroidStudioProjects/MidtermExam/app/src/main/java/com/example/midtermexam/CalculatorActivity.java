package com.example.midtermexam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class CalculatorActivity extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);


        Toolbar toolbar = findViewById(R.id.calculatorToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("\t\t\t\tSimple Calculator");


        editTextNumber1 = findViewById(R.id.editTextNumberDecimal);
        editTextNumber2 = findViewById(R.id.editTextNumberDecimal2);

        Button addButton = findViewById(R.id.add);
        Button subtractButton = findViewById(R.id.subtract);
        Button multiplyButton = findViewById(R.id.multiply);
        Button divideButton = findViewById(R.id.divide);


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


        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void performCalculation(String resultPrefix, char operator) {

        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();


        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {

            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);

            double result = 0;


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

                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }


            Toast.makeText(this, resultPrefix + " " + result, Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Please enter numbers in both fields", Toast.LENGTH_SHORT).show();
        }
    }
}
