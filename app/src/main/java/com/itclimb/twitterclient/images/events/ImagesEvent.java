package com.itclimb.twitterclient.images.events;


import com.itclimb.twitterclient.entities.Image;

import java.util.List;

public class ImagesEvent {
    private String error;
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
