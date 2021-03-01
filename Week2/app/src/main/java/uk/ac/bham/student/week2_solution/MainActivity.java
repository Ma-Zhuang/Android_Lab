package uk.ac.bham.student.week2_solution;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
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

    public void onClickUpdate(View view){
        TextView textView =(TextView)findViewById(R.id.text);
        Spinner spinner =(Spinner)findViewById(R.id.spinner);
        long selectedItemId = spinner.getSelectedItemId();
        String[] spinOpts = getResources().getStringArray(R.array.hi);
        if(selectedItemId==0) textView.setText(spinOpts[(int) selectedItemId]);
        else if (selectedItemId==1) textView.setText(spinOpts[(int) selectedItemId]);
        else if (selectedItemId==2) textView.setText(spinOpts[(int) selectedItemId]);
    }
}