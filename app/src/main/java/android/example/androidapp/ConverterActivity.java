package android.example.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConverterActivity extends AppCompatActivity {

    int mode;
    double result = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        if(savedInstanceState != null){
            this.mode = savedInstanceState.getInt("Mode");
            this.result = savedInstanceState.getDouble("Result");

            TextView textView =  findViewById(R.id.resultTV);
            textView.setText("Picked from Bundle: " + this.result);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("Mode", this.mode);
        outState.putDouble("Result", this.result);
    }

    public void onModeChange(View view){

        switch (view.getId()){

            case R.id.toCelciusRB:
                this.mode = 1;
                break;
            case R.id.toFanRB:
                this.mode = 2;
                break;
        }
        Toast.makeText(this, "Mode: " + mode, Toast.LENGTH_LONG).show();

    }

    public void convert(View view){

        EditText editText = findViewById(R.id.valueET);
        TextView resultTextView = findViewById(R.id.resultTV);

        double value = Double.parseDouble(editText.getText().toString());

        if(mode == 1){

            result = (value -32) * 5 /9;
        }else if(mode == 2){
            result = (value *9/5) + 32;
        }
        resultTextView.setText("Converted Value: " + result);
    }
}
