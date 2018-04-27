package com.cxjd.footballgame.activity;

import java.util.ArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.adapter.FragmentAdapter;
import com.cxjd.footballgame.fragment.PaiHangBangFragment;
import com.cxjd.footballgame.fragment.QiuDuiFragment;
import com.cxjd.footballgame.fragment.SaiJiFragment;
import com.cxjd.footballgame.fragment.SaiShiFragment;


public class MainActivity extends FragmentActivity implements OnClickListener,
        OnPageChangeListener {
    //标题
    private TextView tvTitle;


    private ArrayList<TextView> tv_menus;
    private ArrayList<ImageView> imgv_menus;
    private ViewPager mViewPager;

    private ArrayList<Fragment> mFragments;
    private FragmentAdapter mMainMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
        initData();
        initEvent();
    }

    // 初始化控件
    private void initView() {
        tv_menus = new ArrayList<TextView>();
        tv_menus.add((TextView) findViewById(R.id.tv_bottomMenu_saiji));
        tv_menus.add((TextView) findViewById(R.id.tv_bottomMenu_qiudui));
        tv_menus.add((TextView) findViewById(R.id.tv_bottomMenu_saishi));
        tv_menus.add((TextView) findViewById(R.id.tv_bottomMenu_me));
        imgv_menus = new ArrayList<ImageView>();
        imgv_menus.add((ImageView) findViewById(R.id.imgv_bottomMenu_saiji));
        imgv_menus
                .add((ImageView) findViewById(R.id.imgv_bottomMenu_qiudui));
        imgv_menus
                .add((ImageView) findViewById(R.id.imgv_bottomMenu_saishi));
        imgv_menus.add((ImageView) findViewById(R.id.imgv_bottomMenu_paihang));
        mViewPager =  findViewById(R.id.vp_main_menuContent);
    }

    // 初始化数据
    private void initData() {
        mFragments = new ArrayList<Fragment>();
        mFragments.add(new SaiJiFragment());
        mFragments.add(new QiuDuiFragment());
        mFragments.add(new SaiShiFragment());
        mFragments.add(new PaiHangBangFragment());
        mMainMenuAdapter = new FragmentAdapter(getSupportFragmentManager(),
                mFragments);
        setMenuSelector(0); // 默认选中第一个菜单项"赛季"
    }

    // 初始化事件
    private void initEvent() {
        mViewPager.setAdapter(mMainMenuAdapter);
        mViewPager.addOnPageChangeListener(this);
        findViewById(R.id.ll_bottomMenu_saiji).setOnClickListener(this);
        findViewById(R.id.ll_bottomMenu_qiudui).setOnClickListener(this);
        findViewById(R.id.ll_bottomMenu_saishi).setOnClickListener(this);
        findViewById(R.id.ll_bottomMenu_me).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_bottomMenu_saiji:
                setMenuSelector(0);
                break;
            case R.id.ll_bottomMenu_qiudui:
                setMenuSelector(1);
                break;
            case R.id.ll_bottomMenu_saishi:
                setMenuSelector(2);
                break;
            case R.id.ll_bottomMenu_me:
                setMenuSelector(3);
                break;

        }
    }

    /**
     * 选中指定的菜单项并显示对应的Fragment
     *
     * @param index
     */
    private void setMenuSelector(int index) {
        reSetSelected();
        tv_menus.get(index).setSelected(true);
        imgv_menus.get(index).setSelected(true);
        mViewPager.setCurrentItem(index);
    }

    /**
     * 重置底部菜单所有ImageView和TextView为未选中状态
     */
    private void reSetSelected() {
        for (int i = 0; i < tv_menus.size(); i++) {
            tv_menus.get(i).setSelected(false);
            imgv_menus.get(i).setSelected(false);
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        setMenuSelector(arg0);
    }
}
