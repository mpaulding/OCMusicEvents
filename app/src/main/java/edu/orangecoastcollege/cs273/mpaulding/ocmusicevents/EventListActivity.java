package edu.orangecoastcollege.cs273.mpaulding.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class EventListActivity extends ListActivity {

    private ListView eventsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        eventsListView = (ListView) findViewById(R.id.eventsListView);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

        //setContentView(R.layout.activity_event_list);
    }


    protected void onListItemClick(ListView l, View v, int pos, long id)
    {
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        String title = MusicEvent.titles[pos];
        String details = MusicEvent.details[pos];
        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("Details", details);

        startActivity(detailsIntent);
    }
}
