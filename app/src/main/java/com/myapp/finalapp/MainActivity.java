package com.myapp.finalapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText searchInput;
    Button searchButton;
    ImageButton weatherButton,sellButton;
    String convertedspeech;

    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;
    private static final String weather = "weather";
    private static final String kcc = "kisan credit card";
    private static final String ministry = "ministry";
    private static final String dealer = "dealer";
    private static final String mausam = "मौसम";
    private static final String hkcc = "किसान क्रेडिट कार्ड";
    private static final String hministry = "कृषि मंत्रालय";
    private static final String vikreta = "विक्रेता";
    private static final String dalal = "दलाल";
    Intent chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchInput = (EditText) findViewById(R.id.searchEdittext);
        searchButton = (Button) findViewById(R.id.searchButton);
        weatherButton = (ImageButton) findViewById(R.id.weatherButton);
        sellButton = (ImageButton) findViewById(R.id.sellButton);

        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_RECORD_AUDIO);
            return;
        }

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Sell.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about: showDialog();break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Developed by : \n Praneet Bomma \n Bhumit Adivarekar \n Muteeullah Shaikh \n Saurabh Gupta");
        builder.show();
    }

    public void searchButtonClicked(View view) {

        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"hi_IN");
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speaking");
        i.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS,3000 );
        startActivityForResult(i, 100);

       /* if(searchButton!=null) {
            String input = searchInput.getText().toString();

            switch (input) {
                case weather: {
                    Intent i = new Intent(MainActivity.this, WeatherActivity.class);
                    startActivity(i);
                }
                break;
                case kcc: {
                    Intent i = new Intent(this, KCC.class);
                    startActivity(i);
                }
                break;
                case ministry: {
                    Intent i = new Intent(this, Ministry.class);
                    startActivity(i);
                }
                break;
                *//*case dealer: {
                    Intent i = new Intent(this, Dealer.class);
                    startActivity(i);
                }
                break;*//*
            }
        }
        else{

        }*/
    }


    @Override
    public void onActivityResult(int request_code,int result_code, Intent i){
        super.onActivityResult(request_code,result_code,i);


        switch (request_code){
            case 100 : if (result_code == RESULT_OK && i != null) {
                ArrayList<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                convertedspeech = result.get(0);

                nextActivity(convertedspeech);
            }
                break;
        }
    }

    public void nextActivity(String input){
        if(input.equals(weather) || input.equals(mausam)){
            Intent i = new Intent(this,WeatherActivity.class);
            startActivity(i);
            return;
        }
        /*if(input.equals(dealer) || input.equals(dalal) || input.equals(vikreta)){
            Intent i = new Intent(this,Dealer.class);
            startActivity(i);
            return;
        }*/
        if(input.equals(kcc) || input.equals(hkcc)){
            Intent i = new Intent(this,KCC.class);
            startActivity(i);
            return;
        }
        if(input.equals(ministry) || input.equals(hministry)){
            Intent i = new Intent(this,Ministry.class);
            startActivity(i);
            return;
        }
    }

    public void weatherButtonClicked(View view){
        Intent i = new Intent(this,WeatherActivity.class);
        startActivity(i);
    }

    public void kccButtonClicked(View view){
        Intent i = new Intent(this,KCC.class);
        startActivity(i);
    }

    public void ministryButtonClicked(View view){
        Intent i = new Intent(this,Ministry.class);
        startActivity(i);
    }

    /*public void sellButtonClicked(View view){
        Intent i = new Intent(this,Sell.class);
        startActivity(i);
    }*/
}
