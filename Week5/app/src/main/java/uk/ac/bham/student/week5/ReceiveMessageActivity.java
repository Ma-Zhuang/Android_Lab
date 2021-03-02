package uk.ac.bham.student.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();
        String text = intent.getStringExtra(INTENT_MESSAGE);
        TextView receivedMessage = findViewById(R.id.messageReceived);
        receivedMessage.setText(text);
    }
}