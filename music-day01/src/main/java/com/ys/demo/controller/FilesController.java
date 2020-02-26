package com.ys.demo.controller;

import com.ys.demo.bean.MusicBean;
import com.ys.demo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * @Author 20161104615
 * @Description //TODO 多文件上传至不同目录；searchResult：存放上传的音乐信息，在list页面中显示
 * @Date 10:45 2020/2/19
 * @Param
 * @return
 **/
@WebServlet
@Controller
@RequestMapping("/files")
public class FilesController {

    @Autowired
    MusicService musicService;

    @GetMapping(value = "/fileUpload")
    public String file() {
        return "fileUpload";
    }

    @PostMapping(value = "/fileUpload")
    @ResponseBody
    public void fileUpload(@RequestParam(value = "newMusicUrl") MultipartFile newMusicUrl,
                           @RequestParam(value = "newMusicImgUrl") MultipartFile newMusicImgUrl,
                           @RequestParam(value = "newMusicName") String newMusicName,
                           @RequestParam(value = "newMusicSinger") String newMusicSinger,
                           HttpServletResponse response,
                           HttpServletRequest request) throws IOException {
        System.out.println("进入filesupload");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (newMusicUrl.isEmpty() && newMusicImgUrl.isEmpty()) {
            response.sendRedirect("/music/fileupload.html");
        }
        String fileName = "";//文件名称
        String suffixName = "";//文件后缀名称
        String newName = "";
        String newNameImg = "";
        List<MultipartFile> files = new ArrayList<MultipartFile>();
        files.add(newMusicUrl);
        files.add(newMusicImgUrl);
        MultipartFile file = null;
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            fileName = file.getOriginalFilename();//获取文件名称
            suffixName = fileName.substring(fileName.lastIndexOf("."));//获取文件的后缀名
            /*newName = fileName.substring(0, fileName.indexOf("."));*/
            System.out.println("文件名称：" + fileName + ";  文件后缀名称：" + suffixName);
            if (".m4a".equals(suffixName) || ".mp3".equals(suffixName)) {
                System.out.println("进入音乐处理");
                String filePath_newMusicUrl = "D:/JavaProgram/Apache-tomcat/apache-tomcat-8.5.43/webapps/ROOT/media/";//歌曲存放的路径
                newName = newMusicName + ".m4a";//统一处理为.m4a
                /* File file_music = new File(filePath_newMusicUrl + fileName);*/
                File file_music = new File(filePath_newMusicUrl + newName);
                try {
                    file.transferTo(file_music);//把内存中的数据写入到磁盘中
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (".jpg".equals(suffixName) || ".png".equals(suffixName)) {
                System.out.println("进入图片处理");
                String filePath_newMusicImgUrl = "D:/JavaProgram/Apache-tomcat/apache-tomcat-8.5.43/webapps/ROOT/media/img/";//图片存放的路径
                newNameImg = newMusicName + "-" + newMusicSinger + ".jpg";//统一处理为.jpg
                /*File file_music_img = new File(filePath_newMusicImgUrl + fileName);*/
                File file_music_img = new File(filePath_newMusicImgUrl + newNameImg);
                try {
                    file.transferTo(file_music_img);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("判断出错");
                break;
            }
        }
        boolean checkUpload = musicService.uploadMusic(newMusicName, newMusicSinger);
        if (checkUpload == true) {
            System.out.println("上传数据库成功");
            Map<String, ArrayList<MusicBean>> musicByName = musicService.findMusicByName(newMusicName);
            for (Map.Entry<String, ArrayList<MusicBean>> entry : musicByName.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                if (entry.getKey().toString() == "TURE") {
                    //表示取值成功
                    request.getSession().setAttribute("searchResult", entry.getValue().toArray());
                    response.sendRedirect("/music/list.html");
                } else {
                    //表示未查询到
                    request.getSession().setAttribute("searchResult", "FALSE");
                    response.sendRedirect("/music/fileupload.html");
                }
            }
        } else {
            System.out.println("上传数据库失败");
            response.sendRedirect("/music/fileupload.html");
        }
    }
}
