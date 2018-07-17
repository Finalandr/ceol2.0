package com.example.deivid.ceol20;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Frag1 extends Fragment {

    Button play;
    MediaPlayer mp;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewmusic= inflater.inflate(R.layout.frag1_layout, container, false);

        play=viewmusic.findViewById(R.id.buttonplay);




        return viewmusic;
    }
}
