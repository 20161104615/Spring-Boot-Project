package com.ys.demo.controller;

import com.ys.demo.bean.MusicBean;
import com.ys.demo.bean.UserBean;
import com.ys.demo.service.MusicService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/*
 * @Author 20161104615
 * @Description //TODO searchResult(ArrayList<MusicBean>|"FALSE"):存放搜索到的音乐信息；
 *                 playList(jsonArray)：存放当前播放列表
 *                 playMusiconeinformation(ArrayList<MusicBean>)：存放单首歌曲信息
 * @Date 17:55 2020/2/22
 * @Param
 * @return
 **/
//@ResponseBody//这个类得所有的方法返回的数据直接写给浏览器（如果是对象转为json数据）
//@Controller 用来响应页面,必须配合模板来使用
//@RestController = @ResponseBody + @Controller
@WebServlet//配置参数初始化
@RestController
@RequestMapping("/song")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping(value = "/showmusic")
    public void findALlMusic(HttpServletRequest request) {
        ArrayList<MusicBean> allMusicBean = musicService.findAllMusicBean();
    }

    @PostMapping(value = "/findmusicbyname")
    public void findMusicByName(@RequestParam("searchmusic") String music_name,
                                HttpServletResponse response,
                                Map<String, Object> map,
                                HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject;
        System.out.println("进入findmusicbyname1");
        UserBean user = (UserBean) request.getSession().getAttribute("LoginUser");
        Map<String, ArrayList<MusicBean>> musicByName = musicService.findMusicByName(music_name);
        for (Map.Entry<String, ArrayList<MusicBean>> entry : musicByName.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            if (entry.getKey().toString() == "TURE") {
                //表示取值成功
                request.getSession().setAttribute("searchResult", entry.getValue().toArray());
                ArrayList<MusicBean> musicOfPlayListinformation = musicService.findMusicOfPlayListinformation(user.getUser_phone());
                
                map.put("stat", "1");
                jsonObject = JSONObject.fromObject(map);
                response.getWriter().print(jsonObject);
            } else {
                //表示未查询到
                request.getSession().setAttribute("searchResult", "FALSE");
                map.put("stat", "0");
                jsonObject = JSONObject.fromObject(map);
                response.getWriter().print(jsonObject);
            }
        }
    }

    @PostMapping(value = "/findmusicbysinger")
    public void findMusicBySinger() {
        ArrayList<MusicBean> musicBySinger = musicService.findMusicBySinger("musicBean");
    }

    /*
     * @Author 20161104615
     * @Description //TODO 点击事件获取歌名，通过精确查找返回ArrayList，将list中的MusicBean的信息重写，对应于Jplayer的播放列表
     *                  存到名为playMusic的session中，返回前端
     * @Date 13:14 2020/2/23
     * @Param [music_name, response, map, request]
     * @return void
     **/
    @PostMapping(value = "/musicplaylist", produces = {"application/json;charset=UTF-8"})
    public void findMusicByNamePlayList(@RequestParam("playmusic") String music_name,
                                        HttpServletResponse response,
                                        Map<String, Object> map,
                                        HttpServletRequest request) throws IOException, JSONException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject;
        JSONArray jsonArray = musicService.AccurateFindMusic(music_name);
        ArrayList<MusicBean> accuratefindmusicinformation = musicService.accuratefindmusicinformation(music_name);
        request.getSession().setAttribute("playMusic", jsonArray);
        request.getSession().setAttribute("playMusiconeinformation", accuratefindmusicinformation);
        map.put("stats", "1");
        jsonObject = JSONObject.fromObject(map);
        response.getWriter().print(jsonObject);
    }

    /*
     * @Author 20161104615
     * @Description //TODO 获取用户的收藏列表，在session中存放名为playMusics（JSONArray），作为播放列表中的数据
     *                 存放名为playMusicsinformation（ArrayList<MusicBean>），作为播放列表歌曲信息
     * @Date 13:13 2020/2/23
     * @Param [userphone, response, map, request]
     * @return void
     **/
    @PostMapping(value = "/musicplaylistoffavorite")
    public void findMusicByUserPhoneGetFavorite(@RequestParam("userphone") String userphone,
                                                HttpServletResponse response,
                                                Map<String, Object> map,
                                                HttpServletRequest request) throws IOException, JSONException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject;
        System.out.println("前端页面取值userphone：" + userphone);
        JSONArray musicOfPlayList = musicService.findMusicOfPlayList(userphone);
        if (musicOfPlayList.isEmpty()) {
            map.put("stats", "0");
            jsonObject = JSONObject.fromObject(map);
            response.getWriter().print(jsonObject);
        } else {
            ArrayList<MusicBean> musicOfPlayListinformation = musicService.findMusicOfPlayListinformation(userphone);
            request.getSession().setAttribute("playMusic", musicOfPlayList);
            request.getSession().setAttribute("playMusiconeinformation", musicOfPlayListinformation);

            map.put("listofstat", "1");
            jsonObject = JSONObject.fromObject(map);
            response.getWriter().print(jsonObject);
            System.out.println("出错，未完成");
        }
    }

}
