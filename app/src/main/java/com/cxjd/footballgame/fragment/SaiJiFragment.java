package com.cxjd.footballgame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.footballgame.R;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.fragment
 * 文件名： SaiJiFragment
 * 创建者： LC
 * 创建时间： 2018/4/12 19:39
 * 描述：   赛季页
 */
public class SaiJiFragment extends Fragment {
    //主标题
    private TextView mainTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saiji,container,false);
        //页面初始化
        initView(view);
        return view;
    }

    //初始化页面
    private void initView(View view) {
          mainTitle = view.findViewById(R.id.main_title);
          mainTitle.setText("联盟赛季");
    }
}
