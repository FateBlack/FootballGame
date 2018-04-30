package com.cxjd.footballgame.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.activity.YuanDuiActivity;
import com.cxjd.footballgame.bean.QiuDui;

import java.util.List;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.adapter
 * 文件名： QiuDuiAdapter
 * 创建者： LC
 * 创建时间： 2018/4/13 8:59
 * 描述：   球队RecycleView适配器
 */
public class QiuDuiAdapter extends RecyclerView.Adapter<QiuDuiAdapter.ViewHolder> {

    private List<QiuDui> mQiuDuiList;

    //临时存储器，把RecyclerView的视图存储起来
    static class ViewHolder extends RecyclerView.ViewHolder {
        View qiuDuiView;
        ImageView qiuDuiImage;
        TextView qiuDuiName;

        public ViewHolder(View view) {
            super(view);
            qiuDuiView = view;
            qiuDuiImage = view.findViewById(R.id.iv_qiudui_logo);
            qiuDuiName = view.findViewById(R.id.tv_qiudui_name);
        }
    }

    public QiuDuiAdapter(List<QiuDui> qiuDuiList){
        mQiuDuiList = qiuDuiList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.qiudui_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.qiuDuiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                QiuDui qiuDui = mQiuDuiList.get(position);
                //进入球队详情页面
                Intent intent = new Intent(view.getContext(), YuanDuiActivity.class);
                //intent.putExtra("imgId",qiuDui.getImgId());
                intent.putExtra("naem",qiuDui.getName());
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         QiuDui qiuDui = mQiuDuiList.get(position);
         holder.qiuDuiImage.setImageBitmap(qiuDui.getLog());
         holder.qiuDuiName.setText(qiuDui.getName());
    }

    @Override
    public int getItemCount() {
        return mQiuDuiList.size();
    }
}
