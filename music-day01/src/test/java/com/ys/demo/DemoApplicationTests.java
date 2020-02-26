package com.ys.demo;

import com.ys.demo.bean.MusicBean;
import com.ys.demo.mapper.MusicMapper;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    /*void find(){
        callback({
                "code":0,
                "data":{
                    "keyword":"2",
                    "priority":0,
                    "qc":[],
                    "semantic":{
                        "curnum":0,
                        "curpage":1,
                        "list":[],
                        "totalnum":0
                    },
                    "song":{
                        "curnum":1,
                        "curpage":1,
                        "list":[{
                            "albumid":2104407,
                            "albummid":"0008u6bN048czH",
                            "albumname":"2U",
                            "albumname_hilight":"<em>2</em>U",
                            "alertid":24,
                            "belongCD":0,
                            "cdIdx":1,
                            "chinesesinger":0,
                            "docid":"3341932035108162397",
                            "grp":[],
                            "interval":194,
                            "isonly":1,
                            "lyric":"",
                            "lyric_hilight":"",
                            "media_mid":"0021fS0W0g49CW",
                            "msgid":15,
                            "newStatus":2,
                            "nt":3708412778,
                            "pay":{
                                "payalbum":0,
                                "payalbumprice":0,
                                "paydownload":1,
                                "payinfo":1,
                                "payplay":1,
                                "paytrackmouth":1,
                                "paytrackprice":200
                            },
                            "preview":{
                                    "trybegin":0,
                                    "tryend":0,
                                    "trysize":960887
                            },
                            "pubtime":1496937600,
                            "pure":5,
                            "singer":[
                                    {
                                        "id":965,
                                        "mid":"000gELB619OfVG",
                                        "name":"David Guetta",
                                        "name_hilight":"David Guetta"
                                    },
                                    {
                                        "id":16257,
                                        "mid":"002DYpxl3hW3EP",
                                        "name":"Justin Bieber",
                                        "name_hilight":"Justin Bieber"
                                    }
                            ],
                            "size128":3119019,
                            "size320":7797236,
                            "sizeape":0,
                            "sizeflac":23259094,
                            "sizeogg":4373071,
                            "songid":202712996,
                            "songmid":"000Hyuia2AvvP1",
                            "songname":"2U",
                            "songname_hilight":"<em>2</em>U",
                            "strMediaMid":"0021fS0W0g49CW",
                            "stream":1,
                            "switch":628481,
                            "t":1,
                            "tag":10,
                            "type":0,
                            "ver":0,
                            "vid":"m0024ohyrew"
                        }],
                        "totalnum":600
                    },
                    "tab":0,
                    "taglist":[],
                    "totaltime":0,
                    "zhida":{
                        "chinesesinger":0,
                        "type":0
                    }
                },
                "message":"",
                "notice":"",
                "subcode":0,
                "time":1582040139,
                "tips":""
        })*/
}
