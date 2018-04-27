package com.cxjd.footballgame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.fragment
 * 文件名： SaiShiFragment
 * 创建者： LC
 * 创建时间： 2018/4/12 19:50
 * 描述：   赛事页
 */
public class SaiShiFragment extends Fragment {
    //主标题
    private TextView tv_main_title;
    //Tablayout + viewPager
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> fragments;
    private List<String> titles;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saishi,container,false);
        //页面初始化
        initView(view);
        return view;
    }

    private void initView(View view) {
        tv_main_title = view.findViewById(R.id.main_title);
        tv_main_title.setText("黑科赛事");

        mViewPager =  view.findViewById(R.id.viewpager);
        mTabLayout =  view.findViewById(R.id.tablayout);

        mTabLayout.setupWithViewPager(mViewPager);

        fragments = new ArrayList<>();
        Fragment lianSaiFragment = new LianSaiSaiShiFragment();
        Fragment beiSaiFragment = new BeiSaiSaiShiFragment();
        Fragment saiKuangFragment = new SaiKuangFragment();
        fragments.add(lianSaiFragment);
        fragments.add(beiSaiFragment);
        fragments.add(saiKuangFragment);

        titles = new ArrayList<>();
        titles.add("联赛");
        titles.add("杯赛");
        titles.add("赛况");


        mAdapter = new ViewPagerAdapter(getChildFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

}
