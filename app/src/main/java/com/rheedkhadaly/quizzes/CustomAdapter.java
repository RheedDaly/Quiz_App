package com.rheedkhadaly.quizzes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rheed on 10/4/2016.
 */

class CustomAdapter extends ArrayAdapter<String> {

    CustomAdapter(Context context, String[] quizQuestions) {
        super(context, R.layout.first_topic, quizQuestions);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater topicInflater = LayoutInflater.from(getContext());
        View customView = topicInflater.inflate(R.layout.custom_row, parent, false);

        String st_topic = getItem(position);
        TextView topicView = (TextView) customView.findViewById(R.id.textView2);
        ImageView topicImage = (ImageView) customView.findViewById(R.id.imageView);

        topicView.setText(st_topic);
        topicImage.setImageResource(R.drawable.quiz_picture);

        return customView;
    }
}
