package com.cxjd.footballgame.utils;

import android.text.TextUtils;

import com.cxjd.footballgame.bean.QiuDui;
import com.cxjd.footballgame.bean.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白 on 2018/4/29.
 */

public class JsonUtil {

    // 处理用户登录
    public static List<User> handleUserReponse(String response) {
        List<User> userList = new ArrayList<>();
        if (!TextUtils.isEmpty(response)) {

            try {
                JSONArray allUser = new JSONArray(response);
                for (int i = 0; i < allUser.length(); i++) {
                    JSONObject object = allUser.getJSONObject(i);
                    User user = new User();
                    user.setId(object.getInt("id"));
                    user.setName(object.getString("name"));
                    user.setPassword(object.getString("password"));
                    userList.add(user);
                }
                return userList;
            } catch (JSONException e) {
                e.printStackTrace();
                return userList;
            }
        } else return userList;

    }

    public static boolean handleQiuDuiReponse(String response) {
        List<User> userList = new ArrayList<>();
        if (!TextUtils.isEmpty(response)) {

            try {
                JSONArray allQiuDui = new JSONArray(response);
                for (int i = 0; i < allQiuDui.length(); i++) {
                    JSONObject object = allQiuDui.getJSONObject(i);
                    QiuDui qiuDui = new QiuDui();
                    qiuDui.setId(object.getInt("id"));
                    qiuDui.setName(object.getString("name"));
                    qiuDui.setLogUrl(object.getString("log"));
                    qiuDui.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        } else return false;

    }

}
