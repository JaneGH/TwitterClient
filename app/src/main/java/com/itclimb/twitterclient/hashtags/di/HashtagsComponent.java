package com.itclimb.twitterclient.hashtags.di;

import com.itclimb.twitterclient.images.di.LibsModule;
import com.itclimb.twitterclient.hashtags.HashtagsPresenter;
import com.itclimb.twitterclient.hashtags.ui.HashtagsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = {LibsModule.class, HashtagsModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
    HashtagsPresenter getPresenter();
}
