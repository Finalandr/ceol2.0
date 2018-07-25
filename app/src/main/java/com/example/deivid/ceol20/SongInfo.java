package com.example.deivid.ceol20;

import android.support.annotation.DrawableRes;

public class SongInfo {

    private String titulo2;
    private String titulo;
    private String descripcion;
    private DrawableRes drawableRes;

    public SongInfo(String titulo2, String titulo, String descripcion, DrawableRes drawableRes) {
        super();
        this.titulo2 = titulo2;
        this.descripcion = descripcion;
        this.drawableRes = drawableRes;
        this.titulo = titulo;
    }

    public String getTitulo2() {
        return titulo2; }

    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;

    }
    public String getTitulo() {
        return titulo;}

    public void setTitulo(String titulo) {
    this.titulo = titulo;
    }
    public String getDescripion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DrawableRes getDrawableRes(){
        return drawableRes;}

    public void setDrawableRes(DrawableRes drawableRes){
        this.drawableRes = drawableRes;}
    }






