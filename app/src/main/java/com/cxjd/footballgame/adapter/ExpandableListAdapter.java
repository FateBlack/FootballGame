package com.cxjd.footballgame.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.activity.AddSaiShi;
import com.cxjd.footballgame.bean.SaiJi;
import com.cxjd.footballgame.bean.SaiShi;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.adapter
 * 文件名： ExpandableListAdapter
 * 创建者： LC
 * 创建时间： 2018/4/16 18:43
 * 描述：   ExpandableList适配器,下拉扩展
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    //群组名
    private List<SaiJi> groups = new ArrayList<>();
    //群组下的子项名
    private List<ArrayList<SaiShi>> childs = new ArrayList<>();
    private Context context;

    public ExpandableListAdapter(Context context, List<SaiJi> list0, List<ArrayList<SaiShi>> list1) {
        this.context = context;
        groups = list0;
        childs = list1;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childs.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int i) {
        return groups.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childs.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    //大哥视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        View v = view;
        GroupHolder holder = null;
        if (v == null) {
            //创建视图
            v = LayoutInflater.from(context).inflate(R.layout.saishi_zu_item, null);
            //通过创建的view与自定义布局绑定，就可以找到布局里的组件了
            holder = new GroupHolder();
            //箭头
            holder.jianTouImg = v.findViewById(R.id.iv_saishi_zu_jiantou);
            //赛事所属赛季名字
            holder.saiJiName = v.findViewById(R.id.tv_saishi_zu_saijiname);
            //赛事状态
            holder.statusImg = v.findViewById(R.id.iv_saishi_status);
            v.setTag(holder);
        } else {
            holder =(GroupHolder)v.getTag();
        }

        //判断是否打开列表
        if (isExpanded){
             holder.jianTouImg.setBackgroundResource(R.drawable.up_shuang_jiantou);
        }else {
            holder.jianTouImg.setBackgroundResource(R.drawable.down_shuang_jiantou);
        }
        holder.statusImg.setImageResource(groups.get(groupPosition).getStateId());
        holder.saiJiName.setText(groups.get(groupPosition).getName());
        return v;
    }

    //小弟们视图
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View v = view;
        ChildHolder cholder = null;
        if(v==null){
            //创建视图
            v = LayoutInflater.from(context).inflate(R.layout.saishi_item, null);
            cholder = new ChildHolder();
            //通过创建的view与自定义布局绑定，就可以找到布局里的组件了
            cholder.saiJiImg = v.findViewById(R.id.iv_saiji_child_imgid);
            cholder.saiJiName = v.findViewById(R.id.tv_saishi_child_saiji);
            cholder.kind = v.findViewById(R.id.tv_saishi_child_zuorlun);
            cholder.number = v.findViewById(R.id.tv_saishi_child_chang);
            cholder.beisSaiLunCi =  v.findViewById(R.id.tv_saishi_child_lun);
            cholder.team1Id = v.findViewById(R.id.iv_saishi_team1);
            cholder.team1Name = v.findViewById(R.id.tv_saishi_team1name);
            cholder.date = v.findViewById(R.id.tv_saishi_time);
            cholder.location = v.findViewById(R.id.tv_saishi_changdi);
            cholder.score1 = v.findViewById(R.id.tv_saishi_score1);
            cholder.score2 = v.findViewById(R.id.tv_saishi_score2);
            cholder.team2Img = v.findViewById(R.id.iv_saishi_team2);
            cholder.team2Name = v.findViewById(R.id.tv_saishi_team2name);
            cholder.zhucaiName = v.findViewById(R.id.tv_saishi_zhucai);
            cholder.bianCaiName1 = v.findViewById(R.id.tv_saishi_biancai1);
            cholder.bianCaiName2 = v.findViewById(R.id.tv_saishi_biancai2);
            cholder.bt_gengxin = v.findViewById(R.id.bt_saishi_gengxin);
            v.setTag(cholder);
        } else {
            cholder = (ChildHolder) v.getTag();
        }

        cholder.saiJiImg.setImageResource(childs.get(i).get(i1).getSaiJiId());
        cholder.saiJiName.setText(childs.get(i).get(i1).getSaiJiName());
        cholder.kind.setText(childs.get(i).get(i1).getKind());
        cholder.number.setText(childs.get(i).get(i1).getNumber());
        cholder.beisSaiLunCi.setText(childs.get(i).get(i1).getLunCi());
        cholder.team1Id.setImageResource(childs.get(i).get(i1).getTeam1Id());
        cholder.team1Name.setText(childs.get(i).get(i1).getTeam1Name());
        cholder.date.setText(childs.get(i).get(i1).getDate());
        cholder.location.setText(childs.get(i).get(i1).getLocation());
        cholder.score1.setText(childs.get(i).get(i1).getScore1()+"");
        cholder.score2.setText(childs.get(i).get(i1).getScore2()+"");
        cholder.team2Img.setImageResource(childs.get(i).get(i1).getTeam2Id());
        cholder.team2Name.setText(childs.get(i).get(i1).getTeam2Name());
        cholder.zhucaiName.setText(childs.get(i).get(i1).getZhuCaiName());
        cholder.bianCaiName1.setText(childs.get(i).get(i1).getBianCaiName1());
        cholder.bianCaiName2.setText(childs.get(i).get(i1).getBianCaiName2());

        final SaiShi saiShi = new SaiShi();
        saiShi.setSaiJiId(childs.get(i).get(i1).getSaiJiId());
        saiShi.setSaiJiName(childs.get(i).get(i1).getSaiJiName());
        saiShi.setKind(childs.get(i).get(i1).getKind());
        saiShi.setNumber(childs.get(i).get(i1).getNumber());
        saiShi.setBeiSaiLunCi(childs.get(i).get(i1).getLunCi());
        saiShi.setTeam1Id(childs.get(i).get(i1).getTeam1Id());
        saiShi.setTeam1Name(childs.get(i).get(i1).getTeam1Name());
        saiShi.setDate(childs.get(i).get(i1).getDate());
        saiShi.setLocation(childs.get(i).get(i1).getLocation());
        saiShi.setScore1(childs.get(i).get(i1).getScore1());
        saiShi.setScore2(childs.get(i).get(i1).getScore2());
        saiShi.setTeam2Id(childs.get(i).get(i1).getTeam2Id());
        saiShi.setTeam2Name(childs.get(i).get(i1).getTeam2Name());
        saiShi.setZhuCaiName(childs.get(i).get(i1).getZhuCaiName());
        saiShi.setBianCaiName1(childs.get(i).get(i1).getBianCaiName1());
        saiShi.setBianCaiName2(childs.get(i).get(i1).getBianCaiName2());

        cholder.bt_gengxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddSaiShi.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("saiShi",saiShi);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class GroupHolder {
        private ImageView jianTouImg;            //箭头logo
        private TextView saiJiName;              //赛季名字
        private ImageView statusImg;              //赛季状态logo
    }

    class ChildHolder {
        public Button bt_gengxin;               //更新按钮
        public ImageView saiJiImg;              //赛季图标
        public TextView saiJiName;              //赛季名字
        public TextView kind;                   //组/轮
        public TextView beisSaiLunCi;           //杯赛轮次
        public TextView number;                 //第几场
        public ImageView team1Id;               //1队图
        public TextView team1Name;              //1队名字
        public TextView date;                   //时间
        public TextView location;               //地点
        public TextView score1;                 //1队分
        public TextView score2;                 //2队分
        public ImageView team2Img;              //2队图
        public TextView team2Name;              //2队名字
        public TextView zhucaiName;             //主裁名
        public TextView bianCaiName1;           //边裁1名
        public TextView bianCaiName2;           //边裁2名
    }

}
