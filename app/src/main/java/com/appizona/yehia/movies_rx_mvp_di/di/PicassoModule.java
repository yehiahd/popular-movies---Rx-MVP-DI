package com.appizona.yehia.movies_rx_mvp_di.di;

import android.content.Context;

import com.appizona.yehia.movies_rx_mvp_di.di.qualifier.ApplicationContext;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yehia on 04/10/17.
 */

@Module(includes = ApplicationContextModule.class)
public class PicassoModule {

    @Provides
    Picasso picasso(@ApplicationContext Context context) {
        return new Picasso.Builder(context).build();
    }
}
