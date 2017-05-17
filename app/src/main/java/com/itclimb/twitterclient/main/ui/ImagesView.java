package com.itclimb.twitterclient.main.ui;
import com.itclimb.twitterclient.entities.Image;

import java.util.List;

public interface ImagesView {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> images);
}
