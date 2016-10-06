package com.rheedkhadaly.quizzes;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rheed on 10/6/2016.
 */

class CustomTopicAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer[] imageTopics;
    private final String[] quizTopics;

    CustomTopicAdapter(Activity context, Integer[] imageTopics, String[] quizTopics) {
        super(context, R.layout.activity_main, quizTopics);

        this.context = context;
        this.imageTopics = imageTopics;
        this.quizTopics = quizTopics;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater topicInflater = LayoutInflater.from(getContext());

        View customView = topicInflater.inflate(R.layout.custom_topic_list, parent, false);

        ImageView quizImage = (ImageView) customView.findViewById(R.id.imageTopicPicture);

        TextView textTopic = (TextView) customView.findViewById(R.id.txtTopic);

        textTopic.setText(quizTopics[position]);
        quizImage.setImageResource(imageTopics[position]);

        return customView;
    }
}
