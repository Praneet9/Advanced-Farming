package com.myapp.finalapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class Ministry extends AppCompatActivity {

    String convertedspeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ministry);

    }

    public void speechInputButtonClicked(View view){
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"en_IN");
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speaking");
        i.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS,3000 );
        startActivityForResult(i, 100);
    }

    @Override
    public void onActivityResult(int request_code,int result_code, Intent i){
        super.onActivityResult(request_code,result_code,i);


        switch (request_code){
            case 100 : if (result_code == RESULT_OK && i != null) {
                ArrayList<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                convertedspeech = result.get(0);

            }
                break;
        }
    }

    public void sendEmailButtonClicked(View view){
        String[] to = {"praneetbomma@gmail.com"};
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL, to);
        i.putExtra(Intent.EXTRA_SUBJECT, "Hello Farmer App");
        i.putExtra(Intent.EXTRA_TEXT, convertedspeech);
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i, "Send Email");
        startActivity(chooser);
    }
}
