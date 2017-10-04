package com.appizona.yehia.movies_rx_mvp_di.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void showViews(View... views) {
        for (View v : views)
            if (v != null)
                v.setVisibility(View.VISIBLE);
    }

    protected void hideViews(View... views) {
        for (View v : views)
            if (v != null)
                v.setVisibility(View.GONE);
    }
}
