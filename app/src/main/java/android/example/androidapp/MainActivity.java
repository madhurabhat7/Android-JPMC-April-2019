package android.example.androidapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("Lifecycle", "MainActivity onCreate");
   }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("Lifecycle", "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Lifecycle", "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Lifecycle", "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("Lifecycle", "MainActivity onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("Lifecycle", "MainActivity onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("Lifecycle", "MainActivity onDestroy");
    }

    public void onTapMe(View view){

       EditText messageEditText = findViewById(R.id.messageEditText);
       String message = messageEditText.getText().toString();

       Toast.makeText(this, "Message: " + message, Toast.LENGTH_LONG).show();

       Intent intent = new Intent(this, DisplayMessageActivity.class);
       intent.putExtra("Message", message);
       startActivity(intent);
   }

   public void makeCall(View view){

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: 980000000"));
        startActivity(intent);
   }
    public void browse(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://google.com"));
        startActivity(intent);
    }

}
