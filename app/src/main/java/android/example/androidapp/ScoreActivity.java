package android.example.androidapp;

import android.arch.lifecycle.ViewModelProviders;
import android.example.androidapp.viewmodel.ScoreViewModel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private ScoreViewModel scoreViewModel;
    private TextView scoreTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreViewModel = ViewModelProviders
                            .of(this).get(ScoreViewModel.class);

        scoreTextView = findViewById(R.id.scoreTextView);
        //scoreTextView.setText(new Integer(scoreViewModel.score).toString());
        scoreTextView.setText("" + scoreViewModel.score);
    }

    public void addPlusTwo(View view){

        scoreViewModel.score += 2;
        scoreTextView.setText("" + scoreViewModel.score);
    }
    public void addPlusThree(View view){

        scoreViewModel.score += 3;
        scoreTextView.setText("" + scoreViewModel.score);
    }
}
