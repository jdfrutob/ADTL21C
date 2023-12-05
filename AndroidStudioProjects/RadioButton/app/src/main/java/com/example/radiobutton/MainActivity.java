package com.example.radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("\t\t\t\tRadio Button");

        final RadioGroup radioGroup = findViewById(R.id.genderRadioGroup);
        final RadioButton maleRadioButton = findViewById(R.id.male);
        final RadioButton femaleRadioButton = findViewById(R.id.female);
        final Button showSelectedButton = findViewById(R.id.button2);

        showSelectedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelectedGender(radioGroup);
            }
        });
    }

    private void displaySelectedGender(RadioGroup radioGroup) {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedGender = selectedRadioButton.getText().toString();

            // Display the selected gender in a toast
            Toast.makeText(this, selectedGender, Toast.LENGTH_SHORT).show();
        } else {
            // No radio button selected
            Toast.makeText(this, "No gender selected", Toast.LENGTH_SHORT).show();
        }
    }
}
