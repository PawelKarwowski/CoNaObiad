package com.example.pawcio.conaobiad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    Button btnAdd;
    Button btnView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btnAdd =  (Button) findViewById(R.id.button);
        btnView = (Button) findViewById(R.id.button);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                startActivity(intent);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0)
                {
                    AddData(newEntry);
                    editText.setText("");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Aby coś dodać pole musi być uzupełnione", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void AddData(String newEntry)
    {
        boolean insertData = myDB.addData(newEntry);

        if(insertData==true)
        {
            Toast.makeText(MainActivity.this, "Dodano.", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Coś poszło nie tak.", Toast.LENGTH_LONG).show();
        }
    }
}
