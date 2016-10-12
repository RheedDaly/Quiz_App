package com.rheedkhadaly.quizzes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Locale;

/**
 * Created by Rheed on 9/28/2016.
 */

public class ThirdTopic extends AppCompatActivity {

    static final String[] texts = {"Sa bora moreki", "Sa bora moreki", "Sa bora moreki", "Sa bora moreki", "Sa bora moreki", "Sa bora moreki", "Sa bora moreki", "Sa bora moreki", "Sa bora moreki", "Sa bora moreki"};

    String topics[] = {"Name the animal above", "Name the animal above", "Name the animal above", "Name the animal above", "Name the animal above", "Name the animal above", "Name the animal above", "Name the animal above", "Name the animal above", "Name the animal above"};
    Integer images[] = {R.drawable.ants, R.drawable.lamb, R.drawable.rhinoceros, R.drawable.butterfly, R.drawable.dog, R.drawable.donkey, R.drawable.owl, R.drawable.flamingo, R.drawable.stingray, R.drawable.warthog};

    TextToSpeech tts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_topic);

        tts = new TextToSpeech(ThirdTopic.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });

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

        ListAdapter topicAdapter = new CustomQuestionAdapter(this, texts, images, topics);
        ListView topicListView = (ListView) findViewById(R.id.quiz_list_view);
        topicListView.setAdapter(topicAdapter);

        topicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {

                } catch (Exception e) {

                }
            }
        });

    }

    @Override
    protected void onPause() {
        if (tts != null) {

        }
        super.onPause();
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
