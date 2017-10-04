package com.appizona.yehia.movies_rx_mvp_di.di;

import android.content.Context;

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
    Context context() {
        return context;
    }
}
