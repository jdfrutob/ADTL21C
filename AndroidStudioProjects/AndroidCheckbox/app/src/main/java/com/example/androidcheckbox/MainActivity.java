package com.example.androidcheckbox;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<String, Integer> itemPrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("\t\t\t\tAndroid Checkbox");

        itemPrices = new HashMap<>();
        itemPrices.put("Burger", 75);
        itemPrices.put("Pizza", 120);
        itemPrices.put("Soda", 40);

        final CheckBox burgerCheckBox = findViewById(R.id.burger);
        final CheckBox pizzaCheckBox = findViewById(R.id.pizza);
        final CheckBox sodaCheckBox = findViewById(R.id.soda);
        final Button orderButton = findViewById(R.id.button);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayOrder();
            }
        });
    }

    private void displayOrder() {
        StringBuilder orderSummary = new StringBuilder();
        int totalCost = 0;

        if (itemPrices.containsKey("Burger")) {
            CheckBox burgerCheckBox = findViewById(R.id.burger);
            if (burgerCheckBox.isChecked()) {
                orderSummary.append("Burger = ₱").append(itemPrices.get("Burger")).append("\n");
                totalCost += itemPrices.get("Burger");
            }
        }

        if (itemPrices.containsKey("Pizza")) {
            CheckBox pizzaCheckBox = findViewById(R.id.pizza);
            if (pizzaCheckBox.isChecked()) {
                orderSummary.append("Pizza = ₱").append(itemPrices.get("Pizza")).append("\n");
                totalCost += itemPrices.get("Pizza");
            }
        }

        if (itemPrices.containsKey("Soda")) {
            CheckBox sodaCheckBox = findViewById(R.id.soda);
            if (sodaCheckBox.isChecked()) {
                orderSummary.append("Soda = ₱").append(itemPrices.get("Soda")).append("\n");
                totalCost += itemPrices.get("Soda");
            }
        }

        if (orderSummary.length() > 0) {
            // Display the total cost on a new line
            orderSummary.append("\nTOTAL = ₱ ").append(totalCost);

            // Create a custom toast with a larger layout
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, null);

            TextView text = layout.findViewById(R.id.textViewMessage);
            text.setText(orderSummary.toString());

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.BOTTOM, 0, 200);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        } else {
            Toast.makeText(this, "No items selected", Toast.LENGTH_SHORT).show();
        }
    }
}
