package com.example.holidayfinder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private Button checkerButton;
    private TextView resultTextView;

    // Array of holidays in the Philippines for the year 2024
    private String[] holidays2024 = {"2024-01-01", "2024-04-09", "2024-05-01", "2024-06-12", "2024-08-27", "2024-12-25"};

    // Variable to store the selected date
    private String selectedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        checkerButton = findViewById(R.id.checker);
        resultTextView = findViewById(R.id.Result);

        // Set the min and max date for the CalendarView to the year 2024
        Calendar minDateCalendar = Calendar.getInstance();
        minDateCalendar.set(2024, Calendar.JANUARY, 1);
        long minDateMillis = minDateCalendar.getTimeInMillis();

        Calendar maxDateCalendar = Calendar.getInstance();
        maxDateCalendar.set(2024, Calendar.DECEMBER, 31);
        long maxDateMillis = maxDateCalendar.getTimeInMillis();

        calendarView.setMinDate(minDateMillis);
        calendarView.setMaxDate(maxDateMillis);

        checkerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the currently selected date from the CalendarView
                long selectedDateMillis = calendarView.getDate();
                Calendar selectedDateCalendar = Calendar.getInstance();
                selectedDateCalendar.setTimeInMillis(selectedDateMillis);

                // Store the selected date
                selectedDate = selectedDateCalendar.get(Calendar.YEAR) + "-" +
                        (selectedDateCalendar.get(Calendar.MONTH) + 1) + "-" +
                        selectedDateCalendar.get(Calendar.DAY_OF_MONTH);

                // Check if the selected date is a holiday
                checkHoliday();
            }
        });
    }

    private void checkHoliday() {
        if (!selectedDate.isEmpty()) {
            if (isHoliday(selectedDate)) {
                resultTextView.setText("Selected date is a holiday!");
            } else {
                resultTextView.setText("Selected date is not a holiday. Try again!");
            }
        } else {
            resultTextView.setText("Please select a date first.");
        }
    }

    private boolean isHoliday(String date) {
        for (String holiday : holidays2024) {
            if (holiday.equals(date)) {
                return true;
            }
        }
        return false;
    }
}
