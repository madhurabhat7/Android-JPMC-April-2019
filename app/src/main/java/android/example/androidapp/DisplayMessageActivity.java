package android.example.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra("Message");

        TextView textView = findViewById(R.id.messageTextView);
        textView.setText(message);
        Log.w("Lifecycle", "DMActivity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("Lifecycle", "DMActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Lifecycle", "DMActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Lifecycle", "DMActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("Lifecycle", "DMActivity onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("Lifecycle", "DMActivity onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("Lifecycle", "MainActivity onDestroy");
    }

}
