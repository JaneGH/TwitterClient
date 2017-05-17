package com.itclimb.twitterclient.hashtags.ui;

import com.itclimb.twitterclient.entities.Hashtag;

import java.util.List;

public interface HashtagsView {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Hashtag> items);
}
