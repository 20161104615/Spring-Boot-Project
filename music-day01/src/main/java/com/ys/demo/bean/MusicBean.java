package com.ys.demo.bean;

import java.util.Objects;

public class MusicBean {
    private Integer music_id;
    private String music_name;//歌名
    private String music_singer;//歌手
    private String music_lyrics;//歌词
    private String music_storagepath;//歌曲路径
    private String music_img;//歌曲图片路径

    public MusicBean() {
        super();
    }

    public MusicBean(String music_name, String music_singer, String music_storagepath, String music_img) {
        this.music_name = music_name;
        this.music_singer = music_singer;
        this.music_storagepath = music_storagepath;
        this.music_img = music_img;
    }

    @Override
    public String toString() {
        return "MusicBean{" +
                "music_id=" + music_id +
                ", music_name='" + music_name + '\'' +
                ", music_singer='" + music_singer + '\'' +
                ", music_lyrics='" + music_lyrics + '\'' +
                ", music_storagepath='" + music_storagepath + '\'' +
                ", music_img='" + music_img + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicBean musicBean = (MusicBean) o;
        return Objects.equals(music_id, musicBean.music_id) &&
                Objects.equals(music_name, musicBean.music_name) &&
                Objects.equals(music_singer, musicBean.music_singer) &&
                Objects.equals(music_lyrics, musicBean.music_lyrics) &&
                Objects.equals(music_storagepath, musicBean.music_storagepath) &&
                Objects.equals(music_img, musicBean.music_img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(music_name, music_singer, music_lyrics, music_storagepath, music_img);
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getMusic_singer() {
        return music_singer;
    }

    public void setMusic_singer(String music_singer) {
        this.music_singer = music_singer;
    }

    public String getMusic_lyrics() {
        return music_lyrics;
    }

    public void setMusic_lyrics(String music_lyrics) {
        this.music_lyrics = music_lyrics;
    }

    public String getMusic_storagepath() {
        return music_storagepath;
    }

    public void setMusic_storagepath(String music_storagepath) {
        this.music_storagepath = music_storagepath;
    }

    public String getMusic_img() {
        return music_img;
    }

    public void setMusic_img(String music_img) {
        this.music_img = music_img;
    }

    public Integer getMusic_id() {
        return music_id;
    }

    public void setMusic_id(Integer music_id) {
        this.music_id = music_id;
    }
}
