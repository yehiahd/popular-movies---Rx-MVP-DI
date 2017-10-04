package com.appizona.yehia.movies_rx_mvp_di.di;

import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by yehia on 04/10/17.
 */

@Component(modules = PicassoModule.class)
public interface PicassoComponent {

    Picasso picasso();
}
