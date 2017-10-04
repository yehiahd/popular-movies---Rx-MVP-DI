package com.appizona.yehia.movies_rx_mvp_di.di;

import android.content.Context;

import com.appizona.yehia.movies_rx_mvp_di.di.qualifier.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yehia on 04/10/17.
 */

@Module
public class ApplicationContextModule {

    private Context context;

    public ApplicationContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @ApplicationContext
    Context context() {
        return context;
    }
}
