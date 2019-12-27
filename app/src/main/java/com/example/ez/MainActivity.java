package com.example.ez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button, button2,button11;
    EditText name,password;
    String N = "";
    String P = "";
    DBHelper dbHelper;
    boolean b = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        name = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        //button11 = (Button)findViewById(R.id.button11);
        dbHelper  = new DBHelper(this);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i,i1;
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();

                if(!N.equals(null) && !P.equals(null))
                {
                    contentValues.put(DBHelper.KEY_NAME,N);
                    contentValues.put(DBHelper.KEY_PASSWORD,P);
                    database.insert(DBHelper.TABLE_CONTACTS,null, contentValues);
                }
                switch (v.getId())
                {
                    case R.id.button2:
                        i =  new Intent(MainActivity.this, RegistrActivity.class);
                        startActivity(i);

                        break;
                    case R.id.button:
                        if(!name.getText().toString().equals(null) && !password.getText().toString().equals(null))
                        {
                            i = getIntent();
                            N = i.getStringExtra("Name");
                            P = i.getStringExtra("Password");
                            if(!N.equals(null) && !P.equals(null))
                            {
                                contentValues.put(DBHelper.KEY_NAME,N);
                                contentValues.put(DBHelper.KEY_PASSWORD,P);
                                database.insert(DBHelper.TABLE_CONTACTS,null, contentValues);
                            }
                            Cursor cursor = database.query(DBHelper.TABLE_CONTACTS,null,null,null,null,null,null);
                            if (cursor.moveToFirst())
                            {
                                //int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                                int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                                int passwordIndex =  cursor.getColumnIndex(DBHelper.KEY_PASSWORD);
                                do{
                                    if(name.getText().toString().equals(cursor.getString(nameIndex)) && password.getText().toString().equals(cursor.getString(passwordIndex)))
                                    {

                                        Toast.makeText(MainActivity.this, "Все ок", Toast.LENGTH_SHORT).show();
                                        b =  false;
                                        cursor.close();
                                        i1 = new Intent(MainActivity.this, DaysActivity.class);
                                        startActivity(i1);
                                        break;

                                    }
                                    else{
                                        continue;
                                    }

                                }while (cursor.moveToNext());
                                //cursor.close();
                                //break;
                                if(b) {
                                    Toast.makeText(MainActivity.this, "Таких пользавателей нет, либо введины неправильные данные", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Таких пользавателей нет, либо введины неправильные данные", Toast.LENGTH_SHORT).show();
                                cursor.close();
                                break;
                            }
                            break;

                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Не все поля заполены", Toast.LENGTH_SHORT).show();
                            break;
                        }


                    default:
                        break;
                }
            }
        };
        button.setOnClickListener(listener);
        button2.setOnClickListener(listener);
    }


}
