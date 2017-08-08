/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.family_father,"father","әpә",R.raw.family_father));
        words.add(new Word(R.drawable.family_mother,"mother","әṭa",R.raw.family_mother));
        words.add(new Word(R.drawable.family_son,"son","angsi",R.raw.family_son));
        words.add(new Word(R.drawable.family_daughter,"daughter","tune",R.raw.family_daughter));
        words.add(new Word(R.drawable.family_older_brother,"older brother","taachi",R.raw.family_older_brother));
        words.add(new Word(R.drawable.family_younger_brother,"younger brother","chalitti",R.raw.family_younger_brother));
        words.add(new Word(R.drawable.family_older_sister,"older sister","teṭe",R.raw.family_older_sister));
        words.add(new Word(R.drawable.family_younger_sister,"younger sister","kolliti",R.raw.family_younger_sister));
        words.add(new Word(R.drawable.family_grandmother,"grandmother","ama",R.raw.family_grandmother));
        words.add(new Word(R.drawable.family_grandfather,"grandfather","paapa",R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_family);

        ListView listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                if(word.hasSound()){
                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this,word.getmSoundResourceId());
                    if(!mMediaPlayer.isPlaying()){
                        mMediaPlayer.start();
                    }
                }
            }
        });
    }
}
