package com.rheedkhadaly.quizzes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Rheed on 9/28/2016.
 */

public class GeneralKnowledge extends AppCompatActivity {

    Integer images[] = {R.drawable.ants, R.drawable.lamb, R.drawable.rhinoceros, R.drawable.butterfly, R.drawable.dog, R.drawable.donkey, R.drawable.owl, R.drawable.flamingo, R.drawable.stingray, R.drawable.warthog};
    String quiz_questions[] = {"How many oscars did the Titanic movie got?", "How many Tomb Raider movies were made?", "Which malformation did Marilyn Monroe have when she was born?", "What is the house number of the Simpsons?", "What is the name of the prison in the film The Rock?", "Who is the protagonist in the Last Action Hero film?", "What is the profession of Popeye?", "What is the name of Steven Spielberg s black-and-white-film about the second world war?", "Who is the director of the X-files?", "Who did play the role of Peter Pan in the Peter Pan movie?"};
    String[][] quiz_answers = {{"Eleven", "Nine", "Two", "Five"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d"}};
    String answers[] = {"Eleven", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

    int score = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_topic);

        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialg_box, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(mView);

        alertDialogBuilder.setTitle("Add User Details");

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
                Intent myIntent = new Intent("com.rheedkhadaly.quizzes.THIRDTOPIC");
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListAdapter topicAdapter = new CustomQuestionAdapter(this, images, quiz_questions, quiz_answers, answers);
        ListView topicListView = (ListView) findViewById(R.id.quiz_list_view);
        topicListView.setAdapter(topicAdapter);

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
                        Intent myIntent = new Intent("com.rheedkhadaly.quizzes.THIRDTOPIC");
                        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(myIntent);
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
                Intent myIntent = new Intent("com.rheedkhadaly.quizzes.THIRDTOPIC");
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
