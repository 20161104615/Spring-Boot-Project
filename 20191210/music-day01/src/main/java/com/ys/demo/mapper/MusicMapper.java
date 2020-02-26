package com.ys.demo.mapper;

import com.ys.demo.bean.MusicBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface MusicMapper {

    /**
     * 查找歌曲
     * 1、查找全部歌曲
     * 2、根据名称查找（模糊查找）
     * 3、根据歌手查找（模糊查找）
     * 4、根据名称查找（取第一条）
     * 5、根据用户手机号查找用户喜欢列表中的内容
     */
    @Select("select * from music")
    public ArrayList<MusicBean> findMusicBeanList();

    @Select("select * from music where music_name like concat('%',#{music_name},'%')")
    public ArrayList<MusicBean> findMusicByName(MusicBean musicBean);

    @Select("select * from music where music_singer like concat('%',#{music_singer},'%')")
    public ArrayList<MusicBean> findMusicBySinger(MusicBean musicBean);

    @Select("select * from music where music_name = #{music_name} limit 1")
    public MusicBean accurateFindMusic(String music_name);

    @Select("select * from music where music_id in (select music_id from favoritesongs where user_phone = #{userphone})")
    public ArrayList<MusicBean> findMusicByUserPhoneOfFavorite(String userphone);

    /**
     * 添加歌曲
     * 1、添加歌曲名、歌手、歌曲路径、歌曲图片路径
     */
    @Insert("insert into music (music_name,music_singer,music_img,music_storagepath) " +
            "values " +
            "(#{music_name},#{music_singer},#{music_img},#{music_storagepath})")
    public int uploadMusic(MusicBean musicBean);

    /**
     * 删除歌曲
     * 1、删除用户收藏的歌曲
     */
    @Delete("DELETE FROM favoritesongs WHERE music_name = #{musicName} AND user_phone = #{userPhone}")
    public boolean delfavoritesong(String userPhone, String musicName);

}
