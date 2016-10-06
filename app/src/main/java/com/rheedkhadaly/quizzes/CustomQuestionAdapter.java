package com.rheedkhadaly.quizzes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Rheed on 10/4/2016.
 */

class CustomQuestionAdapter extends ArrayAdapter<String> {

    CustomQuestionAdapter(Context context, String[] quizQuestions) {
        super(context, R.layout.first_topic, quizQuestions);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater topicInflater = LayoutInflater.from(getContext());
        View customView = topicInflater.inflate(R.layout.custom_question_list, parent, false);

        String st_topic = getItem(position);

        ImageView quizImage = (ImageView) customView.findViewById(R.id.imageQuizPicture);

        TextView textQuestions = (TextView) customView.findViewById(R.id.txtQuestions);

        RadioButton radioComma = (RadioButton) customView.findViewById(R.id.rbtnComma);
        RadioButton radioSemiColon = (RadioButton) customView.findViewById(R.id.rbtnSemiColon);
        RadioButton radioExclamation = (RadioButton) customView.findViewById(R.id.rbtnExclamation);
        RadioButton radioQuestionMark = (RadioButton) customView.findViewById(R.id.rbtnQuestionMark);

        textQuestions.setText(st_topic);
        quizImage.setImageResource(R.drawable.quiz_picture);

        return customView;
    }
}
