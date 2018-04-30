package com.cxjd.footballgame.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.activity.LoginActivity;
import com.cxjd.footballgame.adapter.QiuDuiAdapter;
import com.cxjd.footballgame.bean.QiuDui;
import com.cxjd.footballgame.utils.HttpUtil;
import com.cxjd.footballgame.utils.JsonUtil;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import pl.droidsonroids.gif.GifImageView;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.fragment
 * 文件名： QiuDuiFragment
 * 创建者： LC
 * 创建时间： 2018/4/12 19:39
 * 描述：   球队页
 */
public class QiuDuiFragment extends Fragment{
    protected View view;
    //主标题
    private TextView mainTitle;
    //添加图标
    private ImageView add;

    /** 图片存储路径 **/
    File PHOTO_DIR = new File(Environment.getExternalStorageDirectory()+"image");


    //用于存放球队对象的集合
    private List<QiuDui> qiuDuiList = new ArrayList<>();
    //球队数量
    private int n = 14;
    //球队名字数组
    private String[] qiuDius = {"计算机院","安全学院","材料学院","电气学院","电信学院","管理学院",
                                "国教学院","环化学院","机械学院","建工学院","经济学院","矿业学院",
                                "人文学院","研究生院"};
    //球队Logo数组
    private int[] logos = {R.drawable.football_jisuanji,R.drawable.football_anquan,R.drawable.football_cailiao,
                           R.drawable.football_dianqi,R.drawable.football_dianxin,R.drawable.football_guanli,
                           R.drawable.football_guojiao,R.drawable.football_huanhua,R.drawable.football_jixie,
                           R.drawable.football_jiangong,R.drawable.football_jingji,R.drawable.football_kuangye,
                           R.drawable.football_renwen,R.drawable.football_yanjiusheng,};



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_qiudui,container,false);
            //初始化球队数据
            initData();
            //初始化布局
            initView(view);
            //响应事件
            events();
        }
        return view;
    }

    private void initData(){


          for (int i=0; i<n; i++){
              QiuDui qiuDui = new QiuDui();
            //  qiuDui.setImgId(logos[i]);
              qiuDui.setName(qiuDius[i]);
              qiuDuiList.add(qiuDui);
          }


    }

    private void initView(View view) {
        //RecyclerView中表格布局初始化
        RecyclerView recyclerView = view.findViewById(R.id.rv_qiudui);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        /** 加载 服务器端数据 和 网络图片 **/
        queryQiudui();

        QiuDuiAdapter adapter = new QiuDuiAdapter(qiuDuiList);
        recyclerView.setAdapter(adapter);
        //主标题初始化
        mainTitle = view.findViewById(R.id.main_title);
        mainTitle.setText("联盟球队");
        //添加图标
        add = view.findViewById(R.id.tongyi_ringt_image);
        add.setImageResource(R.drawable.add);

    }

    //响应事件
    private void events() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"添加球队",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void queryQiudui(){
        qiuDuiList = DataSupport.findAll(QiuDui.class);

        if (qiuDuiList.get(0).getState() == 1) {
            for (QiuDui qiuDui : qiuDuiList) {
                Bitmap bitmap = readPhoto(qiuDui.getLocalPath());
                qiuDui.setLog(bitmap);
            }
        }else{
            //TODO
            String address = "http://---------------------------------------";
            queryFromServer(address);
        }
    }


    private void queryFromServer(String address) {
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                boolean result = false;

                result = JsonUtil.handleQiuDuiReponse(responseText);

                if (result) {
                    qiuDuiList = DataSupport.findAll(QiuDui.class);

                    for (QiuDui qiuDui : qiuDuiList) {
                        setBitmap(qiuDui);
                    }
                    queryQiudui();
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getContext(), "加载图片失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 把网络 图片 加入 qiuDuiList 中
    private void setBitmap(final QiuDui qiuDui) {
        HttpUtil.sendOkHttpRequest(qiuDui.getLogUrl(), new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                qiuDui.setLog(bitmap);
            }
            @Override
            public void onFailure(Call call, IOException e) {

            }
        });
    }

    // 读取本地图片
    private Bitmap readPhoto(String localPath){
        Bitmap bitmap = null;
        try {
            File avaterFile = new File(PHOTO_DIR, "");
            if (avaterFile.exists()) {
                bitmap = BitmapFactory.decodeFile(PHOTO_DIR+"/"+"");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }




}
