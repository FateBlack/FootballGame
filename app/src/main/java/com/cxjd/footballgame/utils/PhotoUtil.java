package com.cxjd.footballgame.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/** 用于 图片保存到本地
 *
 * Created by 白 on 2018/4/30.
 */

public class PhotoUtil {

    /** 图片存储路径 **/
    public  File PHOTO_DIR = new File(Environment.getExternalStorageDirectory()+"image");//设置保存路径

    /** 存储图片到本地 **/
    public void savePhoto(String photoName, Bitmap bitmap) {

        if (!PHOTO_DIR.exists()) {
            PHOTO_DIR.mkdirs();
        }

        File avaterFile = new File(PHOTO_DIR, photoName);

        if (avaterFile.exists()) {
            avaterFile.delete();
        }

        try {
            avaterFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(avaterFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
