package com.example.deivid.ceol20;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends BaseAdapter {
    public Activity activity;
    public ArrayList<SongInfo> items;

    public SongAdapter(Context activity, ArrayList<SongInfo> items) {
        this.activity = (Activity) activity;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
        //Proporciona el numero de elementos del ArrayList
    }

    public void clear() {
        items.clear();
        //Limpia el Array
    }

    public void addAll(ArrayList<SongInfo> titulo) {
        for (int i = 0; i < titulo.size(); i++) {
            items.add(titulo.get(i));

            //Para la lista y el ancho del titulo
        }
    }

    @Override
    public Object getItem(int position1) {
        return items.get(position1);
        //para obtener la lista
    }

    @Override
    public long getItemId(int position) {
        return position;
        //para obtener la lista
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //El que inflará la lista (personalizará)

        View v = convertView;
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_ca, null);
        }

        SongInfo sng = items.get(position);

        TextView titl = v.findViewById(R.id.titulo);
        titl.setText(sng.getTitulo());

        TextView titulo2 = v.findViewById(R.id.titul2);
        titulo2.setText(sng.getTitulo2());


        ImageView imagen = v.findViewById(R.id.img);
        imagen.setImageDrawable((Drawable) sng.getDrawableRes());

        return v;
    }
}




