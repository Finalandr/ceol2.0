package com.example.deivid.ceol20;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Frag1 extends Fragment {
    private int count, i, track, id, data, year;
    private int duracion,album_id,album, artista;
    private int [] idmusic;
    TextView title, artist;
    private String[] auidolista, artistlista, rr;
    ListView lista;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View viewmusic= inflater.inflate(R.layout.frag1_layout, container, false);

        lista= viewmusic.findViewById(R.id.listview);

        audioCursor();

        Adaptador adaptador= new Adaptador();

        lista.setAdapter(adaptador);

        return viewmusic;
        }

        private void audioCursor(){

            String[] informacion={

                    MediaStore.Audio.Media._ID,
                    MediaStore.Audio.Media.DATA,
                    MediaStore.Audio.Media.TRACK,
                    MediaStore.Audio.Media.YEAR,
                    MediaStore.Audio.Media.DURATION,
                    MediaStore.Audio.Media.ALBUM_ID,
                    MediaStore.Audio.Media.ALBUM,
                    MediaStore.Audio.Media.ALBUM_KEY,
                    MediaStore.Audio.Media.TITLE,
                    MediaStore.Audio.Media.TITLE_KEY,
                    MediaStore.Audio.Media.ARTIST_ID,
                    MediaStore.Audio.Media.ARTIST
            };

            final String orderby= MediaStore.Audio.Media._ID;

            Cursor audiocursor= getActivity().getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,informacion,null,null,
                    orderby
            );

            count= audiocursor.getCount();
            auidolista= new String[count];
            artistlista= new String[count];

            id=audiocursor.getColumnIndex(informacion[1]);
            data=audiocursor.getColumnIndex(informacion[2]);
            year=audiocursor.getColumnIndex(informacion[4]);
            duracion=audiocursor.getColumnIndex(informacion[5]);
            album_id=audiocursor.getColumnIndex(informacion[6]);
            album=audiocursor.getColumnIndex(informacion[7]);
            track=audiocursor.getColumnIndex(informacion[9]);
            artista=audiocursor.getColumnIndex(informacion[12]);

            while (audiocursor.moveToNext()){

                auidolista[i]=audiocursor.getString(track);
                artistlista[i]=audiocursor.getString(artista);

                i++;
            }

            audiocursor.close();
    }

    public class Adaptador extends BaseAdapter {

        private LayoutInflater inflater;

        public Adaptador(){

            inflater =(LayoutInflater) getActivity().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );

        }

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int i){
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {

            view=inflater.inflate(R.layout.item_ca,null);
            title= getActivity().findViewById(R.id.titulo);
            artist= getActivity().findViewById(R.id.artista);

            title.setId(i);
            artist.setId(i);

            title.setText(auidolista[i]);
            artist.setText(artistlista[i]);

            return view;
        }
    }


}

