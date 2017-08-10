package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        //Resume playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        //stop playback and release memory
                        releaseMediaPlayer();
                    }
                }
            };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

        WordAdapter adapter = new WordAdapter(getActivity(),words,R.color.category_family);

        ListView listview = (ListView) rootView.findViewById(R.id.list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word word = words.get(i);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){


                    if(word.hasSound()) {
                        mMediaPlayer = MediaPlayer.create(getActivity(), word.getmSoundResourceId());

                        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                releaseMediaPlayer();
                            }
                        });

                        mMediaPlayer.start();

                    }
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();

            mMediaPlayer = null;
        }
        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
    }

}
