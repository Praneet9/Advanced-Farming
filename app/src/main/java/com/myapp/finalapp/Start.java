package com.myapp.finalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Start extends AppCompatActivity {

    Button weathercheck;
    EditText cityname, countryname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        weathercheck = (Button) findViewById(R.id.weathercheck);
        cityname = (EditText) findViewById(R.id.cityname);
        countryname = (EditText) findViewById(R.id.countryname);

    }

    public void checkWeatherClicked(View view) {
        String city = cityname.getText().toString();
        String country = countryname.getText().toString();
        Intent i = new Intent(this, WeatherActivity.class);
        i.putExtra("city", city);
        i.putExtra("country", country);
        startActivity(i);
    }

}
