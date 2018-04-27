package com.cxjd.footballgame.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.adapter
 * 文件名： ViewPagerAdapter
 * 创建者： LC
 * 创建时间： 2018/4/18 23:46
 * 描述：   适配器
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    /**
     * 构造方法
     * @param manager
     * @param fragments
     */
    public ViewPagerAdapter(FragmentManager manager, List<Fragment> fragments,List<String> titles){
        super(manager);
        this.fragments=fragments;
        this.titles=titles;
    }

    @Override
    public int getCount() {
        if (fragments!=null){
            return fragments.size();
        }
        return 0;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments!=null){
            return fragments.get(position);
        }
        return null;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (titles!=null){
            String title = titles.get(position);
            return title;
        }
        return "";
    }
}
