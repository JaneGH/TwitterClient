package com.itclimb.twitterclient.di;

import com.itclimb.twitterclient.images.ImagesFragment;
import com.itclimb.twitterclient.main.ui.ImagesPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = {LibsModule.class, ImagesModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();
}
