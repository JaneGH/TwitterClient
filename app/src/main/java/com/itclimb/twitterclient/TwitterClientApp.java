package com.itclimb.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.itclimb.twitterclient.di.DaggerImagesComponent;
import com.itclimb.twitterclient.di.ImagesComponent;
import com.itclimb.twitterclient.di.ImagesModule;
import com.itclimb.twitterclient.di.LibsModule;
import com.itclimb.twitterclient.images.ImagesFragment;
import com.itclimb.twitterclient.main.ui.ImagesView;
import com.itclimb.twitterclient.main.ui.adapters.OnItemClickListener;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.*;

import io.fabric.sdk.android.Fabric;

/**
 * Created by MyComp on 15.05.2017.
 */

public class TwitterClientApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }
}
