package com.rheedkhadaly.quizzes;

import android.app.Activity;
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

    private final Activity context;
    private final Integer[] quizImages;
    private final String[] quizQuestions;

    CustomQuestionAdapter(Activity context, Integer[] quizImages, String[] quizQuestions) {
        super(context, R.layout.first_topic, quizQuestions);

        this.context = context;
        this.quizImages = quizImages;
        this.quizQuestions = quizQuestions;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater topicInflater = LayoutInflater.from(getContext());

        View customView = topicInflater.inflate(R.layout.custom_question_list, parent, false);

        ImageView quizImage = (ImageView) customView.findViewById(R.id.imageQuizPicture);

        TextView textQuestions = (TextView) customView.findViewById(R.id.txtQuestions);

        RadioButton radioComma = (RadioButton) customView.findViewById(R.id.rbtnComma);
        RadioButton radioSemiColon = (RadioButton) customView.findViewById(R.id.rbtnSemiColon);
        RadioButton radioExclamation = (RadioButton) customView.findViewById(R.id.rbtnExclamation);
        RadioButton radioQuestionMark = (RadioButton) customView.findViewById(R.id.rbtnQuestionMark);

        textQuestions.setText(quizQuestions[position]);
        quizImage.setImageResource(quizImages[position]);

        return customView;
    }
}
