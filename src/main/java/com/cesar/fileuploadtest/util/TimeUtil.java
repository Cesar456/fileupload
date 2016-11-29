package com.cesar.fileuploadtest.util;

import java.util.Calendar;

/**
 * Created by Cesar on 2016/11/29.
 * 时间常用函数
 */
public class TimeUtil {
    /**
     * 用于上传文件存储的文件夹的命名
     *
     * @return 以"yyyyMMdd"的格式返回当天时间(string)
     */
    public static String getDateTime() {
        Calendar calendar = Calendar.getInstance();
        return Integer.toString(calendar.get(Calendar.YEAR))
                + Integer.toString(calendar.get(Calendar.MONTH) + 1)
                + Integer.toString(calendar.get(Calendar.DATE));
    }
}
