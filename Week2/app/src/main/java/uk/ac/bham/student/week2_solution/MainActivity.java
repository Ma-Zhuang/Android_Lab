package uk.ac.bham.student.week2_solution;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("ResourceType")
    public void onClickUpdate(View view){
        TextView textView =(TextView)findViewById(R.id.text);
        Spinner spinner =(Spinner)findViewById(R.id.spinner);
        long selectedItemId = spinner.getSelectedItemId();
        if(selectedItemId==0) textView.setText("Hello !");
        else if (selectedItemId==1) textView.setText("Hello Zhuang !");
        else if (selectedItemId==2) textView.setText("Hello Zhuang Ma !");
    }
}