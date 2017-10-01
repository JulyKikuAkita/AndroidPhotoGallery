package com.bignerdranch.android.photogallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract PhotoGalleryFragment createPhotoGalleryFragment();
    protected abstract PhotoCarouselFragment createPhotoCarouselFragment();
    protected abstract PhotoPageFragment createPhotoPageFragment();

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
//
//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment_thumbnail = fm.findFragmentById(R.id.fragment_container);
////        Fragment fragment_carousel = fm.findFragmentById(R.id.fragment_container_carousel);
////
////        if (fragment_carousel == null) {
////            fragment_carousel = createFragment();
////        }
//
//        if (fragment_thumbnail == null) {
//            fragment_thumbnail = createFragment();
//        }
//
//
//
//        fm.beginTransaction()
//                .add(R.id.fragment_container, fragment_thumbnail)
//                //.add(R.id.fragment_container_carousel, fragment_carousel)
//                .commit();
//    }

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

        fm.beginTransaction()
                .add(R.id.fragment_container, fragment_thumbnail)
                .add(R.id.fragment_container_carousel, fragment_carousel)
                .commit();
    }
}
