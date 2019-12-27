package com.example.ez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrActivity extends AppCompatActivity {
    EditText name;
    EditText password;
    Button button3,button4;
    int users = 1;
    String N;
    String P;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);
        name = (EditText) findViewById(R.id.editText3);
        password = (EditText)findViewById(R.id.editText5);
        button3 =  (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
               switch (v.getId())
               {
                   case R.id.button3:

                       if(!name.getText().toString().equals(null) && !password.getText().toString().equals(null)) {
                           N = name.getText().toString();
                           P = password.getText().toString();
                           Toast.makeText(RegistrActivity.this, "Вы зарегистрировались", Toast.LENGTH_SHORT).show();
                           break;
                       }
                       else{
                           Toast.makeText(RegistrActivity.this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                           break;
                       }
                   case R.id.button4:
                       i = new Intent(RegistrActivity.this, MainActivity.class);
                       i.putExtra("Name", N);
                       i.putExtra("Password",P);
                       startActivity(i);
                       finish();
                       break;
                   default:
                       return;

               }
            }
        };
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
    }



}
