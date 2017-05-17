package com.itclimb.twitterclient.hashtags;

import com.itclimb.twitterclient.hashtags.events.HashtagsEvent;

public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);
}
