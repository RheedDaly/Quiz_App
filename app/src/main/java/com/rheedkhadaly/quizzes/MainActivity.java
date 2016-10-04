package com.rheedkhadaly.quizzes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    String topics[] = {"FirstTopic", "SecondTopic", "ThirdTopic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAdapter topicAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, topics);
        ListView topicListView = (ListView)findViewById(R.id.topics_list_view);
        topicListView.setAdapter(topicAdapter);

        topicListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String page = topics[position];
                try{
                    Class ourpage = Class.forName("com.rheedkhadaly.quizzes." + page);
                    Intent a = new Intent(MainActivity.this, ourpage);
                    startActivity(a);
                } catch (ClassNotFoundException e) {

                }
            }
        });

    }


}