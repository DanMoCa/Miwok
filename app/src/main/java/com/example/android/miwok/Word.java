package com.example.android.miwok;

/**
 * Created by Desarrollo on 8/7/2017.
 */

public class Word {
    private String mEnglish;
    private String mMiwok;

    public Word(String english, String miwok){
        mEnglish = english;
        mMiwok = miwok;
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

}
