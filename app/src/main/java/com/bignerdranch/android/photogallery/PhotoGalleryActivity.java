package com.bignerdranch.android.photogallery;

import android.content.Context;
import android.content.Intent;

public class PhotoGalleryActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, PhotoGalleryActivity.class);
    }
    @Override
    protected PhotoCarouselFragment createPhotoCarouselFragment() {
        return PhotoCarouselFragment.newInstance();
    }

    @Override
    protected PhotoGalleryFragment createPhotoGalleryFragment() {
        return PhotoGalleryFragment.newInstance();
    }

    @Override
    protected PhotoPageFragment createPhotoPageFragment() {
        return PhotoPageFragment.newInstance(getIntent().getData());
    }
}
