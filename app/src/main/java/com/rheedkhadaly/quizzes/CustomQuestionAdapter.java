package com.rheedkhadaly.quizzes;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Rheed on 10/4/2016.
 */

class CustomQuestionAdapter extends ArrayAdapter<String> implements View.OnClickListener {

    private final Activity context;
    private final Integer[] quizImages;
    private final String[] quizQuestions;
    private final String[] quizAnswers;
    private final String[] answers;

    ImageView quizImage;
    ImageView image_bad;
    ImageView image_good;

    TextView textQuestions;

    ImageButton quizImageButton;

    TextToSpeech tts;

    RadioButton first_answer;
    RadioButton second_answer;
    RadioButton third_answer;
    RadioButton fourth_answer;

    CustomQuestionAdapter(Activity context, Integer[] quizImages, String[] quizQuestions, String[] quizAnswers, String[] answers) {
        super(context, R.layout.first_topic, quizQuestions);

        this.context = context;
        this.quizImages = quizImages;
        this.quizQuestions = quizQuestions;
        this.quizAnswers = quizAnswers;
        this.answers = answers;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater topicInflater = LayoutInflater.from(getContext());

        View customView = topicInflater.inflate(R.layout.custom_question_list, parent, false);

        quizImage = (ImageView) customView.findViewById(R.id.imageQuizPicture);

        textQuestions = (TextView) customView.findViewById(R.id.txtQuestions);

        quizImageButton = (ImageButton) customView.findViewById(R.id.image_button_play);

        first_answer = (RadioButton) customView.findViewById(R.id.radio_button_first_answer);
        second_answer = (RadioButton) customView.findViewById(R.id.radio_button_second_answer);
        third_answer = (RadioButton) customView.findViewById(R.id.radio_button_third_answer);
        fourth_answer = (RadioButton) customView.findViewById(R.id.radio_button_fourth_answer);

        image_bad = (ImageView) customView.findViewById(R.id.imageBad);
        image_good = (ImageView) customView.findViewById(R.id.imageGood);

        quizImageButton.setOnClickListener(this);
        quizImageButton.setTag(position);
        first_answer.setOnClickListener(this);
        second_answer.setOnClickListener(this);
        third_answer.setOnClickListener(this);
        fourth_answer.setOnClickListener(this);

        tts = new TextToSpeech(this.context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });

        quizImage.setImageResource(quizImages[position]);
        textQuestions.setText(quizQuestions[position]);

        first_answer.setText(answers[position]);
        second_answer.setText(answers[position]);
        third_answer.setText(answers[position]);
        fourth_answer.setText(answers[position]);

        return customView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_button_play:
                int pos = (Integer) v.getTag();
                String question = quizQuestions[pos];
                tts.speak(question, TextToSpeech.QUEUE_FLUSH, null);
                break;
            case R.id.radio_button_first_answer:
                String a = first_answer.getText().toString();
                Toast.makeText(this.context, a, Toast.LENGTH_SHORT).show();

                break;
            case R.id.radio_button_second_answer:
                String b = second_answer.getText().toString();
                Toast.makeText(this.context, b, Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_button_third_answer:
                String c = third_answer.getText().toString();
                Toast.makeText(this.context, c, Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_button_fourth_answer:
                String d = fourth_answer.getText().toString();
                Toast.makeText(this.context, d, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
