package com.example.ez;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MondayActivity extends AppCompatActivity {
    Button button12,button13,button14;
    EditText editText4;
    LinearLayout llMain;
    DBHelper2 dbHelper2;
    public static int curent  = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        button12 = (Button)findViewById(R.id.button12);
        button13 = (Button)findViewById(R.id.button13);
        editText4 = (EditText)findViewById(R.id.editText4);
        button14 = (Button)findViewById(R.id.button14);
        llMain = (LinearLayout)findViewById(R.id.llMain1);
        dbHelper2 = new DBHelper2(this, "Monday");
        View.OnClickListener listener = new View.OnClickListener() {
            SQLiteDatabase database = dbHelper2.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            Cursor cursor = database.query(DBHelper2.TABLE_CONTACTS,null,null,null,null,null,null);
            @Override
            public void onClick(View v) {
                Intent i;
                if(cursor.moveToFirst())
                {
                    int nameIndex = cursor.getColumnIndex(DBHelper2.KEY_SUBJECT);
                    int passwordIndex =  cursor.getColumnIndex(DBHelper2.KEY_HOMEWORK);
                    do{
                        String s = String.valueOf(curent);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        TextView textView = new TextView(v.getContext());
                        textView.setLayoutParams(layoutParams);
                        textView.setText(s + " - " + cursor.getString(nameIndex));
                        textView.setId(curent);
                        llMain.addView(textView);
                        EditText editText = new EditText(v.getContext());
                        editText.setLayoutParams(layoutParams);
                        editText.setText(cursor.getString(passwordIndex));
                        editText.setId(curent);
                        llMain.addView(editText);
                        curent++;
                    }while (cursor.moveToNext());
                }
                switch (v.getId())
                {
                    case R.id.button13:
                        String s = String.valueOf(curent);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        TextView textView = new TextView(v.getContext());
                        textView.setLayoutParams(layoutParams);
                        textView.setText(s + " - " + editText4.getText().toString());
                        textView.setId(curent);
                        llMain.addView(textView);
                        EditText editText = new EditText(v.getContext());
                        editText.setLayoutParams(layoutParams);
                        editText.setText("для домашки");
                        editText.setId(curent);
                        llMain.addView(editText);
                        contentValues.put(DBHelper2.KEY_SUBJECT,textView.getText().toString());
                        contentValues.put(DBHelper2.KEY_HOMEWORK,editText.getText().toString());
                        database.insert(DBHelper.TABLE_CONTACTS,null, contentValues);
                        curent++;
                        break;
                    case R.id.button12:
                        i = new Intent(MondayActivity.this,DaysActivity.class);
                        startActivity(i);
                        break;
                    case R.id.button14:
                        llMain.removeAllViews();
                        //dbHelper2.del(dbHelper2);
                        break;
                    default:
                       break;
                }
            }
        };
        button13.setOnClickListener(listener);
        button12.setOnClickListener(listener);
        button14.setOnClickListener(listener);

    }



}