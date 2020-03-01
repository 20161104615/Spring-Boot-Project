package com.ys.demo.mapper;

import com.ys.demo.bean.FavoriteSongs;
import com.ys.demo.bean.MusicBean;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from music where music_name like concat('%',#{music_name},'%')")
    public ArrayList<MusicBean> FINDMUSICBYNAME(String music_name);

    @Select("SELECT * FROM music WHERE music_id = #{music_id}")
    public MusicBean FINDMUSICBYID(Integer music_id);

    /**
     * 添加歌曲
     * 1、添加歌曲名、歌手、歌曲路径、歌曲图片路径
     * 2、添加收藏
     */
    @Insert("insert into music (music_name,music_singer,music_img,music_storagepath) " +
            "values " +
            "(#{music_name},#{music_singer},#{music_img},#{music_storagepath})")
    public int uploadMusic(MusicBean musicBean);

    @Insert("insert into favoritesongs (music_id,music_name,user_phone) " +
            "values" +
            "(#{music_id},#{music_name},#{user_phone})")
    public boolean uploadMusicFavorite(FavoriteSongs songs);


    /**
     * 更新歌曲
     */
    @Update("update music set music_name=#{music_name},music_singer=#{music_singer}," +
            "music_storagepath=#{music_storagepath},music_img=#{music_img} " +
            "where music_id=#{music_id} ")
    public int UPDATEMUSIC(MusicBean musicBean);

    /**
     * 删除歌曲
     * 1、删除用户收藏的歌曲
     * 2、删除歌曲
     */
    @Delete("DELETE FROM favoritesongs WHERE music_name = #{musicName} AND user_phone = #{userPhone}")
    public boolean delfavoritesong(String userPhone, String musicName);

    @Delete("DELETE FROM music WHERE music_id=#{music_id}")
    public boolean DELETEMUSIC(Integer music_id);
    @Delete("DELETE FROM favoritesongs WHERE music_id = #{music_id}")
    public boolean DELETEMUSICOFUSERF(Integer music_id);

}
