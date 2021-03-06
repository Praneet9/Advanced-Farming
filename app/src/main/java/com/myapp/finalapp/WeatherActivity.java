package com.myapp.finalapp;


import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.finalapp.data.Channel;
import com.myapp.finalapp.data.Item;
import com.myapp.finalapp.service.WeatherServiceCallback;
import com.myapp.finalapp.service.YahooWeatherService;

public class WeatherActivity extends AppCompatActivity implements WeatherServiceCallback {
    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;
    String city,country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherIconImageView=(ImageView)findViewById(R.id.weatherIconImageView);
        temperatureTextView=(TextView)findViewById(R.id.temperatureTextView);
        conditionTextView=(TextView)findViewById(R.id.conditionTextView);
        locationTextView=(TextView)findViewById(R.id.locationTextView);
        city = getIntent().getStringExtra("city");
        country = getIntent().getStringExtra("country");

        service=new YahooWeatherService(this);
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading.....");
        dialog.show();
        service.refreshWeather("Maharashtra, India");
    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();
        Item item = channel.getItem();
        int resourcesId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(),null,getPackageName());
        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resourcesId);
        weatherIconImageView.setImageDrawable(weatherIconDrawable);
        temperatureTextView.setText(item.getCondition().getTemperature() + "\u00B0" + channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(service.getLocation());
    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this,exception.getMessage(),Toast.LENGTH_LONG).show();
    }
}