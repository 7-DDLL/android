package com.example.player;

import android.widget.ImageView;

import java.util.List;

public class Song {
    public String singer;

    public String song;

    public String path;

    public int duration;//歌曲长度

    public long size;

    private int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Song(String singer, String song, String path, int duration, long size) {
        this.singer = singer;
        this.song = song;
        this.path = path;
        this.duration = duration;
        this.size = size;
    }

    public Song(int imageId,String singer, String song) {
        this.imageId = imageId;
        this.singer = singer;
        this.song = song;

    }

    public Song() {

    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }



}


