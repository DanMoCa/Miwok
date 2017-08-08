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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.number_one,"one","lutti"));
        words.add(new Word(R.drawable.number_two,"two","otiiko"));
        words.add(new Word(R.drawable.number_three,"three","tolookosu"));
        words.add(new Word(R.drawable.number_four,"four","oyyisa"));
        words.add(new Word(R.drawable.number_five,"five","massokka"));
        words.add(new Word(R.drawable.number_six,"six","temmokka"));
        words.add(new Word(R.drawable.number_seven,"seven","kenekaku"));
        words.add(new Word(R.drawable.number_eight,"eight","kawinta"));
        words.add(new Word(R.drawable.number_nine,"nine","wo'e"));
        words.add(new Word(R.drawable.number_ten,"ten","na'aacha"));

        WordAdapter adapter = new WordAdapter(this,words);

        ListView listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);

    }
}
