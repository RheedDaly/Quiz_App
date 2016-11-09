package com.rheedkhadaly.quizzes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Nature extends AppCompatActivity {

    TextView quizTextViewTimer;
    ListView quizListView;
    Button quizSubmitButton;

    Integer images[] = {R.drawable.ants, R.drawable.lamb, R.drawable.rhinoceros, R.drawable.butterfly, R.drawable.dog, R.drawable.donkey, R.drawable.owl, R.drawable.flamingo, R.drawable.stingray, R.drawable.warthog};
    String quiz_questions[] = {"What is the national animal of Canada?", "What is the national animal of Albania?", "What kind of animal is the largest living creature on Earth", "Give another name for the study of fossils?", "What do dragonflies prefer to eat?", "What is called a fish with a snake-like body?", "In which city is the oldest zoo in the world?", "Which plant does the Canadian flag contain?", "Which is the largest species of the tiger?", "The bite of which insect causes the Lyme Disease?"};
    String[][] quiz_answers = {{"North American beaver", "Golden eagle", "Whale", "Paleontology"}, {"Golden eagle", "6", "7", "8"}, {"Whale", "10", "11", "12"}, {"Paleontology", "14", "15", "16"}, {"Mosquitoes", "18", "19", "20"}, {"Eel fish", "22", "23", "24"}, {"Vienna", "26", "27", "28"}, {"Maple", "30", "31", "32"}, {"Siberian tiger", "34", "35", "36"}, {"Deer Tick", "38", "39", "40"}};
    String answers[] = {"North American beaver", "Golden eagle", "Whale", "Paleontology", "Mosquitoes", "Eel fish", "Vienna", "Maple", "Plankton", "Siberian tiger", "Deer Tick"};

    ArrayList<String> quizAnswers = new ArrayList<>();
    int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_topic);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        quizTextViewTimer = (TextView) findViewById(R.id.quizTextViewTimer);
        quizListView = (ListView) findViewById(R.id.quizListView);
        quizSubmitButton = (Button) findViewById(R.id.quizSubmitButton);

        CustomQuestionAdapter topicAdapter = new CustomQuestionAdapter(getApplicationContext(), images, quiz_questions, quiz_answers, answers);
        quizListView.setAdapter(topicAdapter);

        quizSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < CustomQuestionAdapter.selectedAnswers.size(); i++) {
                    quizAnswers.add(CustomQuestionAdapter.selectedAnswers.get(i));
                }

                for (int i = 0; i < CustomQuestionAdapter.score.size(); i++) {
                    quizScore += CustomQuestionAdapter.score.get(i);
                }

                Intent i = new Intent(getApplicationContext(), ShowResult.class);
                i.putExtra("answers", quizAnswers);
                i.putExtra("score", quizScore);
                startActivity(i);

                quizAnswers.clear();
            }
        });

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                quizTextViewTimer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                quizTextViewTimer.setText("done!");
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Quit First Topic Questions");
                alertDialogBuilder.setMessage("Do you want to quit first topic?");

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent myIntent = new Intent("com.rheedkhadaly.quizzes.MAINACTIVITY");
                        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(myIntent);
                    }
                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Quit First Topic Questions");
        alertDialogBuilder.setMessage("Do you want to quit first topic?");

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent myIntent = new Intent("com.rheedkhadaly.quizzes.MAINACTIVITY");
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
