package com.from206.cloudmusic.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by 75232 on 2019/2/1
 * Email：752323877@qq.com
 */
public class DateUtil {
    private static final ThreadLocal<SimpleDateFormat> SDF_THREAD_LOCAL = new ThreadLocal<>();
    public static SimpleDateFormat getDefaultFormat() {
        SimpleDateFormat simpleDateFormat = SDF_THREAD_LOCAL.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
            SDF_THREAD_LOCAL.set(simpleDateFormat);
        }
        return simpleDateFormat;
    }
}
