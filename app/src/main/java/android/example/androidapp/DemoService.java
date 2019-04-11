package android.example.androidapp;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class DemoService extends IntentService {


    public DemoService() {
        super("DemoService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for (int i = 0; i < 5; i++){
            try {
                Thread.sleep(2000);
                Log.w("DemoService", "DemoService:" + i);
            }
            catch (Exception ex){

            }
        }
        Intent resultIntent = new Intent("DemoServiceCompleted");
        resultIntent.putExtra("Result", "Hello from Service");
        LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);
    }


}
