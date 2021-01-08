package com.example.create_pdf;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    Bitmap bitmap,scaledBitmap;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText getname = findViewById(R.id.getName1);
        EditText getpdfname = findViewById(R.id.getpdfName);
        EditText getbody = findViewById(R.id.getText);



        Button create = findViewById(R.id.create);

        String name1 = "RAVINDRA SINGH";




        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                ActivityCompat.requestPermissions(MainActivity2.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
                String name = getname.getText().toString().trim();
                String pdfname = getpdfname.getText().toString().trim();
                String body = getbody.getText().toString();

                bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.officialravindra);
                scaledBitmap = Bitmap.createScaledBitmap(bitmap,200,200,false);


                PdfDocument pdfDocument = new PdfDocument();
                Paint paint = new Paint();
                PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(250,400,1).create();
                PdfDocument.Page myPage = pdfDocument.startPage(myPageInfo);
                Canvas canvas = myPage.getCanvas();

                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(12.0f);
                paint.setColor(Color.BLACK);
                canvas.drawText("Premad Infotech",myPageInfo.getPageWidth()/2,30,paint);



                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(6.0f);
                paint.setColor(Color.rgb(122,119,122));
                canvas.drawText("Pratap Nagar , Jaipur",myPageInfo.getPageWidth()/2,40,paint);


                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(9.0f);
                paint.setColor(Color.rgb(122,119,122));
                canvas.drawText("Custumer Information",20,70,paint);

                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(12.0f);
                paint.setColor(Color.BLACK);
                canvas.drawText(name,20,90,paint);
                /* canvas.drawLine(80,92,80,190,paint);*/

                Paint forlinepaint = new Paint();
                forlinepaint.setStyle(Paint.Style.FILL_AND_STROKE);
                forlinepaint.setStrokeWidth(2);
                canvas.drawLine(20,110,230,110,forlinepaint);
                paint.setTextSize(6.0f);
                canvas.drawText("S.N.",25,128,paint);
                canvas.drawText("Product Name",70,128,paint);
                canvas.drawText("Price",185,128,paint);

                canvas.drawText("1",30,155,paint);
                canvas.drawText("Apple 12 Max pro",70,155,paint);
                canvas.drawText("1,22,125",180,155,paint);

                canvas.drawLine(20,140,230,140,forlinepaint);
                canvas.drawLine(150,110,150,300,forlinepaint);

                canvas.drawLine(20,110,20,300,forlinepaint);
                canvas.drawLine(40,110,40,300,forlinepaint);
                canvas.drawLine(230,110,230,300,forlinepaint);
                canvas.drawLine(20,300,230,300,forlinepaint);
                canvas.drawLine(20,280,230,280,forlinepaint);
                canvas.drawText("Total ",80,290,paint);
                canvas.drawText("1,22,125",180,290,paint);
               /* canvas.drawLine(20,280,230,280,forlinepaint);*/




/*
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawBitmap(scaledBitmap,20,120,paint);
*/

                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(12.0f);
                paint.setColor(Color.rgb(122,119,122));
                canvas.drawText(body,myPageInfo.getPageWidth()/2,350,paint);



                pdfDocument.finishPage(myPage);


                String myFilePath = Environment.getExternalStorageDirectory().getPath()+"/"+pdfname+".pdf";

                File file = new File(myFilePath);
                try {

                    pdfDocument.writeTo(new FileOutputStream(file));
                    Toast.makeText(MainActivity2.this, "Your PDF File has been saved to your internal Storage", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity2.this, "ERROR", Toast.LENGTH_SHORT).show();
                }

                pdfDocument.close();



            }
        });





    }
}