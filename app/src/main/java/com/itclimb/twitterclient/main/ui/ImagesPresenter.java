package com.itclimb.twitterclient.main.ui;


import com.itclimb.twitterclient.images.events.ImagesEvent;

public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
