package com.cxjd.footballgame.bean;

import java.io.Serializable;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.bean
 * 文件名： SaiShi
 * 创建者： LC
 * 创建时间： 2018/4/16 17:50
 * 描述：   具体赛事
 */
public class SaiShi implements Serializable{
    //赛季logoId
    private int saiJiId;
    //赛季name
    private String saiJiName;
    //组/决赛
    private String kind;
    //杯赛/联赛轮次
    private String lunCi;
    //场
    private String number;
    //1队logo
    private int team1Id;
    //1队名字
    private String team1Name;
    //比赛时间
    private String date;
    //比赛地点
    private String location;
    //1队得分
    private int score1;
    //2队得分
    private int score2;
    //2队Logo
    private int team2Id;
    //2队名字
    private String team2Name;
    //主裁名
    private String zhuCaiName;
    //1边裁名
    private String bianCaiName1;
    //2边裁名
    private String bianCaiName2;
    //是否结束
    private boolean isEnd;

    public SaiShi(){
    }

    public SaiShi(int saiJiId, String saiJiName,String kind,String lunCi, String number, int team1Id, String team1Name, String date, String location, int score1, int score2, int team2Id, String team2Name, String zhuCaiName, String bianCaiName1, String bianCaiName2,boolean isEnd) {
        this.kind = kind;
        this.saiJiId = saiJiId;
        this.saiJiName = saiJiName;
        this.lunCi = lunCi;
        this.number = number;
        this.team1Id = team1Id;
        this.team1Name = team1Name;
        this.date = date;
        this.location = location;
        this.score1 = score1;
        this.score2 = score2;
        this.team2Id = team2Id;
        this.team2Name = team2Name;
        this.zhuCaiName = zhuCaiName;
        this.bianCaiName1 = bianCaiName1;
        this.bianCaiName2 = bianCaiName2;
        this.isEnd = isEnd;
    }

    public int getSaiJiId() {
        return saiJiId;
    }

    public void setSaiJiId(int saiJiId) {
        this.saiJiId = saiJiId;
    }

    public String getSaiJiName() {
        return saiJiName;
    }

    public void setSaiJiName(String saiJiName) {
        this.saiJiName = saiJiName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLunCi() {
        return lunCi;
    }

    public void setBeiSaiLunCi(String lunCi) {
        this.lunCi = lunCi;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public int getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(int team1Id) {
        this.team1Id = team1Id;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(int team2Id) {
        this.team2Id = team2Id;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public String getZhuCaiName() {
        return zhuCaiName;
    }

    public void setZhuCaiName(String zhuCaiName) {
        this.zhuCaiName = zhuCaiName;
    }

    public String getBianCaiName1() {
        return bianCaiName1;
    }

    public void setBianCaiName1(String bianCaiName1) {
        this.bianCaiName1 = bianCaiName1;
    }

    public String getBianCaiName2() {
        return bianCaiName2;
    }

    public void setBianCaiName2(String bianCaiName2) {
        this.bianCaiName2 = bianCaiName2;
    }

    public boolean getIsEnd(){return isEnd;}

    public void setIsEnd(boolean b){isEnd = b;}
}
