package com.cxjd.footballgame.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

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
 * 文件名： LianSaiSaiShiFragment
 * 创建者： LC
 * 创建时间： 2018/4/18 23:58
 * 描述：   赛事Tablayout联赛选项
 */
public class LianSaiSaiShiFragment extends Fragment  {
    //保证视图唯一
    private View view;

    //联赛点击扩展ListView
    private ExpandableListView expandableListView0;
    //赛季名字
    private String saiJiName = "联赛";
    //联赛群组名
    private List<SaiJi> groups0 = new ArrayList<>();
    //联赛群组下的子项名
    private List<ArrayList<SaiShi>> lianSaiChilds = new ArrayList<>();

    //赛季logoId
    private int saiJiId = R.drawable.football_liansai2;
    //父组件显示轮次
    private String[] groupLunCis = {"第1轮", "第1轮", "第2轮", "第2轮", "第3轮", "第3轮", "第4轮", "第4轮", "第5轮", "第5轮",
            "第6轮", "第6轮", "第7轮", "第7轮", "第8轮", "第8轮", "第9轮", "第9轮", "第10轮", "第10轮", "第11轮",
            "第11轮","第12轮", "第12轮", "第13轮", "第13轮" };
    //赛季状态logoId,0调用，未开始，1调用，结束
    private int[] saiJiStatueIds = {R.drawable.un_start, R.drawable.end};
    //赛事状态
    private boolean[] isEnds = {true, false, true, false, true, false, true, false, true, false, true, false, true, false};
    //赛事轮次
    private String[] lunCis = {"1", "2", "3", "4", "5", "6", "7"};
    //赛事场数
    private String[] numbers = {"1", "2", "3", "4", "5", "6", "7"};
    //队伍logoId
    private int[] teamId = {R.drawable.football_jisuanji, R.drawable.football_anquan, R.drawable.football_cailiao,
            R.drawable.football_dianqi, R.drawable.football_dianxin, R.drawable.football_guanli,
            R.drawable.football_guojiao, R.drawable.football_huanhua, R.drawable.football_jixie,
            R.drawable.football_jiangong, R.drawable.football_jingji, R.drawable.football_kuangye,
            R.drawable.football_renwen, R.drawable.football_yanjiusheng};
    //球队名字数组
    private String[] qiuDius = {"计算机", "安全", "材料", "电气", "电信", "管理", "国教", "环化", "机械", "建工", "经济", "矿业", "人文", "研究生"};
    //比赛时间
    private String shiJian = "12月12日12:12";
    //比赛地点
    private String location = "田径场";
    //得分
    private int score = 2;
    //裁判名
    private String[] caiPanName = {"贝克汉姆", "罗纳尔多", "C罗"};

    //联赛新增按钮
    private ImageView bt_add;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_liansai_saishi, container, false);
            //初始化联赛数据
            initDataLianSai();
            //初始化布局数据
            initView(view);
            //点击事件
            events(view);
        }
        return view;
    }

    private void events(View view) {
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddSaiShi.class);
                intent.putExtra("赛季","联赛");
                startActivity(intent);
            }
        });
    }

    private void initDataLianSai() {
        //初始化联赛父集合
        for (int i = 0; i < 26; i++) {
            //仅仅是demo
            //所有赛事默认未开赛
            SaiJi saiJi = new SaiJi(groupLunCis[i], saiJiStatueIds[0]);
            if (i % 2 == 1) {
                saiJi.setStateId(saiJiStatueIds[1]);
            }
            groups0.add(saiJi);
        }
        //存放第一轮未开赛
        ArrayList<SaiShi> one0 = new ArrayList<>();
        //存放第一轮已结束
        ArrayList<SaiShi> one1 = new ArrayList<>();
        //存放第二轮未开赛
        ArrayList<SaiShi> two0 = new ArrayList<>();
        //存放第二轮已结束
        ArrayList<SaiShi> two1 = new ArrayList<>();
        //存放第三轮未开赛
        ArrayList<SaiShi> three0 = new ArrayList<>();
        //存放第三轮已结束
        ArrayList<SaiShi> three1 = new ArrayList<>();
        //存放第四轮未开赛
        ArrayList<SaiShi> four0 = new ArrayList<>();
        //存放第四轮已结束
        ArrayList<SaiShi> four1 = new ArrayList<>();
        //存放第五轮未开赛
        ArrayList<SaiShi> five0 = new ArrayList<>();
        //存放第五轮已结束
        ArrayList<SaiShi> five1 = new ArrayList<>();
        //存放第六轮未开赛
        ArrayList<SaiShi> six0 = new ArrayList<>();
        //存放第六轮已结束
        ArrayList<SaiShi> six1 = new ArrayList<>();
        //存放第七轮未开赛
        ArrayList<SaiShi> seven0 = new ArrayList<>();
        //存放第七轮已结束
        ArrayList<SaiShi> seven1 = new ArrayList<>();
        //存放第一轮未开赛
        ArrayList<SaiShi> eight0 = new ArrayList<>();
        //存放第一轮已结束
        ArrayList<SaiShi> eight1 = new ArrayList<>();
        //存放第二轮未开赛
        ArrayList<SaiShi> nine0 = new ArrayList<>();
        //存放第二轮已结束
        ArrayList<SaiShi> nine1 = new ArrayList<>();
        //存放第三轮未开赛
        ArrayList<SaiShi> ten0 = new ArrayList<>();
        //存放第三轮已结束
        ArrayList<SaiShi> ten1 = new ArrayList<>();
        //存放第四轮未开赛
        ArrayList<SaiShi> eleven0 = new ArrayList<>();
        //存放第四轮已结束
        ArrayList<SaiShi> eleven1 = new ArrayList<>();
        //存放第五轮未开赛
        ArrayList<SaiShi> twelve0 = new ArrayList<>();
        //存放第五轮已结束
        ArrayList<SaiShi> twelve1 = new ArrayList<>();
        //存放第六轮未开赛
        ArrayList<SaiShi> thirteen0 = new ArrayList<>();
        //存放第六轮已结束
        ArrayList<SaiShi> thirteen1 = new ArrayList<>();
        //存放所有轮次集合的集合
        Object[] lists = {one0,one1,two0,two1,three0,three1,four0,four1,five0,five1,six0,six1,seven0,seven1,eight0,eight1
                          ,nine0,nine1,ten0,ten1,eleven0,eleven1,twelve0,twelve1,thirteen0,thirteen1};
        //初始化子集合
        for (int m = 1; m < 14; m++) {
            for (int i = 1; i < 8; i++) {
                SaiShi saiShi = new SaiShi(saiJiId, saiJiName,"","第"+m+"轮", "第"+i+"场", teamId[i-1],
                        qiuDius[i-1], shiJian, location, score, score, teamId[i], qiuDius[i],
                        caiPanName[0], caiPanName[1], caiPanName[2], isEnds[i-1]);
                //判断状态，已经结束的放一起，未开始的放一起

                if (!isEnds[i-1]) {
                    ((ArrayList)lists[2*m-2]).add(saiShi);
                } else {
                    ((ArrayList)lists[2*m-1]).add(saiShi);
                }

            }
            lianSaiChilds.add((ArrayList)lists[2*m-2]);
            lianSaiChilds.add((ArrayList)lists[2*m-1]);
        }

    }

    private void initView(View view) {
        //新增按钮
        bt_add =  view.findViewById(R.id.iv_liansai_saishi_add);
        //联赛的
        expandableListView0 = view.findViewById(R.id.el_saishi_liansai);
        ExpandableListAdapter el0 = new ExpandableListAdapter(getContext(), groups0, lianSaiChilds);
        expandableListView0.setAdapter(el0);
    }

}
