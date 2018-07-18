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
import android.widget.Toast;

import static com.example.deivid.ceol20.R.raw.pista;

public class Frag1 extends Fragment {

    Button play;
    MediaPlayer mp;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View viewmusic= inflater.inflate(R.layout.frag1_layout, container, false);

        play=viewmusic.findViewById(R.id.buttonplay);

        mp=MediaPlayer.create(getActivity(),R.raw.pista);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()){
                    mp.pause();
                    play.setBackgroundResource(R.drawable.play2);
                    Toast.makeText(getActivity(),"Pausa",Toast.LENGTH_SHORT).show();
                }else{
                    mp.start();
                    play.setBackgroundResource(R.drawable.pause2);
                    Toast.makeText(getActivity(),"Play1",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return viewmusic;
    }
}
