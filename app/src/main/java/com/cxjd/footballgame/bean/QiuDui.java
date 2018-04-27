package com.cxjd.footballgame.bean;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.bean
 * 文件名： QiuDuiFragment
 * 创建者： LC
 * 创建时间： 2018/4/14 17:13
 * 描述：   球队布局类
 */

public class QiuDui {
    //队名
    private String name;
    //球队Logo
    private int imgId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
