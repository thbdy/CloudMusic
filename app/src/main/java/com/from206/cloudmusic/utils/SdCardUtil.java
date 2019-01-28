package com.from206.cloudmusic.utils;

import android.os.Environment;

import java.io.File;

/**
 * 项目描述：东南
 * 创建人：os.zhangf
 * 类描述：-
 * 日期：2017/12/27
 * 版权所有：福富软件
 */
public class SdCardUtil {
    // 项目文件根目录
    public static final String FILEDIR = "/com.from206.cloudmusic";
    // 音乐下载目录
    public static final String FILEMUSIC = "/music";
    // 应用程序图片存放
    public static final String FILEIMAGE = "/images";
    // 应用程序缓存
    public static final String FILECACHE = "/cache";
    // 用户信息目录
    public static final String FILEUSER = "user";
   /*

    * 检查sd卡是否可用

    * getExternalStorageState 获取状态

    * Environment.MEDIA_MOUNTED 直译  环境媒体登上  表示，当前sd可用

    */

    public static boolean checkSdCard() {

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            //sd卡可用
            return true;
        else
            //当前sd卡不可用
            return false;
    }

   /*

    * 获取sd卡的文件路径

    * getExternalStorageDirectory 获取路径

    */

    public static String getSdPath(){
        return Environment.getExternalStorageDirectory()+"";
    }

   /*

    * 创建一个文件夹

    */
    public static  void  createFileDir(String fileDir){
        String path=getSdPath()+fileDir;
        File path1=new File(path);
        if(!path1.exists())
        {
            path1.mkdirs();
        }
    }

}
