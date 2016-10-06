package com.rheedkhadaly.quizzes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String topics[] = {"FirstTopic", "SecondTopic", "ThirdTopic", "FourthTopic"};
    Integer images[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter topicAdapter = new CustomTopicAdapter(this, images, topics);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
