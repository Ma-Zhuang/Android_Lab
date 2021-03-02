package uk.ac.bham.student.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view){
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        EditText message = (EditText) findViewById(R.id.message);
        intent.putExtra(ReceiveMessageActivity.INTENT_MESSAGE, message.getText().toString());
        startActivity(intent);
    }
}