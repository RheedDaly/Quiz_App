package com.rheedkhadaly.quizzes;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

class CustomQuestionAdapter extends ArrayAdapter<String> {

    public static ArrayList<String> selectedAnswers;
    private final Context context;
    private final Integer[] quizImages;
    private final String[] quizQuestions;
    private final String[][] quizAnswers;
    private final String[] answers;
    TextToSpeech tts;
    String questionToSpeech = "";
    String answerToSpeech = "Is it";

    CustomQuestionAdapter(Context context, Integer[] quizImages, String[] quizQuestions, String[][] quizAnswers, String[] answers) {
        super(context, R.layout.first_topic, quizQuestions);

        this.context = context;
        this.quizImages = quizImages;
        this.quizQuestions = quizQuestions;
        this.quizAnswers = quizAnswers;
        this.answers = answers;

        selectedAnswers = new ArrayList<>();
        for (int i = 0; i < quizQuestions.length; i++) {
            selectedAnswers.add("Not Attempted");
        }

    }

    @Override
    public int getCount() {
        return quizQuestions.length;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater mInflater;
        final ViewHolder holder;

        if (convertView == null) {
            mInflater = LayoutInflater.from(getContext());
            convertView = mInflater.inflate(R.layout.custom_question_list, parent, false);
            holder = new ViewHolder();
            holder.quizImage = (ImageView) convertView.findViewById(R.id.imageQuizPicture);
            holder.textQuestions = (TextView) convertView.findViewById(R.id.txtQuestions);

            holder.quizImageButton = (ImageButton) convertView.findViewById(R.id.image_button_play);

            holder.radioGroupAnswers = (RadioGroup) convertView.findViewById(R.id.radioGroupAnswers);

            holder.firstAnswer = (RadioButton) convertView.findViewById(R.id.text_view_first_answer);
            holder.secondAnswer = (RadioButton) convertView.findViewById(R.id.text_view_second_answer);
            holder.thirdAnswer = (RadioButton) convertView.findViewById(R.id.text_view_third_answer);
            holder.fourthAnswer = (RadioButton) convertView.findViewById(R.id.text_view_fourth_answer);

            holder.imageBad = (ImageView) convertView.findViewById(R.id.imageBad);
            holder.imageGood = (ImageView) convertView.findViewById(R.id.imageGood);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        tts = new TextToSpeech(this.context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

        holder.quizImage.setImageResource(quizImages[position]);

        holder.textQuestions.setText(quizQuestions[position]);

        holder.firstAnswer.setText(quizAnswers[position][0]);
        holder.secondAnswer.setText(quizAnswers[position][1]);
        holder.thirdAnswer.setText(quizAnswers[position][2]);
        holder.fourthAnswer.setText(quizAnswers[position][3]);

        holder.quizImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
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

                String questionToAsk = quizQuestions[position];
                tts.speak(questionToSpeech + " " + questionToAsk, TextToSpeech.QUEUE_ADD, null);
                String firstAnswerToSpeech = quizAnswers[position][0];
                tts.speak(answerToSpeech + " " + firstAnswerToSpeech, TextToSpeech.QUEUE_ADD, null);
                String secondAnswerToSpeech = quizAnswers[position][1];
                tts.speak(answerToSpeech + " " + secondAnswerToSpeech, TextToSpeech.QUEUE_ADD, null);
                String thirdAnswerToSpeech = quizAnswers[position][2];
                tts.speak(answerToSpeech + " " + thirdAnswerToSpeech, TextToSpeech.QUEUE_ADD, null);
                String fourthAnswerToSpeech = quizAnswers[position][3];
                tts.speak(answerToSpeech + " " + fourthAnswerToSpeech, TextToSpeech.QUEUE_ADD, null);

            }
        });

        holder.radioGroupAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.text_view_first_answer:
                        selectedAnswers.set(position, holder.firstAnswer.getText().toString());
                        break;
                    case R.id.text_view_second_answer:
                        selectedAnswers.set(position, holder.secondAnswer.getText().toString());
                        break;
                    case R.id.text_view_third_answer:
                        selectedAnswers.set(position, holder.thirdAnswer.getText().toString());
                        break;
                    case R.id.text_view_fourth_answer:
                        selectedAnswers.set(position, holder.fourthAnswer.getText().toString());
                        break;
                }
            }
        });

        return convertView;

    }

    static class ViewHolder {

        ImageView quizImage;

        TextView textQuestions;

        ImageButton quizImageButton;

        RadioGroup radioGroupAnswers;

        RadioButton firstAnswer;
        RadioButton secondAnswer;
        RadioButton thirdAnswer;
        RadioButton fourthAnswer;

        ImageView imageBad;
        ImageView imageGood;
    }
}
