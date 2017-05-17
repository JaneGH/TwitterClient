package com.itclimb.twitterclient.hashtags.di;

import com.itclimb.twitterclient.api.CustomTwitterApiClient;
import com.itclimb.twitterclient.entities.Hashtag;
import com.itclimb.twitterclient.hashtags.HashtagsInteractor;
import com.itclimb.twitterclient.hashtags.HashtagsInteractorImpl;
import com.itclimb.twitterclient.hashtags.HashtagsPresenter;
import com.itclimb.twitterclient.hashtags.HashtagsPresenterImpl;
import com.itclimb.twitterclient.hashtags.HashtagsRepository;
import com.itclimb.twitterclient.hashtags.HashtagsRepositoryImpl;
import com.itclimb.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import com.itclimb.twitterclient.hashtags.ui.adapters.OnItemClickListener;
import com.itclimb.twitterclient.hashtags.ui.HashtagsView;
import com.itclimb.twitterclient.lib.base.EventBus;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HashtagsModule {
    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    HashtagsAdapter providesAdapter(List<Hashtag> dataset, OnItemClickListener clickListener){
        return new HashtagsAdapter(dataset, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> providesItemsList(){
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    HashtagsPresenter providesImagesPresenter(HashtagsView view, EventBus eventBus, HashtagsInteractor interactor){
        return new HashtagsPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    HashtagsView providesImagesView(){
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsInteractor providesImagesInteractor(HashtagsRepository repository){
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new HashtagsRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session) {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    Session providesTwitter() {
        return Twitter.getSessionManager().getActiveSession();
    }
}
