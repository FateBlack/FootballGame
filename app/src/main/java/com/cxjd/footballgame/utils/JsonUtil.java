package com.cxjd.footballgame.utils;

import android.text.TextUtils;

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

}
