package com.appizona.yehia.movies_rx_mvp_di.di;

import android.content.Context;

import com.appizona.yehia.movies_rx_mvp_di.di.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yehia on 04/10/17.
 */

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityContext
    Context context() {
        return context;
    }
}
