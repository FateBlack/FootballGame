package com.cxjd.footballgame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cxjd.footballgame.R;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.fragment
 * 文件名： PaiHangBangFragment
 * 创建者： LC
 * 创建时间： 2018/4/12 20:45
 * 描述：   球队排行榜
 */
public class PaiHangBangFragment extends Fragment {

    private View view;

    private TextView mainTitle;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null){
            view = inflater.inflate(R.layout.fragment_paihangbang,container,false);
            initView();
            initDate();
        }
        return view;
    }

    private void initDate() {
        mainTitle.setText("排行榜");
    }

    private void initView() {
        mainTitle = view.findViewById(R.id.main_title);
    }
}
