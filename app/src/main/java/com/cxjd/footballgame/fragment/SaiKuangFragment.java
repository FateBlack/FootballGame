package com.cxjd.footballgame.fragment;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxjd.footballgame.R;


/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.fragment
 * 文件名： SaiKuangFragment
 * 创建者： LC
 * 创建时间： 2018/4/26 10:40
 * 描述：   赛况
 */
public class SaiKuangFragment extends Fragment {

    private View view;

    //1队图片
    private ImageView team1Logo;
    //1队名字
    private TextView team1Name;
    //赛季
    private TextView saiJi;
    //级别
    private TextView jiBie;
    //2队图片
    private ImageView team2Logo;
    //2队名字
    private TextView team2Name;
    //team1 title name;
    private TextView team1Title;
    //team1赛况
    private EditText team1SaiKuang;
    //team1报道
    private Button team1Baodao;
    //team2 title name
    private TextView team2Title;
    //team2赛况
    private EditText team2SaiKuang;
    //team2报道
    private Button team2Baodao;
    //1队得分
    private EditText team1Score;
    //2队得分
    private EditText team2Score;
    //比分更新
    private Button gengXin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(R.layout.saikuang_fragment,container,false);
            initView(view);
        }

        return view;
    }

    private void initView(View view) {
        team1Logo = view.findViewById(R.id.iv_saikuang_team1);
        team1Name = view.findViewById(R.id.tv_saikuang_team1name);
        saiJi = view.findViewById(R.id.tv_saikuang_saiji);
        jiBie = view.findViewById(R.id.tv_saikuang_jibie);
        team2Logo = view.findViewById(R.id.iv_saikuang_team2);
        team2Name = view.findViewById(R.id.tv_saikuang_team2name);
        team1Title = view.findViewById(R.id.tv_title_team1name);
        team1SaiKuang = view.findViewById(R.id.et_team1_saikuang);
        team1Baodao = view.findViewById(R.id.bt_team1_baodao);
        team2Title = view.findViewById(R.id.tv_title_team2name);
        team2SaiKuang = view.findViewById(R.id.et_team2_saikuang);
        team2Baodao = view.findViewById(R.id.bt_team2_baodao);
        team1Score = view.findViewById(R.id.et_saikuang_team1score);
        team2Score = view.findViewById(R.id.et_saikuang_team2score);
        gengXin = view.findViewById(R.id.bt_score_gengxin);

    }


}
