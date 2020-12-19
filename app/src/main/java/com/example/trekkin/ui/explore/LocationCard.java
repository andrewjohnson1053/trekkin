package com.example.trekkin.ui.explore;

import android.net.Uri;

public class LocationCard {

    public LocationCard() {
        //Empty constructor needed for firebase connectivity.
    }

    public LocationCard(String name, Uri imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }
        mLocationName = name;
        mDisplayImageUrl = imageUrl.toString();
    }

    public String getLocationName() {
        return mLocationName;
    }

    public void setLocationName(String mLocationName) {
        this.mLocationName = mLocationName;
    }

    public String getDisplayImageUrl() {
        return mDisplayImageUrl;
    }

    public void setDisplayImageUrl(String mDisplayImageUrl) {
        this.mDisplayImageUrl = mDisplayImageUrl;
    }

    public String getRegionProvinceName() {
        return mRegionProvinceName;
    }

    public void setRegionProvinceName(String mRegionProvinceName) {
        this.mRegionProvinceName = mRegionProvinceName;
    }

    public int getNumberOfStars() {
        return mNumberOfStars;
    }

    public void setNumberOfStars(int mNumberOfStars) {
        this.mNumberOfStars = mNumberOfStars;
    }

    public boolean isStarred() {
        return mIsStarred;
    }

    public void setIsStarred(boolean mIsStarred) {
        this.mIsStarred = mIsStarred;
    }

    public String getId() {
        return _Id;
    }

    public void setId(String _Id) {
        this._Id = _Id;
    }

    private String mLocationName;
    private String mDisplayImageUrl;
    private String mRegionProvinceName;
    private int mNumberOfStars;
    private boolean mIsStarred;
    private String _Id;
}
