package com.example.midtermexam;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);


        mediaPlayer = MediaPlayer.create(this, R.raw.gitar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("MainActivity", "onCreateOptionsMenu called");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.child1) {
            Toast.makeText(this, "Simple Calculator", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, CalculatorActivity.class));
            return true;
        } else if (item.getItemId() == R.id.child2) {
            Toast.makeText(this, "Number Systems Converter", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, ConverterActivity.class));
            return true;
        } else if (item.getItemId() == R.id.parent1) {
            Toast.makeText(this, "Credits :", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, CreditActivity.class));
            return true;
        }else if (item.getItemId() == R.id.parent3) {
            Toast.makeText(this, "Home", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }



    public void playSound(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }
}
