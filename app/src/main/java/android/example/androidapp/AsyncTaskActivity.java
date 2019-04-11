package android.example.androidapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
    }

    public void executeTask(View view){

        //DemoThread demoThread = new DemoThread("Threading");
        //demoThread.start();
        AsyncTaskDemo asyncTaskDemo = new AsyncTaskDemo();
        asyncTaskDemo.execute("MyAsyncTask");
    }

    class AsyncTaskDemo extends AsyncTask<String, Integer, String> {


        @Override
        protected void onPreExecute() {
            Toast.makeText(AsyncTaskActivity.this,
                    "Task started", Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(String... strings) {

            for(int i = 0 ; i < 5; i++){

                try {
                    Thread.sleep(2000);
                }
                catch (Exception ex){

                }
                publishProgress((i  *20) + 20);
            }

            return "Task Completed " + strings[0];
        }

        @Override
        protected void onPostExecute(String result) {

            TextView textView = findViewById(R.id.msgTV);
            textView.setText(result);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(values[0]);
        }
    }
    class DemoThread extends Thread{

        String message;
        DemoThread(String value){
            message = value;
        }

        @Override
        public void run() {

            for(int i = 0 ; i < 5; i++){

                try {
                    Thread.sleep(2000);
                }
                catch (Exception ex){

                }

            }

            AsyncTaskActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView textView = findViewById(R.id.msgTV);
                    textView.setText("Completed " + message );
                }
            });


        }
    }

}
