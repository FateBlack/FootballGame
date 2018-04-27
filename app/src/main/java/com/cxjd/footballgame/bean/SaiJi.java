package com.cxjd.footballgame.bean;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.bean
 * 文件名： SaiJi
 * 创建者： LC
 * 创建时间： 2018/4/16 18:51
 * 描述：   赛季
 */
public class SaiJi {
    //箭头
    private int jianTouId;
    //赛季名字
    private String name;
    //赛季状态logo
    private int stateId;

    public SaiJi(String name, int stateId) {
        this.name = name;
        this.stateId = stateId;
    }

    public int getJianTouId() {
        return jianTouId;
    }

    public void setJianTouId(int jianTouId) {
        this.jianTouId = jianTouId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
}
