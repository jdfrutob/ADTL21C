package com.example.midtermexam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConverterActivity extends AppCompatActivity {

    private EditText userInput;
    private RadioGroup radioGroup;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_activity);


        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.converterToolbar);
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

        Button backButton = findViewById(R.id.back2home);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
