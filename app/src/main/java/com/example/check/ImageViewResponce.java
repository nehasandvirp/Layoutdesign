package com.example.check;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageViewResponce{
    //image view
    @SerializedName("albumId")
    @Expose
    private int albumID;
    @SerializedName("id")
    @Expose
    private int ID;
    @SerializedName("title")
    @Expose
    private String Title;
    @SerializedName("url")
    @Expose
    private String URL;
//    @SerializedName("thumbnailUrl")
//    @Expose
//    private  String ThumbnailUrl;

    public ImageViewResponce(int albumID, int ID, String title, String URL, String ThumbnailUrl) {
        this.albumID = albumID;
        this.ID = ID;
        this.Title = title;
        this.URL = URL;
        //  this.ThumbnailUrl;
    }

    public int getAlbumID() {
        return albumID;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getURL() {
        return URL;
    }

//    public String getThumbnailUrl() { return ThumbnailUrl; }
}