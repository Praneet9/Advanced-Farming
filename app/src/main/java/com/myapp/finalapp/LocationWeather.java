package com.myapp.finalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LocationWeather extends AppCompatActivity {
    String city;
    EditText cityname;
    Button getWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationweather);
        cityname=(EditText)findViewById(R.id.editText);


    }
}
