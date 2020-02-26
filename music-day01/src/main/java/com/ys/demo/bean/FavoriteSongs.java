package com.ys.demo.bean;

import javax.persistence.*;

@Entity
@Table(name = "favoritesongs")
public class FavoriteSongs {

    //自增ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "music_id")
    private Integer music_id;

    @Column(name = "music_name",length = 500)
    private String music_name;

    public FavoriteSongs() {
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
