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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;
/**
 * Created by Rheed on 9/28/2016.
 */

public class FirstTopic extends AppCompatActivity {

    Integer images[] = {R.drawable.ants, R.drawable.lamb, R.drawable.rhinoceros, R.drawable.butterfly, R.drawable.dog, R.drawable.donkey, R.drawable.owl, R.drawable.flamingo, R.drawable.stingray, R.drawable.warthog};
    String quiz_questions[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    String quiz_answers[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    String answers[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

    String gender;

    String display_name;

    EditText name;
    RadioButton rbmale;
    RadioButton rbfemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_topic);

        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialg_box, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(mView);

        alertDialogBuilder.setTitle("Add User");


        name = (EditText) mView.findViewById(R.id.edit_text_name);
        rbmale = (RadioButton) mView.findViewById(R.id.radio_button_male);
        rbfemale = (RadioButton) mView.findViewById(R.id.radio_button_female);

        alertDialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                display_name = name.getText().toString();


                Toast.makeText(FirstTopic.this, "Hey " + display_name + " " + gender, Toast.LENGTH_LONG).show();

            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
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

        topicListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String s = String.valueOf(parent.getItemAtPosition(position));

                Toast.makeText(FirstTopic.this, s, Toast.LENGTH_SHORT).show();
            }
        });

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
                        Intent myIntent = new Intent("com.rheedkhadaly.quizzes.FIRSTTOPIC");
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
                Intent myIntent = new Intent("com.rheedkhadaly.quizzes.FIRSTTOPIC");
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
