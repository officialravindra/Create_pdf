package com.example.create_pdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Checkboxes extends AppCompatActivity {

    CheckBox c1,c2,c3,c4,c5;
    Button send;
    ArrayList<String> list ;
    int[] array = {0,0,0,0,0};
    int x;

    static int a=0,b=0,c=0,d=0,e=0;
    static  int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkboxes);
        c1 = findViewById(R.id.cb1);
        c2 = findViewById(R.id.cb2);
        c3 = findViewById(R.id.cb3);
        c4 = findViewById(R.id.cb4);
        c5 = findViewById(R.id.cb5);
        send = findViewById(R.id.send);




        if(counter == 0)
        {
            updatevalues();
            counter++;
        }
        else
        {
            if(a==1)
            {
                c1.setChecked(true);
            }
            if(b==1)
            {
                c2.setChecked(true);
            }
            if(c==1)
            {
                c3.setChecked(true);
            }
            if(d==1)
            {
                c4.setChecked(true);
            }
            if(e==1)
            {
                c5.setChecked(true);
            }
            counter++;
        }



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                updatevalues();

                    Intent intent = new Intent(Checkboxes.this,Check2.class);
                    intent.putExtra("a",a);
                    intent.putExtra("b",b);
                    intent.putExtra("c",c);
                    intent.putExtra("d",d);
                    intent.putExtra("e",e);
                    /*  intent.putExtra("checked2",x);*/
                    startActivity(intent);



            }
        });

    }

    private void updatevalues() {
        if(c1.isChecked())
        {
            a=1;
            Toast.makeText(Checkboxes.this, "c1 is checked", Toast.LENGTH_SHORT).show();

        }
        if(c2.isChecked())
        {
            b=1;
            Toast.makeText(Checkboxes.this, "c2 is checked", Toast.LENGTH_SHORT).show();
        }

        if(c3.isChecked())
        {
            c=1;
            Toast.makeText(Checkboxes.this, "c3 is checked", Toast.LENGTH_SHORT).show();
        }
        if(c4.isChecked())
        {
            d=1;
            Toast.makeText(Checkboxes.this, "c4 is checked", Toast.LENGTH_SHORT).show();
        }
        if(c5.isChecked())
        {
            e=1;
            Toast.makeText(Checkboxes.this, "c5 is checked", Toast.LENGTH_SHORT).show();
        }
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