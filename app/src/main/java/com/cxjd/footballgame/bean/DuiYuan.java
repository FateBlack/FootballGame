package com.cxjd.footballgame.bean;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.bean
 * 文件名： DuiYuan
 * 创建者： LC
 * 创建时间： 2018/4/15 18:53
 * 描述：   球队队员
 */
public class DuiYuan {
    //主键,目前没啥用
    private int id;
    //照片
    private int imgId;
    //名字
    private String name;
    //位置/号码
    private String weizhi;
    //是否队长
    private boolean isCap = false;

    public DuiYuan( int imgId, String name, String weizhi) {
        this.imgId = imgId;
        this.name = name;
        this.weizhi = weizhi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeizhi() {
        return weizhi;
    }

    public void setWeizhi(String weizhi) {
        this.weizhi = weizhi;
    }

    public boolean isCap() {
        return isCap;
    }

    public void setCap(boolean cap) {
        isCap = cap;
    }
}
