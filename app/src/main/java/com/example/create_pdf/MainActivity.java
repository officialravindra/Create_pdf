package com.example.create_pdf;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.documentfile.provider.DocumentFile;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.fonts.Font;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText getContent =  findViewById(R.id.getText);
        EditText getname =  findViewById(R.id.getName);
        Button create_btn = findViewById(R.id.create);


        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PdfDocument pdfDocument = new PdfDocument();
                PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(300,450,1).create();
                PdfDocument.Page myPage = pdfDocument.startPage(myPageInfo);

                Paint paint = new Paint();
                String text = getContent.getText().toString();
                int x = 40;
                int y=50;
                for(String line :text.split("\n"))
                {
                    myPage.getCanvas().drawText(text,x,y,paint);
                    y+=paint.descent()-paint.ascent();  //for splitting the inline text to next line
                }


                pdfDocument.finishPage(myPage);


    PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(300,450,2).create();
    PdfDocument.Page myPage1 = pdfDocument.startPage(myPageInfo1);

    Paint paint1 = new Paint();
    String text1 = getContent.getText().toString();
    int x1 = 40;
    int y1=50;
                for(String line :text.split("\n"))
    {
        myPage1.getCanvas().drawText(text1,x1,y1,paint1);
        y1+=paint1.descent()-paint.ascent();  //for splitting the inline text to next line
    }


                pdfDocument.finishPage(myPage1);

    String filename = getname.getText().toString();

    String myFilePath = Environment.getExternalStorageDirectory().getPath()+"/"+filename+".pdf";
    File file = new File(myFilePath);
                try {

        pdfDocument.writeTo(new FileOutputStream(file));
        Toast.makeText(MainActivity.this, "Your PDF File has been saved to your internal Storage", Toast.LENGTH_SHORT).show();

    } catch (IOException e) {
        e.printStackTrace();
        getContent.setText("ERROR");
    }
                pdfDocument.close();






            }
        });
    }
    private void viewPdf(String file, String directory) {

        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/" + directory + "/" + file);
        Uri path = Uri.fromFile(pdfFile);

        // Setting the intent for pdf reader
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try {
            startActivity(pdfIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Can't read pdf file", Toast.LENGTH_SHORT).show();
        }
    }

    private void create()
    {
        /*
        Document doc = new Document() {
            @Override
            public String getNodeName() {
                return null;
            }

            @Override
            public String getNodeValue() throws DOMException {
                return null;
            }

            @Override
            public void setNodeValue(String s) throws DOMException {

            }

            @Override
            public short getNodeType() {
                return 0;
            }

            @Override
            public Node getParentNode() {
                return null;
            }

            @Override
            public NodeList getChildNodes() {
                return null;
            }

            @Override
            public Node getFirstChild() {
                return null;
            }

            @Override
            public Node getLastChild() {
                return null;
            }

            @Override
            public Node getPreviousSibling() {
                return null;
            }

            @Override
            public Node getNextSibling() {
                return null;
            }

            @Override
            public NamedNodeMap getAttributes() {
                return null;
            }

            @Override
            public Document getOwnerDocument() {
                return null;
            }

            @Override
            public Node insertBefore(Node node, Node node1) throws DOMException {
                return null;
            }

            @Override
            public Node replaceChild(Node node, Node node1) throws DOMException {
                return null;
            }

            @Override
            public Node removeChild(Node node) throws DOMException {
                return null;
            }

            @Override
            public Node appendChild(Node node) throws DOMException {
                return null;
            }

            @Override
            public boolean hasChildNodes() {
                return false;
            }

            @Override
            public Node cloneNode(boolean b) {
                return null;
            }

            @Override
            public void normalize() {

            }

            @Override
            public boolean isSupported(String s, String s1) {
                return false;
            }

            @Override
            public String getNamespaceURI() {
                return null;
            }

            @Override
            public String getPrefix() {
                return null;
            }

            @Override
            public void setPrefix(String s) throws DOMException {

            }

            @Override
            public String getLocalName() {
                return null;
            }

            @Override
            public boolean hasAttributes() {
                return false;
            }

            @Override
            public String getBaseURI() {
                return null;
            }

            @Override
            public short compareDocumentPosition(Node node) throws DOMException {
                return 0;
            }

            @Override
            public String getTextContent() throws DOMException {
                return null;
            }

            @Override
            public void setTextContent(String s) throws DOMException {

            }

            @Override
            public boolean isSameNode(Node node) {
                return false;
            }

            @Override
            public String lookupPrefix(String s) {
                return null;
            }

            @Override
            public boolean isDefaultNamespace(String s) {
                return false;
            }

            @Override
            public String lookupNamespaceURI(String s) {
                return null;
            }

            @Override
            public boolean isEqualNode(Node node) {
                return false;
            }

            @Override
            public Object getFeature(String s, String s1) {
                return null;
            }

            @Override
            public Object setUserData(String s, Object o, UserDataHandler userDataHandler) {
                return null;
            }

            @Override
            public Object getUserData(String s) {
                return null;
            }

            @Override
            public DocumentType getDoctype() {
                return null;
            }

            @Override
            public DOMImplementation getImplementation() {
                return null;
            }

            @Override
            public Element getDocumentElement() {
                return null;
            }

            @Override
            public Element createElement(String s) throws DOMException {
                return null;
            }

            @Override
            public DocumentFragment createDocumentFragment() {
                return null;
            }

            @Override
            public Text createTextNode(String s) {
                return null;
            }

            @Override
            public Comment createComment(String s) {
                return null;
            }

            @Override
            public CDATASection createCDATASection(String s) throws DOMException {
                return null;
            }

            @Override
            public ProcessingInstruction createProcessingInstruction(String s, String s1) throws DOMException {
                return null;
            }

            @Override
            public Attr createAttribute(String s) throws DOMException {
                return null;
            }

            @Override
            public EntityReference createEntityReference(String s) throws DOMException {
                return null;
            }

            @Override
            public NodeList getElementsByTagName(String s) {
                return null;
            }

            @Override
            public Node importNode(Node node, boolean b) throws DOMException {
                return null;
            }

            @Override
            public Element createElementNS(String s, String s1) throws DOMException {
                return null;
            }

            @Override
            public Attr createAttributeNS(String s, String s1) throws DOMException {
                return null;
            }

            @Override
            public NodeList getElementsByTagNameNS(String s, String s1) {
                return null;
            }

            @Override
            public Element getElementById(String s) {
                return null;
            }

            @Override
            public String getInputEncoding() {
                return null;
            }

            @Override
            public String getXmlEncoding() {
                return null;
            }

            @Override
            public boolean getXmlStandalone() {
                return false;
            }

            @Override
            public void setXmlStandalone(boolean b) throws DOMException {

            }

            @Override
            public String getXmlVersion() {
                return null;
            }

            @Override
            public void setXmlVersion(String s) throws DOMException {

            }

            @Override
            public boolean getStrictErrorChecking() {
                return false;
            }

            @Override
            public void setStrictErrorChecking(boolean b) {

            }

            @Override
            public String getDocumentURI() {
                return null;
            }

            @Override
            public void setDocumentURI(String s) {

            }

            @Override
            public Node adoptNode(Node node) throws DOMException {
                return null;
            }

            @Override
            public DOMConfiguration getDomConfig() {
                return null;
            }

            @Override
            public void normalizeDocument() {

            }

            @Override
            public Node renameNode(Node node, String s, String s1) throws DOMException {
                return null;
            }
        };

        try {
            String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDF";

            File dir = new File(path);
            if(!dir.exists())
                dir.mkdirs();

            File file = new File(dir, "mypdffile.pdf");
            FileOutputStream fOut = new FileOutputStream(file);

            PdfDocument pdfDocument = new PdfDocument();
            doc.getInstance(doc, fOut);

            //open the document
            doc.open();

            Paragraph p1 = new Paragraph(text);
            Font paraFont= new Font(Font.FontFamily.COURIER);
            p1.setAlignment(Paragraph.ALIGN_CENTER);
            p1.setFont(paraFont);

            //add paragraph to document
            doc.add(p1);

        } catch (DocumentException de) {
            Log.e("PDFCreator", "DocumentException:" + de);
        } catch (IOException e) {
            Log.e("PDFCreator", "ioException:" + e);
        }
        finally {
            doc.close();
        }

        viewPdf("mypdffile.pdf", "PDF");*/
    }


}