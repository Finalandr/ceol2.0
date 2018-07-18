package com.example.deivid.ceol20;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.deivid.ceol20.R.raw.pista;

public class Frag1 extends Fragment {

    private ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();;
    RecyclerView recyclerView;
    SeekBar seekBar;
    SongAdapter songAdapter;
    MediaPlayer mediaPlayer;
    private Handler myHandler = new Handler();;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View viewmusic= inflater.inflate(R.layout.frag1_layout, container, false);

       /* play=viewmusic.findViewById(R.id.buttonplay);

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
                    Toast.makeText(getActivity(),"Play",Toast.LENGTH_SHORT).show();
                }
            }
        });*/

            recyclerView = (RecyclerView) viewmusic.findViewById(R.id.recyclerView);
            seekBar = viewmusic.findViewById(R.id.seekBar);
            songAdapter = new SongAdapter(getActivity(),_songs);
            recyclerView.setAdapter(songAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                    linearLayoutManager.getOrientation());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.addItemDecoration(dividerItemDecoration);
            songAdapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(final Button b, View view, final SongInfo obj, int position) {
                    if(b.getText().equals("Stop")){
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                        mediaPlayer.release();
                        mediaPlayer = null;
                        b.setText("Play");
                    }else {

                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    mediaPlayer = new MediaPlayer();
                                    mediaPlayer.setDataSource(obj.getSongurl());
                                    mediaPlayer.prepareAsync();
                                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                        @Override
                                        public void onPrepared(MediaPlayer mp) {
                                            mp.start();
                                            seekBar.setProgress(0);
                                            seekBar.setMax(mediaPlayer.getDuration());
                                            Log.d("Prog", "run: " + mediaPlayer.getDuration());
                                        }
                                    });
                                    b.setText("Stop");



                                }catch (Exception e){}
                            }

                        };
                        myHandler.postDelayed(runnable,100);

                    }
                }
            });

            Thread t = new runThread();
            t.start();
        return viewmusic;
        }

        public class runThread extends Thread {


            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("Runwa", "run: " + 1);
                    if (mediaPlayer != null) {
                        seekBar.post(new Runnable() {
                            @Override
                            public void run() {
                                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                            }
                        });

                        Log.d("Runwa", "run: " + mediaPlayer.getCurrentPosition());
                    }
                }
            }

        }



        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            switch (requestCode){
                case 123:
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED){

                    }else{
                        Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();

                    }
                    break;
                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            }

        }



    }

