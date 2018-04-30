package com.cxjd.footballgame.bean;

import android.graphics.Bitmap;

import org.litepal.crud.DataSupport;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.bean
 * 文件名： QiuDuiFragment
 * 创建者： LC
 * 创建时间： 2018/4/14 17:13
 * 描述：   球队布局类
 */

public class QiuDui extends DataSupport{

    // 球队id
    private int id;
    //队名
    private String name;

    // 图片是否在本地有存储 默认为0
    private int state = 0;

    // 球队log图片地址
    private String logUrl;

    // 球队log 本地存储路径
    private String localPath;

    //球队Logo
    private Bitmap log;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public Bitmap getLog() {
        return log;
    }

    public void setLog(Bitmap log) {
        this.log = log;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
