package com.bignerdranch.android.photogallery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class PhotoPageActivity extends SingleFragmentActivity {

    public static Intent newInent(Context context, Uri photoPageUri) {
        Intent i = new Intent(context, PhotoPageActivity.class);
        i.setData(photoPageUri);
        return i;
    }

    @Override
    protected PhotoCarouselFragment createPhotoCarouselFragment() {
        return PhotoCarouselFragment.newInstance();
    }

    @Override
    protected PhotoGalleryFragment createPhotoGalleryFragment() {
        return PhotoGalleryFragment.newInstance();
    }
}
