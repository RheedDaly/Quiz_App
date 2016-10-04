package com.rheedkhadaly.quizzes;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Rheed on 9/28/2016.
 */

public class FirstTopic extends AppCompatActivity{

    String topics[] = {"FirstTopic", "SecondTopic", "ThirdTopic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_topic);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListAdapter topicAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, topics);
        ListView topicListView = (ListView)findViewById(R.id.quiz_list_view);
        topicListView.setAdapter(topicAdapter);

        topicListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try{

                } catch (Exception e) {

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                Dialog a = new Dialog(this);
                a.setTitle("Quit Quiz");
                TextView tv = new TextView(this);
                a.show();

                Intent myIntent = new Intent("com.rheedkhadaly.quizzes.MAINACTIVITY");
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
