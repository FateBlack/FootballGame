package com.cxjd.footballgame.activity;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.bean.SaiShi;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame.activity
 * 文件名： AddSaiShi
 * 创建者： LC
 * 创建时间： 2018/4/20 10:07
 * 描述：   新增或者修改赛事
 */
public class AddSaiShi extends AppCompatActivity {
    //赛季下拉菜单
    private Spinner spSaiJi;
    //赛季Logo
    private int[] saiJiId = {R.drawable.football_liansai2, R.drawable.football_beisai};
    //进阶文字
    private TextView jinJie;
    //小组下拉菜单
    private Spinner spXiaoZu;
    //轮次下拉菜单
    private Spinner splunCi;
    //场数下拉菜单
    private Spinner spChangShu;
    //单选框,场地
    private RadioGroup rgChangDi;
    //第一个队伍的下拉列表
    private Spinner spinner0;
    //第二个队伍的下拉列表
    private Spinner spinner1;
    //球队Logo数组
    private int[] logos = {R.drawable.football_jisuanji, R.drawable.football_anquan, R.drawable.football_cailiao,
            R.drawable.football_dianqi, R.drawable.football_dianxin, R.drawable.football_guanli,
            R.drawable.football_guojiao, R.drawable.football_huanhua, R.drawable.football_jixie,
            R.drawable.football_jiangong, R.drawable.football_jingji, R.drawable.football_kuangye,
            R.drawable.football_renwen, R.drawable.football_yanjiusheng};
    //第一个球队Logo
    private ImageView team1Logo;
    //第二个球队Logo
    private ImageView team2Logo;

    //定义五个记录当前的时间
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    //比赛时间
    private int saiMonth;
    private int saiDay;
    private int saiHour;
    private int saiMinute;

    //日历选择器
    private DatePicker dp;
    //时间选择器
    private TimePicker tp;

    //得分
    private EditText team1Score;
    private EditText team2Score;

    //得分处球队名
    private TextView scoreTeam1Name;
    private TextView scoreTeam2Name;

    //主裁判
    private EditText et_zhuCai;
    //边裁判
    private EditText et_bianCaiPan1Name;
    private EditText et_bianCaiPan2Name;

    //第一个球队
    String qiuDui0;
    //第二个球队
    String qiuDui1;

    //提交
    private Button tijiao;

    //赛事对象
    private SaiShi saiShi;

    //map集合   ---  用于赛事更新
    private Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            //赛季
            put("联赛",0);
            put("杯赛",1);

            //球队
            put("计算机", 0);
            put("安全", 1);
            put("材料", 2);
            put("电气", 3);
            put("电信", 4);
            put("管理", 5);
            put("国教", 6);
            put("环化", 7);
            put("机械", 8);
            put("建工", 9);
            put("经济", 10);
            put("矿业", 11);
            put("人文", 12);
            put("研究生", 13);

            //杯赛，阶段
            put("A组",1);
            put("B组",2);
            put("C组",3);
            put("D组",4);
            put("1/4决赛",5);
            put("半决赛",6);
            put("决赛",7);

            //轮次
            put("无",0);
            put("首轮",1);
            put("次轮",2);
            put("第1轮",3);
            put("第2轮",4);
            put("第3轮",5);
            put("第4轮",6);
            put("第5轮",7);
            put("第6轮",8);
            put("第7轮",9);
            put("第8轮",10);
            put("第9轮",11);
            put("第10轮",12);
            put("第11轮",13);
            put("第12轮",14);
            put("第13轮",15);

            //场数
            put("第1场",1);
            put("第2场",2);
            put("第3场",3);
            put("第4场",4);
            put("第5场",5);
            put("第6场",6);
            put("第7场",7);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsaishi);
        //初始化布局
        initView();
        //初始化数据
        initDate();
        //响应事件
        events();
    }

    private void initDate() {
        /**
         * ！！把添加中得到的数据，上传至服务器，这里全部存在对象中
         */
        saiShi = new SaiShi();
        saiShi.setLocation("田径场");

        String saiji = getIntent().getStringExtra("赛季");
        if (saiji!=null){
            if (saiji.equals("杯赛")) {
                //初始化赛季
                spSaiJi.setSelection(0, true);
                jinJie.setVisibility(View.VISIBLE);
                spXiaoZu.setVisibility(View.VISIBLE);
            } else {
                spSaiJi.setSelection(1, true);
            }
        }

        SaiShi saiShi = (SaiShi) getIntent().getSerializableExtra("saiShi");
        if (saiShi != null) {

            spSaiJi.setSelection(map.get(saiShi.getSaiJiName()));
            if (saiShi.getSaiJiName().equals("杯赛")){
                spXiaoZu.setSelection(map.get(saiShi.getKind()));
                jinJie.setVisibility(View.VISIBLE);
                spXiaoZu.setVisibility(View.VISIBLE);
            }
            splunCi.setSelection(map.get(saiShi.getLunCi()));
            spChangShu.setSelection(map.get(saiShi.getNumber()));
            spinner0.setSelection(map.get(saiShi.getTeam1Name()));
            spinner1.setSelection(map.get(saiShi.getTeam2Name()));
            team1Logo.setImageResource(logos[map.get(saiShi.getTeam1Name())]);
            team2Logo.setImageResource(logos[map.get(saiShi.getTeam2Name())]);
            String nowDate = saiShi.getDate();
            String[] dates =  nowDate.split("月|日|:");
            saiMonth = Integer.parseInt(dates[0])-1;
            saiDay = Integer.parseInt(dates[1]);
            saiHour = Integer.parseInt(dates[2]);
            saiMinute = Integer.parseInt(dates[3]);
            showDate(saiMonth,saiDay,saiHour,saiMinute);
            team1Score.setText(saiShi.getScore1()+"");
            team2Score.setText(saiShi.getScore2()+"");
            scoreTeam1Name.setText(saiShi.getTeam1Name());
            scoreTeam2Name.setText(saiShi.getTeam2Name());
            et_zhuCai.setText(saiShi.getZhuCaiName());
            et_bianCaiPan1Name.setText(saiShi.getBianCaiName1());
            et_bianCaiPan2Name.setText(saiShi.getBianCaiName2());
        }

        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                AddSaiShi.this.year = year;
                AddSaiShi.this.month = month;
                AddSaiShi.this.day = day;
            }
        });
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int mimute) {
                AddSaiShi.this.hour = hour;
                AddSaiShi.this.minute = minute;
                //显示当前日期、时间
                showDate(month, day, hour, minute);
            }
        });



    }

    private void events() {
        //赛季
        spSaiJi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] saiJis = getResources().getStringArray(R.array.saiji);
                saiShi.setSaiJiName(saiJis[i]);
                saiShi.setSaiJiId(saiJiId[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                saiShi.setSaiJiName("联赛");
                saiShi.setSaiJiId(saiJiId[0]);
            }
        });
        //进阶/小组(包括1/4决赛，半决赛，决赛)
        spXiaoZu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Toast.makeText(AddSaiShi.this,"请选择杯赛阶段",Toast.LENGTH_SHORT);
                    saiShi.setKind("");
                } else {
                    String[] jinJies = getResources().getStringArray(R.array.zu);
                    saiShi.setSaiJiName(jinJies[i]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                saiShi.setKind("A组");
            }
        });
        //轮次
        splunCi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    saiShi.setBeiSaiLunCi("");
                } else {
                    String[] lunCis = getResources().getStringArray(R.array.lunci);
                    saiShi.setSaiJiName(lunCis[i]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                saiShi.setBeiSaiLunCi("");
            }
        });

        //场数
        spChangShu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    saiShi.setNumber("");
                } else {
                    String[] numbers = getResources().getStringArray(R.array.chang);
                    saiShi.setSaiJiName(numbers[i]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                saiShi.setNumber("");
            }
        });


        //场地
        rgChangDi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_changdi_tianjingchang:
                        saiShi.setLocation("田径场");
                        break;
                    case R.id.rb_changdi_xiaochang:
                        saiShi.setLocation("小场");
                        break;
                }
            }
        });

        //第一个球队
        spinner0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] qiuDuis = getResources().getStringArray(R.array.footBallQiuDui);
                saiShi.setTeam1Name(qiuDuis[i]);
                team1Logo.setImageResource(logos[i]);
                saiShi.setTeam1Id(logos[i]);
                scoreTeam1Name.setText(qiuDuis[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                saiShi.setTeam1Name("计算机");
                saiShi.setTeam1Id(logos[0]);
            }
        });

        //第二个球队
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] qiuDuis = getResources().getStringArray(R.array.footBallQiuDui);
                saiShi.setTeam2Name(qiuDuis[i]);
                team2Logo.setImageResource(logos[i]);
                saiShi.setTeam2Id(logos[i]);
                scoreTeam2Name.setText(qiuDuis[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                saiShi.setTeam1Name("计算机");
                saiShi.setTeam1Id(logos[0]);
            }
        });

        //提交事件
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_zhuCai.getText().toString().equals("") || et_bianCaiPan1Name.getText().toString().equals("") || et_bianCaiPan2Name.getText().toString().equals("")) {
                    Toast.makeText(AddSaiShi.this, "有信息没有填哦，请检查你的比分和裁判哈", Toast.LENGTH_SHORT).show();
                } else {
                    if (team1Score.getText().toString().equals("") && team2Score.getText().toString().equals("")) {
                        saiShi.setScore1(0);
                        saiShi.setScore2(0);
                    }
                    if (team1Score.getText().toString().equals("")) {
                        saiShi.setScore1(0);
                    }
                    if (team2Score.getText().toString().equals("")) {
                        saiShi.setScore2(0);
                    }
                    saiShi.setScore1(Integer.parseInt(team1Score.getText().toString()));
                    saiShi.setScore2(Integer.parseInt(team2Score.getText().toString()));
                    saiShi.setZhuCaiName(et_zhuCai.getText().toString());
                    saiShi.setBianCaiName1(et_bianCaiPan1Name.getText().toString());
                    saiShi.setBianCaiName2(et_bianCaiPan2Name.getText().toString());
                    finish();
                }
            }
        });
    }

    private void initView() {
        //赛季下拉列表
        spSaiJi = findViewById(R.id.sp_add_saiji);
        //进阶
        jinJie = findViewById(R.id.tv_add_jinjie);
        //小组下拉列表
        spXiaoZu = findViewById(R.id.sp_add_xiaozu);
        //轮次下拉列表
        splunCi = findViewById(R.id.sp_add_lunci);
        //场数下拉列表
        spChangShu = findViewById(R.id.sp_add_changshu);
        //场地单选框
        rgChangDi = findViewById(R.id.rp_group);
        //1队Logo
        team1Logo = findViewById(R.id.iv_saishi_team1);
        //2队Logo
        team2Logo = findViewById(R.id.iv_saishi_team2);
        //获取第一个队伍的下拉列表
        spinner0 = findViewById(R.id.sp_add_saishi_team1);
        //获取第二个队伍的下拉列表
        spinner1 = findViewById(R.id.sp_add_saishi_team2);
        //赛事的时间
        dp = findViewById(R.id.dp_add_saishi);
        tp = findViewById(R.id.tp_add_saishi);
        tp.setIs24HourView(true);
        //获取当前的年、月、日、小时、分钟
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        //得分处队伍的名字
        scoreTeam1Name = findViewById(R.id.tv_add_team1_name);
        scoreTeam2Name = findViewById(R.id.tv_add_team2_name);
        //队伍得分
        team1Score = findViewById(R.id.tv_add_team1_score);
        team2Score = findViewById(R.id.tv_add_team2_score);
        //主裁判
        et_zhuCai = findViewById(R.id.et_add_saishi_zhucainame);
        //边裁1
        et_bianCaiPan1Name = findViewById(R.id.et_add_saishi_biancai1name);
        //边裁2
        et_bianCaiPan2Name = findViewById(R.id.et_add_saishi_biancai2name);
        //提交按钮
        tijiao = findViewById(R.id.bt_add_saishi_tijiao);
        //隐藏分组
        jinJie.setVisibility(View.INVISIBLE);
        spXiaoZu.setVisibility(View.INVISIBLE);

    }

    private void showDate(int month, int day, int hour, int minute) {
        TextView show = findViewById(R.id.tv_showtime);
        show.setText("比赛日期 ：" + (month + 1) + "月" + day + "日" + hour + ":" + minute);
        saiShi.setDate("比赛日期 ：" + (month + 1) + "月" + day + "日" + hour + ":" + minute);
    }


}
