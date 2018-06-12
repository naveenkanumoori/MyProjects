package com.gigcommit.app.gigcommit;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class TermsAndConditionsActivity extends AppCompatActivity {

    ScrollView scrollView;
    Button agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        getSupportActionBar().hide();

        agree = findViewById(R.id.agree);
        agree.setEnabled(false);

        scrollView = findViewById(R.id.tncscroll);

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (TermsAndConditionsActivity.this.scrollView != null) {
                    if (scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY())) {
                        //Toast.makeText(TermsAndConditionsActivity.this, "Reched", Toast.LENGTH_SHORT).show();
                        agree.setEnabled(true);
                        agree.setBackgroundResource(R.drawable.rounded_button_bg_white);
                        agree.setTextColor(Color.parseColor("#009d8a"));
                    } else {
                        //scroll view is not at bottom
                    }
                }
            }
        });
    }
}
