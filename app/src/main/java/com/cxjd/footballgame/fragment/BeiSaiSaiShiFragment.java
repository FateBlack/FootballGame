package com.cxjd.footballgame.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.activity.AddSaiShi;
import com.cxjd.footballgame.adapter.ExpandableListAdapter;
import com.cxjd.footballgame.bean.SaiJi;
import com.cxjd.footballgame.bean.SaiShi;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.fragment
 * 文件名： BeiSaiSaiShiFragment
 * 创建者： LC
 * 创建时间： 2018/4/19 0:02
 * 描述：   赛事Tablayout杯赛选项
 */
public class BeiSaiSaiShiFragment extends Fragment {
    //保证视图唯一
    private View view;
    //杯赛点击扩展ListView
    private ExpandableListView expandableListView1;
    //赛季名字
    private String saiJiName = "杯赛";
    //杯赛群组名
    private List<SaiJi> groups1 = new ArrayList<>();
    //杯赛群组下的子项名
    private List<ArrayList<SaiShi>> beiSaiChilds = new ArrayList<>();
    //赛季logoId
    private int saiJiId = R.drawable.football_beisai;
    //分赛季name
    private String[] saiShiNames = {"A组", "A组", "B组", "B组", "C组", "C组", "D组", "D组", "1/4决赛", "1/4决赛", "半决赛", "半决赛", "决赛", "决赛"};
    //赛季状态logoId,0调用，未开始，1调用，结束
    private int[] saiJiStatueIds = {R.drawable.un_start, R.drawable.end};
    //赛事状态
    private boolean[] isEnds = {true, false, true, false, true, false, true};
    //赛事组次
    private String[] zus = {"A组", "B组", "C组", "D组", "1/4决赛", "半决赛", "决赛"};
    //各个小组球队数量
    private int countA = 4;
    private int countB = 4;
    private int countC = 3;
    private int countD = 3;
    //杯赛半决赛轮次
    private String[] banLunCis = {"首轮", "次轮"};
    //小组轮次，1/4决赛轮次
    private String[] beiSaiLunCis = {"第1轮", "第2轮", "第3轮", "第4轮", "第5轮", "第6轮"};
    //队伍logoId
    private int[] teamId = {R.drawable.football_jisuanji, R.drawable.football_anquan, R.drawable.football_cailiao,
            R.drawable.football_dianqi, R.drawable.football_dianxin, R.drawable.football_guanli,
            R.drawable.football_guojiao, R.drawable.football_huanhua, R.drawable.football_jixie,
            R.drawable.football_jiangong, R.drawable.football_jingji, R.drawable.football_kuangye,
            R.drawable.football_renwen, R.drawable.football_yanjiusheng};
    //球队名字数组
    private String[] qiuDius = {"计算机", "安全", "材料", "电气", "电信", "管理",
            "国教", "环化", "机械", "建工", "经济", "矿业",
            "人文", "研究生"};
    //比赛时间
    private String shiJian = "12月12日12:12";
    //比赛地点
    private String location = "田径场";
    //得分
    private int score = 2;
    //裁判名
    private String[] caiPanName = {"贝克汉姆", "罗纳尔多", "C罗"};

    //添加按钮
    private ImageView bt_add;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_beisai_saishi, container, false);
            //初始化杯赛数据
            initDataBeiSai();
            //初始化布局数据
            initView();
            //响应事件
            initEvent();
        }
        return view;
    }

    private void initEvent() {
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddSaiShi.class);
                intent.putExtra("赛季","杯赛");
                startActivity(intent);
            }
        });
    }

    private void initDataBeiSai() {
        //初始化杯赛父集合
        for (int i = 0; i < 14; i++) {
            //仅仅是demo
            //所有赛事默认未开赛
            SaiJi saiJi = new SaiJi(saiShiNames[i], saiJiStatueIds[0]);
            if (i % 2 == 1) {
                saiJi.setStateId(saiJiStatueIds[1]);
            }
            groups1.add(saiJi);
        }
        //A组未开赛对象的list
        ArrayList<SaiShi> a0 = new ArrayList<>();
        //A组已开赛的List
        ArrayList<SaiShi> a1 = new ArrayList<>();
        //B组未开赛对象的list
        ArrayList<SaiShi> b0 = new ArrayList<>();
        //B组已开赛的List
        ArrayList<SaiShi> b1 = new ArrayList<>();
        //C组未开赛对象的list
        ArrayList<SaiShi> c0 = new ArrayList<>();
        //C组已开赛的List
        ArrayList<SaiShi> c1 = new ArrayList<>();
        //D组未开赛对象的list
        ArrayList<SaiShi> d0 = new ArrayList<>();
        //D组已开赛的List
        ArrayList<SaiShi> d1 = new ArrayList<>();
        //1/4决赛未开赛对象的list
        ArrayList<SaiShi> siFen0 = new ArrayList<>();
        //1/4决赛已开赛的List
        ArrayList<SaiShi> siFen1 = new ArrayList<>();
        //半决赛未开赛对象的list
        ArrayList<SaiShi> ban0 = new ArrayList<>();
        //半决赛已开赛的List
        ArrayList<SaiShi> ban1 = new ArrayList<>();
        //决赛未开赛对象的list
        ArrayList<SaiShi> jueSai0 = new ArrayList<>();
        //决赛已开赛的List
        ArrayList<SaiShi> jueSai1 = new ArrayList<>();
        //初始化子集合  ---  组赛
        /**
         *   杯赛，抽签分组，四个组，每组队伍个数不定 4 4 3 3，
         *   4个球队的小组有轮次，三轮，一轮2场
         *   3个球队的小组，三场
         *   1/4决赛，8个球队，四场比赛，8进四
         *   半决赛，4个球队，分首轮，次轮，一轮两场
         */
        //具体应该根据服务器里传过来的具体遍历
        //杯赛级数，A、B、C、D、1/4、半决赛、决赛
        //存放所有轮次集合的集合
        Object[] lists = {a0, a1, b0, b1, c0, c1, d0, d1, siFen0, siFen1, ban0, ban1, jueSai0, jueSai1};
        //初始化子集合
        for (int m = 1; m < 8; m++) {
            switch (m) {
                case 1:
                case 2:
                case 3:
                case 4:
                    for (int i = 1; i < 4; i++) {
                        SaiShi saiShi = null;
                        if (countA == 4 || countB == 4 || countC == 4 || countD == 4) {
                            for (int q = 1; q < 3; q++) {
                                //测试
                                saiShi = new SaiShi(saiJiId, saiJiName, zus[m - 1],beiSaiLunCis[i - 1],"第" + q + "场", teamId[q - 1],
                                        qiuDius[q - 1], shiJian, location, score, score, teamId[q], qiuDius[q],
                                        caiPanName[0], caiPanName[1], caiPanName[2], isEnds[q - 1]);
                                if (!saiShi.getIsEnd()) {
                                    ((ArrayList) lists[2 * m - 2]).add(saiShi);
                                } else {
                                    ((ArrayList) lists[2 * m - 1]).add(saiShi);
                                }

                            }
                        } else {
                            //测试
                            saiShi = new SaiShi(saiJiId, saiJiName, zus[m - 1],"","第" + i + "场", teamId[i - 1],
                                    qiuDius[i - 1], shiJian, location, score, score, teamId[i], qiuDius[i],
                                    caiPanName[0], caiPanName[1], caiPanName[2], isEnds[i - 1]);
                            if (!saiShi.getIsEnd()) {
                                ((ArrayList) lists[2 * m - 2]).add(saiShi);
                            } else {
                                ((ArrayList) lists[2 * m - 1]).add(saiShi);
                            }
                        }
                    }
                    break;
                case 5:
                    for (int i = 1; i < 5; i++) {
                        //测试
                        SaiShi saiShi = new SaiShi(saiJiId, saiJiName, zus[m - 1],"", "第" + i + "场", teamId[i - 1],
                                qiuDius[i - 1], shiJian, location, score, score, teamId[i], qiuDius[i],
                                caiPanName[0], caiPanName[1], caiPanName[2], isEnds[i - 1]);
                        if (!saiShi.getIsEnd()) {
                            ((ArrayList) lists[2 * m - 2]).add(saiShi);
                        } else {
                            ((ArrayList) lists[2 * m - 1]).add(saiShi);
                        }
                    }
                    break;
                case 6:
                    for (int i = 1; i < 3; i++) {
                        for (int q = 1; q < 3; q++) {
                            //测试
                            SaiShi saiShi = new SaiShi(saiJiId, saiJiName, zus[m - 1],banLunCis[i-1], "第" + i + "场", teamId[i - 1],
                                    qiuDius[i - 1], shiJian, location, score, score, teamId[i], qiuDius[i],
                                    caiPanName[0], caiPanName[1], caiPanName[2], isEnds[i - 1]);
                            if (!saiShi.getIsEnd()) {
                                ((ArrayList) lists[2 * m - 2]).add(saiShi);
                            } else {
                                ((ArrayList) lists[2 * m - 1]).add(saiShi);
                            }
                        }
                    }
                    break;

                case 7:
                    //测试
                    SaiShi saiShi = new SaiShi(saiJiId, saiJiName, zus[m - 1], "","", teamId[8],
                            qiuDius[8], shiJian, location, score, score, teamId[6], qiuDius[6],
                            caiPanName[0], caiPanName[1], caiPanName[2], isEnds[1]);
                    if (!saiShi.getIsEnd()) {
                        ((ArrayList) lists[2 * m - 2]).add(saiShi);
                    } else {
                        ((ArrayList) lists[2 * m - 1]).add(saiShi);
                    }
                    break;
            }
            beiSaiChilds.add((ArrayList)lists[2*m-2]);
            beiSaiChilds.add((ArrayList)lists[2*m-1]);
        }
    }

    private void initView() {
        //杯赛的
        expandableListView1 = view.findViewById(R.id.el_saishi_beisai);
        ExpandableListAdapter el1 = new ExpandableListAdapter(getContext(), groups1, beiSaiChilds);
        expandableListView1.setAdapter(el1);

        bt_add = view.findViewById(R.id.iv_beisai_saishi_add);
    }

}
