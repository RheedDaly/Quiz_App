package com.rheedkhadaly.quizzes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_results);

        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialg_box, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(mView);

        alertDialogBuilder.setTitle("Add User Details");

//        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, numbers);
//
//        name = (EditText) mView.findViewById(R.id.edit_text_name);
//        rbmale = (RadioButton) mView.findViewById(R.id.radio_button_male);
//        rbfemale = (RadioButton) mView.findViewById(R.id.radio_button_female);
//        spinnerAge = (Spinner) mView.findViewById(R.id.spinnerAge);
//        spinnerAge.setAdapter(adapter);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(ShowResult.this, "Hey ", Toast.LENGTH_SHORT).show();
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

        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView3 = (TextView) findViewById(R.id.textView3);

        Intent in = getIntent();

        ArrayList<String> answers = (ArrayList<String>) in.getSerializableExtra("answers");
        int score = in.getIntExtra("score", 0);
        String message = "";
        // get the value of selected answers from custom adapter
        for (int i = 0; i < answers.size(); i++) {
            message += i + " " + answers.get(i) + "\n";
        }
        textView.setText(message);
        textView3.setText("Your score is :" + String.valueOf(score));
    }
}
