package edu.orangecoastcollege.cs273.mpaulding.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView;
    private TextView eventTitleTextView;
    private TextView eventDetailsTextView;
    private Context context = (Context) this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        eventImageView = (ImageView) findViewById(R.id.eventImageView);
        eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        eventDetailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);

        Intent detailsIntent = getIntent();
        String title = detailsIntent.getStringExtra("Title");
        String details = detailsIntent.getStringExtra("Details");
        String imageFileName = title.replace(" ", "") + ".jpeg";

        AssetManager am = context.getAssets();
        try {
            InputStream stream = am.open(imageFileName);
            Drawable event = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(event);
        }
        catch (IOException ex)
        {
            Log.e("OC Music Events", "Error loading " + imageFileName, ex);
        }

        eventTitleTextView.setText(title);
        eventDetailsTextView.setText(details);



    }
}
