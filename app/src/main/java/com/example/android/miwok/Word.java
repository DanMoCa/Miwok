package com.example.android.miwok;

/**
 * Created by Desarrollo on 8/7/2017.
 */

public class Word {
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mSoundResourceId = NO_SOUND_PROVIDED;
    private String mEnglish;
    private String mMiwok;

    private static final int NO_IMAGE_PROVIDED = -1;
    private static final int NO_SOUND_PROVIDED = -1;

    public Word(String english, String miwok){
        mEnglish = english;
        mMiwok = miwok;
    }

    public Word(String english, String miwok, int soundResource){
        mEnglish = english;
        mMiwok = miwok;
        mSoundResourceId = soundResource;
    }

    public Word(int imageResourceId, String english, String miwok){
        mImageResourceId = imageResourceId;
        mEnglish = english;
        mMiwok = miwok;
    }
    public Word(int imageResourceId, String english, String miwok, int soundResource){
        mImageResourceId = imageResourceId;
        mEnglish = english;
        mMiwok = miwok;
        mSoundResourceId = soundResource;
    }


    public String getEnglish(){
        return mEnglish;
    }

    public String getMiwok(){
        return mMiwok;
    }

    public void setMiwok(String miwok){
        mMiwok = miwok;
    }

    public void setEnglish(String english){
        mEnglish = english;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public int getmSoundResourceId(){
        return mSoundResourceId;
    }

    public boolean hasSound(){
        return mSoundResourceId != NO_SOUND_PROVIDED;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
