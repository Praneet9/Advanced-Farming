package com.myapp.finalapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Sell extends AppCompatActivity {

    EditText cropname,cropprice,name,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        cropname = (EditText) findViewById(R.id.cropnameEditText);
        cropprice = (EditText) findViewById(R.id.croppriceEditText);
        name = (EditText) findViewById(R.id.nameEditText);
        contact = (EditText) findViewById(R.id.contactEditText);
    }

    public void sellButtonClicked(View view){

        String str_cropname = cropname.getText().toString();
        String str_cropprice = cropprice.getText().toString();
        String str_name = name.getText().toString();
        String str_contact = contact.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,str_cropname,str_cropprice,str_name,str_contact);
    }
}
