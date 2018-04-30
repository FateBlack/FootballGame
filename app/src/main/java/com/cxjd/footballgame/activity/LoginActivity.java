package com.cxjd.footballgame.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cxjd.footballgame.R;
import com.cxjd.footballgame.bean.User;
import com.cxjd.footballgame.utils.HttpUtil;
import com.cxjd.footballgame.utils.JsonUtil;
import com.cxjd.footballgame.utils.SoftKeyboardStateHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 项目名： FootBallGame
 * 包名：   com.cxjd.footballgame
 * 文件名： LoginActivity
 * 创建者： LC
 * 创建时间： 2018/4/11 10:55
 * 描述：   用户登录界面
 */
public class LoginActivity extends Activity{
    //根布局
    private LinearLayout root;
    //用户名编辑框
    private EditText userEt;
    //用户密码编辑框
    private EditText passEt;
    //用户名
    private String userName;
    //密码
    private String password;
    //登录按钮
    private Button dengLu;

    // 用户集合
    private List<User> userList;
    // 请求地址
    String address = "http://";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //实现全屏效果
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        //初始化视图
        initView();
        //软键盘弹出弹下时的动画效果
        listenKeyboardLayout(root, dengLu);
        //按钮点击事件
        onClick();
    }

    private void initView() {
        //初始化控件
        userEt = findViewById(R.id.et_login_username);
        passEt = findViewById(R.id.et_login_password);
        dengLu = findViewById(R.id.bt_login_denglu);
        root = findViewById(R.id.sv_login_root);
    }

    private void listenKeyboardLayout(final LinearLayout root, final View scrollToView) {
        SoftKeyboardStateHelper keyboardStateHelper = new SoftKeyboardStateHelper(root);
        keyboardStateHelper.addSoftKeyboardStateListener(new SoftKeyboardStateHelper.SoftKeyboardStateListener() {

            @Override
            public void onSoftKeyboardOpened(int keyboardHeightInPx) {
                Rect rect = new Rect();
                // 获取root在窗体的可视区域
                root.getWindowVisibleDisplayFrame(rect);
                int[] location = new int[2];
                // 获取scrollToView在窗体的坐标
                scrollToView.getLocationInWindow(location);
                // 计算root滚动高度，使scrollToView在可见区域的底部
                int srollHeight = (location[1] + scrollToView.getHeight()) - rect.bottom;
                root.scrollTo(0, srollHeight);
            }

            @Override
            public void onSoftKeyboardClosed() {
                // 键盘隐藏
                root.scrollTo(0, 0);
            }
        });
    }

    private void onClick() {
        //登录
        dengLu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName =  userEt.getText().toString();
                password = passEt.getText().toString();

                if (userName != null && userName.length() > 0 && password != null && password.length() > 0) {
                    queryFromServer(address);
                }else {
                    return;
                }

                if (userList != null && !userList.isEmpty()) {
                    for (User user : userList) {
                        if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                            user.save();
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }

                Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
               /* if(userName.equals("yinhaonan")&&password.equals("1234")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }

    public void queryFromServer(String address) {
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                userList = JsonUtil.handleUserReponse(responseText);
            }
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(LoginActivity.this, "发送请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
