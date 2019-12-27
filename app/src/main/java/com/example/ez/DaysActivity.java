package com.example.ez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DaysActivity extends AppCompatActivity {
    Button button5,button6,button7,button8,button9,button10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button10 = (Button)findViewById(R.id.button10);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId())
                {
                    case R.id.button5:
                        i =  new Intent(DaysActivity.this, MondayActivity.class);
                        startActivity(i);
                        break;
                    case R.id.button6:
                        i =  new Intent(DaysActivity.this, TuesdayActivity.class);
                        startActivity(i);
                        break;
                    case R.id.button7:
                        i =  new Intent(DaysActivity.this, WednesdayActivity.class);
                        startActivity(i);
                        break;
                    case R.id.button8:
                        i =  new Intent(DaysActivity.this, ThursdayAcctivity.class);
                        startActivity(i);
                        break;
                    case R.id.button9:
                        i =  new Intent(DaysActivity.this, FridayActivity.class);
                        startActivity(i);
                        break;
                    case R.id.button10:
                        i =  new Intent(DaysActivity.this, SaturdayActivity.class);
                        startActivity(i);
                        break;
                    default:
                        break;

                }
            }
        };
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button10.setOnClickListener(listener);

    }



}