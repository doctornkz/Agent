package com.example.doctor.agent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Timer;
import java.util.TimerTask;

public class Agent extends Service {

    private Timer timer = new Timer();
    private TimerTask task = new Parser();

    public Agent() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Служба создана", Toast.LENGTH_SHORT).show();

        // create

    }

    @Override

    public int onStartCommand(Intent intent, int flags, int startid) {
        Toast.makeText(this, "Служба запущена", Toast.LENGTH_SHORT).show();
        timer.schedule(task, 0, 1000);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Служба остановлена", Toast.LENGTH_SHORT).show();
        timer.cancel();

    }

    //TODO: Need support different mobile phones. I can use source files by Ran Manor
    /*
    public static Long getValue(File f, String currentField) {
        Long value = null;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            fr.close();

        } catch (Exception ex) {
            Log.e("CurrentWidget", ex.getMessage(), ex);
        }
        return value;

    }
*/


}
