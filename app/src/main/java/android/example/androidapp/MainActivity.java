package android.example.androidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    MessageBroadcastReceiver messageBroadcastReceiver;
    AirplaneModeReceiver airplaneModeReceiver;

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

        messageBroadcastReceiver = new MessageBroadcastReceiver();
        LocalBroadcastManager.getInstance(this)
                .registerReceiver
                        (messageBroadcastReceiver,
                                new IntentFilter("DemoServiceCompleted"));

        airplaneModeReceiver = new AirplaneModeReceiver();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeReceiver, filter);
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
        LocalBroadcastManager.getInstance(this)
                        .unregisterReceiver(messageBroadcastReceiver);
        unregisterReceiver(airplaneModeReceiver);
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

    public void callService(View view){

        Intent intent = new Intent(this, DemoService.class);
        startService(intent);
    }

    class MessageBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            String result = intent.getStringExtra("Result");
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        }
    }
    class AirplaneModeReceiver extends  BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_LONG).show();
            Log.w("AirplaneModeReceiver", "Airplane Mode Changed");
        }
    }



}
