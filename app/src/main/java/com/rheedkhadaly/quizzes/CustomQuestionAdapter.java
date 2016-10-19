package com.rheedkhadaly.quizzes;

import android.app.Activity;
import android.os.CountDownTimer;
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

class CustomQuestionAdapter extends ArrayAdapter<String> implements View.OnClickListener {

    private final Activity context;
    private final Integer[] quizImages;
    private final String[] quizQuestions;
    private final String[][] quizAnswers;
    private final String[] answers;

    TextToSpeech tts;

    String questionToSpeech = "";
    String answerToSpeech = "Is it";

    TextView quizCounter;
    ImageView quizImage;
    TextView textQuestions;
    ImageButton quizImageButton;
    RadioButton firstAnswer;
    RadioButton secondAnswer;
    RadioButton thirdAnswer;
    RadioButton fourthAnswer;

    ImageView imageBad;
    ImageView imageGood;

    CustomQuestionAdapter(Activity context, Integer[] quizImages, String[] quizQuestions, String[][] quizAnswers, String[] answers) {
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

        tts = new TextToSpeech(this.context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

        quizCounter = (TextView) customView.findViewById(R.id.textCounter);

        new CountDownTimer(100000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                quizCounter.setText("Quiz Timer: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                quizCounter.setText("Done!");
            }
        }.start();

        quizImage = (ImageView) customView.findViewById(R.id.imageQuizPicture);

        textQuestions = (TextView) customView.findViewById(R.id.txtQuestions);

        quizImageButton = (ImageButton) customView.findViewById(R.id.image_button_play);

        firstAnswer = (RadioButton) customView.findViewById(R.id.radio_button_first_answer);
        secondAnswer = (RadioButton) customView.findViewById(R.id.radio_button_second_answer);
        thirdAnswer = (RadioButton) customView.findViewById(R.id.radio_button_third_answer);
        fourthAnswer = (RadioButton) customView.findViewById(R.id.radio_button_fourth_answer);

        imageBad = (ImageView) customView.findViewById(R.id.imageBad);
        imageGood = (ImageView) customView.findViewById(R.id.imageGood);

        quizImageButton.setOnClickListener(this);
        quizImageButton.setTag(position);
        firstAnswer.setOnClickListener(this);
        firstAnswer.setTag(position);
        secondAnswer.setOnClickListener(this);
        secondAnswer.setTag(position);
        thirdAnswer.setOnClickListener(this);
        thirdAnswer.setTag(position);
        fourthAnswer.setOnClickListener(this);
        fourthAnswer.setTag(position);

        quizImage.setImageResource(quizImages[position]);
        textQuestions.setText(quizQuestions[position]);

        firstAnswer.setText(quizAnswers[position][0]);
        secondAnswer.setText(quizAnswers[position][1]);
        thirdAnswer.setText(quizAnswers[position][2]);
        fourthAnswer.setText(quizAnswers[position][3]);

        return customView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_button_play:

                int questionPosition = (Integer) v.getTag();

                switch (questionPosition) {
                    case 0:
                        questionToSpeech = "First Question";
                        break;
                    case 1:
                        questionToSpeech = "Second Question";
                        break;
                    case 2:
                        questionToSpeech = "Third Question";
                        break;
                    case 3:
                        questionToSpeech = "Fourth Question";
                        break;
                    case 4:
                        questionToSpeech = "Fifth Question";
                        break;
                    case 5:
                        questionToSpeech = "Sixth Question";
                        break;
                    case 6:
                        questionToSpeech = "Seventh Question";
                        break;
                    case 7:
                        questionToSpeech = "Eight Question";
                        break;
                    case 8:
                        questionToSpeech = "Ninth Question";
                        break;
                    case 9:
                        questionToSpeech = "Tenth Question";
                        break;
                }

                String questionToAsk = quizQuestions[questionPosition];
                tts.speak(questionToSpeech + " " + questionToAsk, TextToSpeech.QUEUE_ADD, null);
                String firstAnswerToSpeech = quizAnswers[questionPosition][0];
                tts.speak(answerToSpeech + " " + firstAnswerToSpeech, TextToSpeech.QUEUE_ADD, null);
                String secondAnswerToSpeech = quizAnswers[questionPosition][1];
                tts.speak(answerToSpeech + " " + secondAnswerToSpeech, TextToSpeech.QUEUE_ADD, null);
                String thirdAnswerToSpeech = quizAnswers[questionPosition][2];
                tts.speak(answerToSpeech + " " + thirdAnswerToSpeech, TextToSpeech.QUEUE_ADD, null);
                String fourthAnswerToSpeech = quizAnswers[questionPosition][3];
                tts.speak(answerToSpeech + " " + fourthAnswerToSpeech, TextToSpeech.QUEUE_ADD, null);

                break;
            case R.id.radio_button_first_answer:

                int firstAnswerPosition = (Integer) v.getTag();

                String a;
                String aa = quizAnswers[firstAnswerPosition][0];
                String qq = answers[firstAnswerPosition];

                if (aa == qq) {
                    a = "true";
                } else {
                    a = "false";
                }

                Toast.makeText(this.context, aa + " " + a, Toast.LENGTH_SHORT).show();

                break;
            case R.id.radio_button_second_answer:

                int secondAnswerPosition = (Integer) v.getTag();

                String zz = quizAnswers[secondAnswerPosition][1];
                String ff = answers[secondAnswerPosition];

                if (zz == ff) {
                    a = "true";
                } else {
                    a = "false";
                }

                Toast.makeText(this.context, zz + " " + a, Toast.LENGTH_SHORT).show();

                break;
            case R.id.radio_button_third_answer:

                int thirdAnswerPosition = (Integer) v.getTag();

                String cc = quizAnswers[thirdAnswerPosition][2];
                String tt = answers[thirdAnswerPosition];

                if (cc == tt) {
                    a = "true";
                } else {
                    a = "false";
                }

                Toast.makeText(this.context, cc + " " + a, Toast.LENGTH_SHORT).show();

                break;
            case R.id.radio_button_fourth_answer:

                int fourthAnswerPosition = (Integer) v.getTag();

                String dd = quizAnswers[fourthAnswerPosition][3];
                String oo = answers[fourthAnswerPosition];

                if (dd == oo) {
                    a = "true";
                } else {
                    a = "false";
                }

                Toast.makeText(this.context, dd + " " + a, Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
