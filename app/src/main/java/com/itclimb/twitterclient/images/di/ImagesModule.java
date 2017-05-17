package com.itclimb.twitterclient.images.di;

import com.itclimb.twitterclient.api.CustomTwitterApiClient;
import com.itclimb.twitterclient.entities.Image;
import com.itclimb.twitterclient.lib.base.EventBus;
import com.itclimb.twitterclient.lib.base.ImageLoader;
import com.itclimb.twitterclient.main.ui.ImagesInteractor;
import com.itclimb.twitterclient.main.ui.ImagesInteractorImpl;
import com.itclimb.twitterclient.main.ui.ImagesPresenter;
import com.itclimb.twitterclient.main.ui.ImagesPresenterImpl;
import com.itclimb.twitterclient.main.ui.ImagesRepository;
import com.itclimb.twitterclient.main.ui.ImagesRepositoryImpl;
import com.itclimb.twitterclient.images.ui.ImagesView;
import com.itclimb.twitterclient.images.ui.adapters.ImagesAdapter;
import com.itclimb.twitterclient.images.ui.adapters.OnItemClickListener;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener){
        return new ImagesAdapter(dataset, imageLoader, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesItemsList(){
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    ImagesPresenter providesImagesPresenter(ImagesView view, EventBus eventBus, ImagesInteractor interactor){
        return new ImagesPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    ImagesView providesImagesView(){
        return this.view;
    }

    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new ImagesRepositoryImpl(eventBus, client);
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
