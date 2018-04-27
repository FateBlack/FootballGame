package com.cxjd.footballgame.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.adapter
 * 文件名： FragmentAdapter
 * 创建者： LC
 * 创建时间： 2018/4/12 19:56
 * 描述：   碎片适配器
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragments;
    public FragmentAdapter(FragmentManager fm,ArrayList<Fragment> fragment) {
        super(fm);
        this.mFragments = fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
