package cs.bham.ac.uk.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
        EditText editText = findViewById(R.id.editTextYourStuff);
        TextView textView = findViewById(R.id.coolTV);
        textView.setText(editText.getText().toString());
    }
}