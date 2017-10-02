package com.bignerdranch.android.photogallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract PhotoGalleryFragment createPhotoGalleryFragment();
    protected abstract PhotoCarouselFragment createPhotoCarouselFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_carousel);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment_thumbnail = fm.findFragmentById(R.id.fragment_container);
        Fragment fragment_carousel = fm.findFragmentById(R.id.fragment_container_carousel);

        if (fragment_carousel == null) {
            fragment_carousel = createPhotoCarouselFragment();
        }

        if (fragment_thumbnail == null) {
            fragment_thumbnail = createPhotoGalleryFragment();
        }

        /**
         * if use add, got java.lang.IllegalStateException: Fragment already added: PhotoGalleryFragment error
         * ex: rotate screen, activity got recreated but fragment for detached, and the fm attempts to add the same
         * fragment. Use replace instead.
         * https://stackoverflow.com/questions/18634207/difference-between-add-replace-and-addtobackstack
         *
         */
        fm.beginTransaction()
                .replace(R.id.fragment_container, fragment_thumbnail, fragment_thumbnail.getTag())
                .replace(R.id.fragment_container_carousel, fragment_carousel, fragment_carousel.getTag())
                .commit();
    }
}
