package com.cxjd.footballgame.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.bean.DuiYuan;

import java.util.List;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.adapter
 * 文件名： YuanDuiAdapter
 * 创建者： LC
 * 创建时间： 2018/4/15 21:55
 * 描述：   TODO
 */
public class YuanDuiAdapter extends ArrayAdapter<DuiYuan> {
    //来源
    private int resouceId;
    //上下文环境
    private Context mContext;

    public YuanDuiAdapter(Context context, int textViewResourceId, List<DuiYuan> objects) {
        super(context, textViewResourceId, objects);
        mContext = context;
        resouceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        //临时存储器
        ViewHolder viewHolder = null;
        if (viewHolder == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.duiyuan_item, null);
            viewHolder.tvName = view.findViewById(R.id.tv_qiuyuan_name);
            viewHolder.tvWeizhi = view.findViewById(R.id.tv_qiuyuan_weizhi);
            viewHolder.isCap = view.findViewById(R.id.iv_duiyuan_iscap);
            viewHolder.imageView =view.findViewById(R.id.iv_qiuyuan_head);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //获得当前选项队员对象
        DuiYuan duiYuan = getItem(position);
        viewHolder.imageView.setImageResource(duiYuan.getImgId());
        viewHolder.tvName.setText(duiYuan.getName());
        viewHolder.tvWeizhi.setText(duiYuan.getWeizhi());
        if (duiYuan.getName().equals("名字 : 程小丁")) {
            viewHolder.isCap.setImageResource(R.drawable.cap);
        }
        viewHolder.isCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"修改队员信息,默认全是队员，待开放",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


    //临时存储器
    class ViewHolder{
        ImageView imageView;
        TextView tvName;
        TextView tvWeizhi;
        ImageView isCap;
    }
}
