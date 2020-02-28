package com.ys.demo.service.lmpl;

import com.ys.demo.bean.FavoriteSongs;
import com.ys.demo.bean.MusicBean;
import com.ys.demo.mapper.MusicMapper;
import com.ys.demo.service.MusicService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class MusicServicelmpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

    @Override
    public ArrayList<MusicBean> findAllMusicBean() {
        ArrayList<MusicBean> musicBeans = musicMapper.findMusicBeanList();
        return musicBeans;
    }

    @Override
    public Map<String, ArrayList<MusicBean>> findMusicByName(String musicName) {
        MusicBean musicBean = new MusicBean();
        musicBean.setMusic_name(musicName);
        ArrayList<MusicBean> musicByName = musicMapper.findMusicByName(musicBean);
        Map<String, ArrayList<MusicBean>> map = new HashMap<String, ArrayList<MusicBean>>();
        if (musicByName.isEmpty()) {
            //ArrayList为空
            map.put("FALSE", musicByName);
        } else {
            map.put("TURE", musicByName);
        }
        return map;
    }

    @Override
    public ArrayList<MusicBean> findMusicBySinger(String musicSinger) {
        MusicBean musicBean = new MusicBean();
        musicBean.setMusic_singer(musicSinger);
        ArrayList<MusicBean> musicBySinger = musicMapper.findMusicBySinger(musicBean);
        Map<String, ArrayList<MusicBean>> map = new HashMap<String, ArrayList<MusicBean>>();
        return musicBySinger;
    }

    @Override
    public boolean uploadMusic(String newMusicName, String newMusicSinger) {
        String newSongUrl = "http://localhost:8080/media/" + newMusicName + ".m4a";
        String newSongImgUrl = "http://localhost:8080/media/img/" + newMusicName + "-" + newMusicSinger + ".jpg";
        MusicBean musicBean = new MusicBean(newMusicName, newMusicSinger, newSongUrl, newSongImgUrl);
        int i = musicMapper.uploadMusic(musicBean);
        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    //单首，用于点击页面歌曲
    @Override
    public JSONArray AccurateFindMusic(String musicName) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        MusicBean musicBean = musicMapper.accurateFindMusic(musicName);
        HashMap<String, String> map = new HashMap<>();
        map.put("title", musicBean.getMusic_name());
        map.put("artist", musicBean.getMusic_singer());
        map.put("m4a", musicBean.getMusic_storagepath());
        map.put("poster", musicBean.getMusic_storagepath());
        jsonObject.putAll(map);
        System.out.println(jsonObject.toString());
        jsonArray.add(jsonObject);
        System.out.println(jsonArray);
        return jsonArray;
    }

    @Override
    public ArrayList<MusicBean> accuratefindmusicinformation(String musicName) {
        MusicBean musicBean = musicMapper.accurateFindMusic(musicName);
        ArrayList<MusicBean> musicBeans = new ArrayList<>();
        musicBeans.add(musicBean);
        return musicBeans;
    }

    //多首，用于播放收藏列表
    @Override
    public JSONArray findMusicOfPlayList(String userphone) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        HashMap<String, String> map = new HashMap<>();
        ArrayList<MusicBean> musicByUserPhoneOfFavorite = musicMapper.findMusicByUserPhoneOfFavorite(userphone);
        for (MusicBean musicBean:musicByUserPhoneOfFavorite) {
            map.put("title", musicBean.getMusic_name());
            map.put("artist", musicBean.getMusic_singer());
            map.put("m4a", musicBean.getMusic_storagepath());
            map.put("poster", musicBean.getMusic_storagepath());
            jsonObject.putAll(map);
            System.out.println(jsonObject.toString());
            jsonArray.add(jsonObject);
            System.out.println(jsonArray);
        }
        System.out.println("数据格式修改完成，退出收藏列表查询");
        return jsonArray;
    }

    @Override
    public ArrayList<MusicBean> findMusicOfPlayListinformation(String userphone) {
        ArrayList<MusicBean> musicByUserPhoneOfFavorite = musicMapper.findMusicByUserPhoneOfFavorite(userphone);
        System.out.println("收藏歌曲信息获取，退出");
        return musicByUserPhoneOfFavorite;
    }

    @Override
    public MusicBean findONEMusic(String musicName) {
        MusicBean musicBean = musicMapper.accurateFindMusic(musicName);
        return musicBean;
    }

    @Override
    public boolean delFavoritesong(String userPhone, String musicName) {
        boolean result = musicMapper.delfavoritesong(userPhone, musicName);
        if(result){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean uploadFavoritesong(FavoriteSongs songs) {
        boolean b = musicMapper.uploadMusicFavorite(songs);
        return b;
    }


}