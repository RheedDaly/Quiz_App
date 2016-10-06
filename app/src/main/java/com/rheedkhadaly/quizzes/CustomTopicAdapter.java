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
 * Created by Rheed on 10/6/2016.
 */

class CustomTopicAdapter extends ArrayAdapter<String> {

    CustomTopicAdapter(Context context, String[] quizTopics) {
        super(context, R.layout.activity_main, quizTopics);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater topicInflater = LayoutInflater.from(getContext());
        View customView = topicInflater.inflate(R.layout.custom_topic_list, parent, false);

        String st_topic = getItem(position);

        ImageView quizImage = (ImageView) customView.findViewById(R.id.imageTopicPicture);

        TextView textTopic = (TextView) customView.findViewById(R.id.txtTopic);

        textTopic.setText(st_topic);
        quizImage.setImageResource(R.drawable.quiz_picture);

        return customView;
    }
}
