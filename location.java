package com.miniproject.thirdeye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class location extends AppCompatActivity {
   Button track_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        track_location=(Button)findViewById(R.id.button4);
        track_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(location.this, MapsActivity.class);
                startActivity(i);
            }
        });
    }
}
