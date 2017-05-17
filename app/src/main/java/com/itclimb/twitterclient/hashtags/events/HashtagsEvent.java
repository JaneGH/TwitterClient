package com.itclimb.twitterclient.hashtags.events;

import com.itclimb.twitterclient.entities.Hashtag;

import java.util.List;

public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
