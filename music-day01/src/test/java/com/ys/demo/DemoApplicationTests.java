package com.ys.demo;

import com.ys.demo.bean.FavoriteSongs;
import com.ys.demo.bean.MusicBean;
import com.ys.demo.bean.UserBean;
import com.ys.demo.mapper.MusicMapper;
import com.ys.demo.mapper.UserMapper;
import com.ys.demo.service.MusicService;
import com.ys.demo.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired//自动注入
            DataSource dataSource;
    @Autowired
    UserService userService;
    @Autowired
    MusicService musicService;
    @Autowired
    MusicMapper musicMapper;
    @Autowired
    UserMapper userMapper;


    @Test
    void contextLoads() throws SQLException {
        System.out.println("默认使用：" + dataSource.getClass() + "数据源");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }


    @Test
    void findmusic() {
        /*MusicBean musicBean = new MusicBean();
        ArrayList<MusicBean> musicBeanList = musicMapper.findMusicBeanList(musicBean);
        musicBeanList.forEach(musicBean1 -> System.out.println(musicBean1.getMusic_name()));*/

        ArrayList<MusicBean> allMusicBean = musicService.findAllMusicBean();
        allMusicBean.toString();

        /* MusicBean musicBean = new MusicBean("生活");
        ArrayList<MusicBean> musicByName = musicService.findMusicByName(musicBean);
        musicByName.toString();*/

        /*MusicBean musicBean = new MusicBean("杰");
        ArrayList<MusicBean> musicBySinger = musicService.findMusicBySinger(musicBean);
        musicBySinger.toString();*/
    }

    @Test
    void insertmusic() {
//        MusicBean musicBean = new MusicBean("麻雀", "李荣浩", "", "D:\\10191\\AllDownload\\Songs");
//        int musicBean1 = musicMapper1.uploadMusic(musicBean);
//        if (musicBean1 != 0) {
//            findmusic();
//        } else {
//            System.out.println("添加歌曲出错！");
//        }

    }

    @Test
    void JSONArray() throws JSONException {
        String a = "123";
        JSONArray musicOfPlayList = musicService.findMusicOfPlayList(a);
        System.out.println(musicOfPlayList);
        ArrayList<MusicBean> musicOfPlayListinformation = musicService.findMusicOfPlayListinformation(a);
        System.out.println(musicOfPlayListinformation);
    }

    @Test
    void sysout() throws JSONException {
        String musicName = "Snowdreams";
        MusicBean musicBean = musicMapper.accurateFindMusic(musicName);
        HashMap<String, String> map = new HashMap<>();
        map.put("title", "'" + musicBean.getMusic_name() + "'");
        map.put("artist", "'" + musicBean.getMusic_singer() + "'");
        map.put("m4a", "'" + musicBean.getMusic_storagepath() + "'");
        map.put("poster", "'" + musicBean.getMusic_storagepath() + "'");

        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(map);
        System.out.println(jsonObject.toString());

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        System.out.println(jsonArray);

    }

    @Test
    void getsong() {
        String music_name = "星";
        Map<String, ArrayList<MusicBean>> musicByName = musicService.findMusicByName(music_name);
        for (Map.Entry<String, ArrayList<MusicBean>> entry : musicByName.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }

    @Test
    public String allSong(HttpServletRequest request) {
        ArrayList<MusicBean> allMusicBean = musicService.findAllMusicBean();
        request.setAttribute("MusicList", allMusicBean);
        return "/index";
    }

    @Test
    void getAllUser() {
        ArrayList<UserBean> allUser = userMapper.findAllUser(false);
        System.out.println(allUser);

        ArrayList<UserBean> userBeans = userService.allUser(false);
        System.out.println(userBeans);
    }

    @Test
    void uploadFavoriteMusic() {
        FavoriteSongs favoriteSongs = new FavoriteSongs("123", 16, "wahhha");
        boolean b = musicMapper.uploadMusicFavorite(favoriteSongs);
        System.out.println(b);
    }

    @Test
    void UPDATEUSER(){
        UserBean userBean = new UserBean(7,"TEST", "12345", "12345",
                "12345@qq.com", "TEST");
        ArrayList<UserBean> arrayList = userMapper.FINDUSER(userBean);
        if(arrayList.isEmpty()){
            System.out.println("可以修改");
        } else {
            System.out.println("不可修改");
        }

        /*boolean b = userService.USERUPDATE(userBean);
        System.out.println(b);*/
    }
    @Test
    void FINDUSER(){
        UserBean userBean = new UserBean();
        userBean.setUser_phone("12345");
        userBean.setUser_Administrator(false);
        UserBean finduser = userService.FINDUSER(userBean);
        System.out.println(finduser);
    }

    @Test
    void UUID(){
        /*for(int i=0;i<10;i++){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }*/
        String testuuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(testuuid);
    }

}
