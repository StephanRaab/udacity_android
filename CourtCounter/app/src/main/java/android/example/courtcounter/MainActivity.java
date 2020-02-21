package android.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int teamAScoreTotal = 0;
    int teamBScoreTotal = 0;

    /**
     * increases the score of team A by parameter amount
     *
     * @param scoreAmount
     */
    public void increaseTeamAScore(int scoreAmount) {
        teamAScoreTotal += scoreAmount;
        displayForTeamA(teamAScoreTotal);
    }

    /**
     * increases the score of team B by parameter amount
     *
     * @param scoreAmount
     */
    public void increaseTeamBScore(int scoreAmount) {
        teamBScoreTotal += scoreAmount;
        displayForTeamB(teamBScoreTotal);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * button click for team A 3 pointer
     *
     * @param view
     */
    public void teamA3Pointer(View view) {
        increaseTeamAScore(3);
    }

    /**
     * button click for team A 2 pointer
     *
     * @param view
     */
    public void teamA2Pointer(View view) {
        increaseTeamAScore(2);
    }

    /**
     * button click for team A free throw
     *
     * @param view
     */
    public void teamA1Pointer(View view) {
        increaseTeamAScore(1);
    }

    public void teamB3Pointer(View view) {
        increaseTeamBScore(3);
    }

    public void teamB2Pointer(View view) {
        increaseTeamBScore(2);
    }

    public void teamB1Pointer(View view) {
        increaseTeamBScore(1);
    }

    public void resetScores(View view) {
        teamAScoreTotal = 0;
        teamBScoreTotal = 0;
        displayForTeamA(teamAScoreTotal);
        displayForTeamB(teamBScoreTotal);
    }
}
