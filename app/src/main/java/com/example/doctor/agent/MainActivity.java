package com.example.doctor.agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart;
        buttonStart = (Button) findViewById(R.id.button_start);
        Button buttonStop;
        buttonStop = (Button)findViewById(R.id.button_stop);
        Button buttonDel;
        buttonDel = (Button)findViewById(R.id.button_delete);

        View.OnClickListener oclBtnStart = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startService(new Intent(MainActivity.this, Agent.class));
            }
        };
        buttonStart.setOnClickListener(oclBtnStart);


        View.OnClickListener oclBtnStop = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                stopService(new Intent(MainActivity.this, Agent.class));

            }
        };
        buttonStop.setOnClickListener(oclBtnStop);


        View.OnClickListener oclBtnDel = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /// Delete output file
                File sdCard = Environment.getExternalStorageDirectory();
                String path = sdCard.getAbsolutePath() + "/Download/" ;
                File f = new File(path +"output.log");
                f.delete();

            }
        };
        buttonDel.setOnClickListener(oclBtnDel);



    }





}


