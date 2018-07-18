package com.example.deivid.ceol20;

public class SongInfo {

    private String Songname;
    private String Songartist;
    private String Songurl;

    public SongInfo(String songname, String songartist, String songurl) {
        Songname = songname;
        Songartist = songartist;
        Songurl = songurl;
    }

    public String getSongname() {
        return Songname; }
    public String getSongartist() {
        return Songartist; }
    public String getSongurl() {
        return Songurl; }
    public void setSongname(String songname) {
        Songname = songname; }
    public void setSongartist(String songartis) {
        Songartist = songartis; }
    public void setSongurl(String songurl) {
        Songurl = songurl; }
}
