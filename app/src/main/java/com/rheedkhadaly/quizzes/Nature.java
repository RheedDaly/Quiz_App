package com.rheedkhadaly.quizzes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Nature extends AppCompatActivity implements View.OnClickListener {

    Integer images[] = {R.drawable.ants, R.drawable.lamb, R.drawable.rhinoceros, R.drawable.butterfly, R.drawable.dog, R.drawable.donkey, R.drawable.owl, R.drawable.flamingo, R.drawable.stingray, R.drawable.warthog};
    String quiz_questions[] = {"What is the national animal of Canada?", "What is the national animal of Albania?", "What kind of animal is the largest living creature on Earth", "Give another name for the study of fossils?", "What do dragonflies prefer to eat?", "What is called a fish with a snake-like body?", "In which city is the oldest zoo in the world?", "Which plant does the Canadian flag contain?", "Which is the largest species of the tiger?", "The bite of which insect causes the Lyme Disease?"};
    String[][] quiz_answers = {{"North American beaver", "2", "3", "4"}, {"Golden eagle", "6", "7", "8"}, {"Whale", "10", "11", "12"}, {"Paleontology", "14", "15", "16"}, {"Mosquitoes", "18", "19", "20"}, {"Eel fish", "22", "23", "24"}, {"Vienna", "26", "27", "28"}, {"Maple", "30", "31", "32"}, {"Siberian tiger", "34", "35", "36"}, {"Deer Tick", "38", "39", "40"}};
    String answers[] = {"North American beaver", "Golden eagle", "Whale", "Paleontology", "Mosquitoes", "Eel fish", "Vienna", "Maple", "Plankton", "Siberian tiger", "Deer Tick"};

    Integer[] numbers = new Integer[99];

    String name;
    String gender;
    int age;

    TextView quizCounter;

    EditText userName;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
    Spinner spinnerAge;
    Button calculateScore;

    UserDetails u;

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

        userName = (EditText) mView.findViewById(R.id.edit_text_name);
        radioButtonMale = (RadioButton) mView.findViewById(R.id.radio_button_male);
        radioButtonFemale = (RadioButton) mView.findViewById(R.id.radio_button_female);
        spinnerAge = (Spinner) mView.findViewById(R.id.spinnerAge);
        spinnerAge.setAdapter(adapter);

        alertDialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                name = userName.getText().toString();

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(userName.getWindowToken(), 0);

                if (radioButtonMale.isChecked()) {
                    gender = radioButtonMale.getText().toString();
                }

                if (radioButtonFemale.isChecked()) {
                    gender = radioButtonFemale.getText().toString();
                }

                age = Integer.parseInt(spinnerAge.getSelectedItem().toString());

                u = new UserDetails();

                u.setName(name);
                u.setGender(gender);
                u.setAge(age);

                Toast.makeText(Nature.this, "Hey " + u.getName() + " You are a " + u.getGener() + " and your " + u.getAge() + " years old.", Toast.LENGTH_LONG).show();

                quizCounter = (TextView) findViewById(R.id.textCounter);

                new CountDownTimer(100000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        quizCounter.setText("Quiz Timer: " + millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {
                        quizCounter.setText("Done!");
//
                    }
                }.start();
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

        calculateScore = (Button) findViewById(R.id.buttonFinished);

        calculateScore.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonFinished:

                Toast.makeText(Nature.this, u.getName() + " " + u.getGener() + " " + u.getAge() + " " + u.getScore(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
