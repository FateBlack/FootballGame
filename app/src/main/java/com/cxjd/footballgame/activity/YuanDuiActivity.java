package com.cxjd.footballgame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.adapter.YuanDuiAdapter;
import com.cxjd.footballgame.bean.DuiYuan;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.activity
 * 文件名： YuanDuiActivity
 * 创建者： LC
 * 创建时间： 2018/4/15 11:47
 * 描述：   TODO
 */
public class YuanDuiActivity extends AppCompatActivity {
    //LOGO
    ImageView logo;
    //队名
    TextView name;
    //添加图标
    private ImageView add;

    //队员集合
    private List<DuiYuan> duiYuanList = new ArrayList<>();
    //队员信息列表
    private ListView mListView;
    //x位置
    private int mPosX;
    //y位置
    private int mPosY;
    //球队demo
    private int[] imgId = {R.drawable.football_yinhaonan_houyao, R.drawable.football_chengxiaoding_qianbianwei, R.drawable.football_cuironglai_menjiang,
            R.drawable.football_lixingbang_zhonghouwei, R.drawable.football_lizongjian_zhonghouwei, R.drawable.football_liangshengran_qianyao,
            R.drawable.football_muhaofei_bianhouwei, R.drawable.football_renjiwei_qianfeng, R.drawable.football_sunpengyu_zhonghouwei,
            R.drawable.football_wangchuan_qianfeng, R.drawable.football_xiaodazhi_bianhouwei, R.drawable.football_zhangzhenguo_zhonghouwei,
            R.drawable.football_zhouzongbin_bianqianwei};
    private String[] names = {"殷浩南", "程小丁", "崔荣莱", "李兴邦", "李宗建", "梁圣然",
            "穆昊飞", "任吉伟", "孙鹏宇", "王川", "肖大志", "张振国", "周宗彬"};
    private String[] weizhi = {"后腰", "前边卫", "门将", "中后卫", "中后卫", "前腰", "边后卫", "前锋", "中后卫", "前锋", "边后卫", "中后卫", "边前卫"};
    //注意谁是队长


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuandui);
        //初始化页面
        initView();
        //初始化球队信息
        initQiuDui();
        //遍历球队成员与设置点击事件
        initListView();
        //点击事件
        initEvent();
    }

    private void initEvent() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(YuanDuiActivity.this,"添加球队",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //初始化页面布局
    private void initView() {
        //解决ScrollView内嵌套ListView冲突问题
        mListView = findViewById(R.id.lv_yuanDui);
        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int eventaction = event.getActionMasked();
                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN: // touch down so check if the finger is on a ball
                        mPosX = mListView.getScrollX();
                        mPosY = mListView.getScrollY();

                        break;

                    case MotionEvent.ACTION_MOVE:   // touch drag with the ball

                        float ty1 = event.getY(0);
                        float ty2 = event.getY(0);

                        if (((ty2 - ty1) < 0) && (mPosY < mListView.getCount())) {
                            mListView.scrollTo(mPosX, mPosY + 1);
                        } else if (((ty2 - ty1) > 0)) {
                            mListView.scrollTo(mPosX, mPosY - 1);
                        }

                        break;
                }

                return false;
            }

        });
        //初始化球队LOGO和名字
        Intent intent = getIntent();
        int logId = intent.getIntExtra("imgId",0);
        String yuanDuiName = intent.getStringExtra("naem");
        logo = findViewById(R.id.iv_yuandui_logo);
        logo.setImageResource(logId);
        name = findViewById(R.id.main_title);
        name.setText(yuanDuiName);
        //添加图标
        add = findViewById(R.id.tongyi_ringt_image);
        add.setImageResource(R.drawable.add);

    }

    //初始化球队数据
    private void initQiuDui() {
        for (int i = 0; i < names.length; i++) {
            DuiYuan duiYuan = new DuiYuan(imgId[i], "名字 : " + names[i], "位置 : " + weizhi[i]);
            duiYuanList.add(duiYuan);
        }
    }

    //遍历球员
    private void initListView() {
        YuanDuiAdapter adapter = new YuanDuiAdapter(YuanDuiActivity.this, R.layout.duiyuan_item, duiYuanList);
        mListView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(mListView);
    }

    //解决ScrollView嵌套ListView显示冲突
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }


}
