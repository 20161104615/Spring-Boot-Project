package com.ys.demo.bean;

import java.util.Objects;

public class FavoriteSongs {

    private Integer id;
    private String user_phone;
    private Integer music_id;
    private String music_name;

    public FavoriteSongs() {
    }

    public FavoriteSongs(String user_phone, Integer music_id, String music_name) {
        this.user_phone = user_phone;
        this.music_id = music_id;
        this.music_name = music_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteSongs that = (FavoriteSongs) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user_phone, that.user_phone) &&
                Objects.equals(music_id, that.music_id) &&
                Objects.equals(music_name, that.music_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_phone, music_id, music_name);
    }

    @Override
    public String toString() {
        return "FavoriteSongs{" +
                "id=" + id +
                ", user_phone='" + user_phone + '\'' +
                ", music_id=" + music_id +
                ", music_name='" + music_name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public Integer getMusic_id() {
        return music_id;
    }

    public void setMusic_id(Integer music_id) {
        this.music_id = music_id;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }
}
