package com.bignerdranch.android.photogallery;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

/**
 * Sample gallery obj
 {
 "id": "37286997076",
 "owner": "63189170@N04",
 "secret": "02762c3e82",
 "server": "4512",
 "farm": 5,
 "title": "Shiba Inu Wedding Cake Topper, dogs cake topper",
 "ispublic": 1,
 "isfriend": 0,
 "isfamily": 0,
 "url_s": "https:\/\/farm5.staticflickr.com\/4512\/37286997076_02762c3e82_m.jpg",
 "height_s": "114",
 "width_s": "240"
 }

 */
public class GalleryItem {
    @SerializedName("id")
    private String mId;

    @SerializedName("title")
    private String mCaption;

    @SerializedName("url_s")
    private String mUrl;

    @SerializedName("owner")
    private String mOwner;

    @Override
    public String toString() {
        return mCaption;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    /**
     Look at the “Web Page URLs” section of Flickr’s documentation at www.flickr.com/services/api/misc.urls.html,
     you will see that you can create the URL for an individual photo’s page like so:
     https://www.flickr.com/photos/user-id/photo-id
     The photo-id seen here is the same as the value of the id attribute from your JSON.
     You are already stashing that in mId in GalleryItem. What about user-id?
     If you poke around the documentation, you will find that the owner attribute in your JSON is a user ID.
     So if you pull out the owner attribute, you should be able to build the URL from your photo JSON:
     https://www.flickr.com/photos/owner/id
     * @return
     */
    public Uri getPhotoPageUri() {
        return Uri.parse("https://www.flickr.com/photos/")
                .buildUpon()
                .appendPath(mOwner)
                .appendPath(mId)
                .build();
    }
}
