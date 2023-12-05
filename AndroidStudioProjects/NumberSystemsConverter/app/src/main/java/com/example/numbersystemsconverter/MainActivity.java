package com.example.numbersystemsconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private RadioGroup radioGroup;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the title of the Toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("\t\t\t\tNumber System Converter");

        userInput = findViewById(R.id.userinput);
        radioGroup = findViewById(R.id.radioGroup);
        resultTextView = findViewById(R.id.resulthere);

        findViewById(R.id.convertButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertNumber();
            }
        });
    }

    private void convertNumber() {
        String inputStr = userInput.getText().toString().trim();

        if (!inputStr.isEmpty()) {
            try {
                int decimalNumber = Integer.parseInt(inputStr);
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);

                    if (selectedRadioButton.getId() == R.id.binary) {
                        resultTextView.setText(Integer.toBinaryString(decimalNumber));
                    } else if (selectedRadioButton.getId() == R.id.hex) {
                        resultTextView.setText(Integer.toHexString(decimalNumber));
                    } else if (selectedRadioButton.getId() == R.id.octal) {
                        resultTextView.setText(Integer.toOctalString(decimalNumber));
                    }
                } else {
                    resultTextView.setText("Select an option");
                }
            } catch (NumberFormatException e) {
                resultTextView.setText("Invalid input");
            }
        } else {
            resultTextView.setText("Enter a number");
        }
    }
}
