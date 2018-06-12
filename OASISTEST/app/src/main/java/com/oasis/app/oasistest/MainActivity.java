package com.oasis.app.oasistest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.teamviewer.sdk.screensharing.api.TVCreationError;
import com.teamviewer.sdk.screensharing.api.TVSession;
import com.teamviewer.sdk.screensharing.api.TVSessionCode;
import com.teamviewer.sdk.screensharing.api.TVSessionConfiguration;
import com.teamviewer.sdk.screensharing.api.TVSessionCreationCallback;
import com.teamviewer.sdk.screensharing.api.TVSessionFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TVSessionConfiguration config =
                        new TVSessionConfiguration.Builder(new TVSessionCode("s84-356-176"))
                                .build();

                TVSessionFactory.createTVSession(MainActivity.this, "02f838cd-43cc-18e8-f4fd-82108c1fe9c5",
                        new TVSessionCreationCallback() {
                            @Override
                            public void onTVSessionCreationSuccess(TVSession session) {
                                session.start(config);
                            }

                            @Override
                            public void onTVSessionCreationFailed(TVCreationError error) {
                                Toast.makeText(MainActivity.this, error.toString(),Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
