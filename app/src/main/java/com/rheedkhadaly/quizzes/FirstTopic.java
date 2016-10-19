package com.rheedkhadaly.quizzes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class FirstTopic extends AppCompatActivity {

    Integer images[] = {R.drawable.ants, R.drawable.lamb, R.drawable.rhinoceros, R.drawable.butterfly, R.drawable.dog, R.drawable.donkey, R.drawable.owl, R.drawable.flamingo, R.drawable.stingray, R.drawable.warthog};
    String quiz_questions[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    String[][] quiz_answers = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}, {"17", "18", "19", "20"}, {"21", "22", "23", "24"}, {"25", "26", "27", "28"}, {"29", "30", "31", "32"}, {"33", "34", "35", "36"}, {"37", "38", "39", "40"}};
    String answers[] = {"1", "5", "9", "13", "17", "21", "25", "29", "33", "37"};

    Integer[] numbers = new Integer[99];

    String display_name;

    EditText name;
    Spinner spinnerAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_topic);

        for (int i = 0; i <= 98; i++) {
            numbers[i] = i + 1;
        }

        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialg_box, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(mView);

        alertDialogBuilder.setTitle("Add User");

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, numbers);

        name = (EditText) mView.findViewById(R.id.edit_text_name);
        spinnerAge = (Spinner) mView.findViewById(R.id.spinnerAge);
        spinnerAge.setAdapter(adapter);

        alertDialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                display_name = name.getText().toString();


                Toast.makeText(FirstTopic.this, "Hey " + display_name, Toast.LENGTH_LONG).show();

            }
        });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent myIntent = new Intent("com.rheedkhadaly.quizzes.MAINACTIVITY");
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListAdapter topicAdapter = new CustomQuestionAdapter(this, images, quiz_questions, quiz_answers, answers);
        ListView topicListView = (ListView)findViewById(R.id.quiz_list_view);
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
