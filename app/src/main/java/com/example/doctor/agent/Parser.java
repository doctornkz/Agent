package com.example.doctor.agent;

import android.os.Environment;
import android.util.Log;

import java.io.*;
import java.util.TimerTask;

public class Parser extends TimerTask{

    public void run(){

        String name = "current_now";
        File sdCard = Environment.getExternalStorageDirectory();
        long unixTime = System.currentTimeMillis();
        String nowUnixTime = Long.toString(unixTime);

        try {
            File MyFile = new File("/sys/class/power_supply/battery/" + name);
            BufferedReader in = new BufferedReader(new FileReader(MyFile));
            String str = in.readLine();
            Log.d("9999",str + " string detected");
            String path = sdCard.getAbsolutePath() + "/Download/" ;

            File OutFile = new File(path + "output.log");
            FileWriter outFile = new FileWriter(OutFile, true);
            BufferedWriter out = new BufferedWriter(outFile);
            out.write(nowUnixTime + "\t" + str);
            out.newLine();
            out.close();

        }catch (IOException ex){
            Log.d("9999","Input problem");
        }


    }
}
