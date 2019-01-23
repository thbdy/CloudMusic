package com.from206.cloudmusic.utils;

import android.text.TextUtils;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.SPUtils;
import com.from206.cloudmusic.module.login.model.LoginResult;

/**
 * Created by 75232 on 2019/1/23
 * Email：752323877@qq.com
 */
public class PersonInfoUtil {
    private static LoginResult personInfo;
    public static LoginResult getPersonInfo(){
        if(personInfo == null) {
            String str = SPUtils.getInstance().getString("personInfo");
            if(!TextUtils.isEmpty(str)){
                personInfo = GsonUtils.fromJson(str,LoginResult.class);
            }
        }
        return personInfo;
    }

    /**
     * 保存个人资料
     */
    public static void savPersonInfo(LoginResult loginResult){
        personInfo = loginResult;
        SPUtils.getInstance().put("personInfo",GsonUtils.toJson(loginResult));
    }

}
