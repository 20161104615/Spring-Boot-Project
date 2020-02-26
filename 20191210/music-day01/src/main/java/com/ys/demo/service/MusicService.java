package com.ys.demo.service;

import com.ys.demo.bean.MusicBean;
import net.sf.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Map;

public interface MusicService {
    public ArrayList<MusicBean> findAllMusicBean();
    public Map<String, ArrayList<MusicBean>> findMusicByName(String musicName);
    public ArrayList<MusicBean> findMusicBySinger(String musicSinger);
    public boolean uploadMusic(String newMusicName, String newMusicSinger);
    public JSONArray AccurateFindMusic(String musicName) throws JSONException;
    public ArrayList<MusicBean> accuratefindmusicinformation (String musicName);
    public JSONArray findMusicOfPlayList(String userphone) throws JSONException;
    public ArrayList<MusicBean> findMusicOfPlayListinformation(String userphone);
    public MusicBean findONEMusic(String musicName);
    public boolean delFavoritesong(String userPhone,String musicName);
}
