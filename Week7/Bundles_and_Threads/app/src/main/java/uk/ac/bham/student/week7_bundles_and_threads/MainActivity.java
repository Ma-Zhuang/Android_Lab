package uk.ac.bham.student.week7_bundles_and_threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            seconds =savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
    }

    private void runTimer() {
        final TextView timer = (TextView) findViewById(R.id.timer);
        final Handler thread = new Handler();
        thread.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/360;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%02d:%02d:%02d",hours, minutes, seconds);
                timer.setText(time);
                if(running){
                    seconds += 1;
                }
                thread.postDelayed(this,1000);
            }
        });
    }
    public void timerStart(View view){
        running = true;
    }

    public void timerStop(View view){
        running = false;
    }

    public void timerReset(View view){
        running = false;
        seconds = 0;
    }
}