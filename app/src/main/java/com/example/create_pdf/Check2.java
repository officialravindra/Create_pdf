package com.example.create_pdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class Check2 extends AppCompatActivity {
    CheckBox c1,c2,c3,c4,c5;
    Button back;

    int[] array2 = new int[4];
    int f=0,g=0,h=0,i=0,j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check2);
        Intent intent =  getIntent();
        int f = intent.getIntExtra("a",3);
        int g = intent.getIntExtra("b",3);
        int h = intent.getIntExtra("c",3);
        int i = intent.getIntExtra("d",3);
        int j = intent.getIntExtra("e",3);
      /* Bundle bundle = getIntent().getExtras();
       int[] array2 = bundle.getIntArray("checked2");
        Toast.makeText(Check2.this, ""+array2[2], Toast.LENGTH_SHORT).show()
      */  /*
        */;

        c1 = findViewById(R.id.cb1);
        c2 = findViewById(R.id.cb2);
        c3 = findViewById(R.id.cb3);
        c4 = findViewById(R.id.cb4);
        c5 = findViewById(R.id.cb5);
        back = findViewById(R.id.back);

/*
        Toast.makeText(Check2.this, ""+f, Toast.LENGTH_SHORT).show();
        Toast.makeText(Check2.this, ""+g, Toast.LENGTH_SHORT).show();
        Toast.makeText(Check2.this, ""+h, Toast.LENGTH_SHORT).show();
        Toast.makeText(Check2.this, ""+i, Toast.LENGTH_SHORT).show();
        Toast.makeText(Check2.this, ""+j, Toast.LENGTH_SHORT).show();
*/

        if(Checkboxes.a == 1)
        {
            c1.setChecked(true);
        }
        if(Checkboxes.b == 1)
        {
            c2.setChecked(true);
        }
        if(Checkboxes.c == 1)
        {
            c3.setChecked(true);
        }
        if(Checkboxes.d == 1)
        {
            c4.setChecked(true);
        }
        if(Checkboxes.e == 1)
        {
            c5.setChecked(true);
        }



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatevalues();
                startActivity(new Intent(Check2.this,Checkboxes.class));
            }
        });
    }

    private void updatevalues() {
        if(c1.isChecked()== false)
        {
            Checkboxes.a = 0;
        }
        if(c2.isChecked()== false)
        {
            Checkboxes.b = 0;
        }
        if(c3.isChecked()== false)
        {
            Checkboxes.c = 0;
        }
        if(c4.isChecked()== false)
        {
            Checkboxes.d = 0;
        }
        if(c5.isChecked()== false)
        {
            Checkboxes.e = 0;
        }
        if(c1.isChecked()== true)
        {
            Checkboxes.a = 1;
        }
        if(c2.isChecked()== true)
        {
            Checkboxes.b = 1;
        }
        if(c3.isChecked()== true)
        {
            Checkboxes.c = 1;
        }
        if(c4.isChecked()== true)
        {
            Checkboxes.d = 1;
        }
        if(c5.isChecked()== true)
        {
            Checkboxes.e = 1;
        }
    }
}