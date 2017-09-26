package com.bignerdranch.android.photogallery;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 Sample response obj:

 "photos": {
     "page": 1,
     "pages": 1222,
     "perpage": 100,
     "total": "122162",
     "photo": [
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
         },
         {
         "id": "37132309431",
         "owner": "47406952@N06",
         "secret": "e65f6bf99d",
         "server": "4393",
         "farm": 5,
         "title": "",
         "ispublic": 1,
         "isfriend": 0,
         "isfamily": 0,
         "url_s": "https:\/\/farm5.staticflickr.com\/4393\/37132309431_e65f6bf99d_m.jpg",
         "height_s": "160",
         "width_s": "240"
         }
    ]
 },
 "stat": "ok"
 }
 */
public class Response {
    @SerializedName("photos")
    private Photos mPhotos;

    private static class Photos {
        @SerializedName("pages")
        private int mPages;

        @SerializedName("perpage")
        private int mPerpage;

        @SerializedName("total")
        private int mTotal;

        @SerializedName("photo")
        public GalleryItem[] mGalleryItem;
    }

    public List<GalleryItem> getGalleryItemList() {
        List<GalleryItem> list = new ArrayList<>();
        for (GalleryItem items : mPhotos.mGalleryItem) {
            list.add(items);
        }
        return list;
    }
}
