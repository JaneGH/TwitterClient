package com.itclimb.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.itclimb.twitterclient.hashtags.di.DaggerHashtagsComponent;
import com.itclimb.twitterclient.images.di.DaggerImagesComponent;
import com.itclimb.twitterclient.images.di.ImagesComponent;
import com.itclimb.twitterclient.images.di.ImagesModule;
import com.itclimb.twitterclient.images.di.LibsModule;
import com.itclimb.twitterclient.hashtags.di.HashtagsComponent;
import com.itclimb.twitterclient.hashtags.di.HashtagsModule;
import com.itclimb.twitterclient.hashtags.ui.HashtagsView;
import com.itclimb.twitterclient.images.ui.ImagesView;
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

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, com.itclimb.twitterclient.images.ui.adapters.OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }

    public HashtagsComponent getHashtagsComponent(HashtagsView view, com.itclimb.twitterclient.hashtags.ui.adapters.OnItemClickListener  clickListener){
        return DaggerHashtagsComponent
                .builder()
                .libsModule(new LibsModule(null))
                .hashtagsModule(new HashtagsModule(view, clickListener))
                .build();
    }
}
