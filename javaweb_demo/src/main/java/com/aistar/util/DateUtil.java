package com.aistar.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 提供了日期与字符串的相互转换等
 */
public class DateUtil {
    /**
     * 日期格式，精确到年月日时分秒
     */
    public static final String DATE_PATTERN_YMDHMS = "yyyyMMddHHmmss";

    /**
     * 日期格式，精确到年月日时分秒
     */
    public static final String DATE_PATTERN_YMDHMS2 = "yyyy/MM/dd HH:mm:ss";

    /**
     * 日期格式，精确到年月日时分秒
     */
    public static final String DATE_PATTERN_YMDHMS3 = "yyyy-MM-dd HH:mm";


    /**
     * 日期格式，精确到年月日
     */
    public static final String DATE_PATTERN_YMD = "yyyy-MM-dd";

    /**
     * 日期格式，精确到时分秒
     */
    public static final String DATE_PATTERN_HMS = "HHmmss";



    /**
     * 日期转换成String
     * @param date 日期对象
     * @param datePattern 日期格式
     * @return  返回字符串表示的日期
     */
    public static String date2String(Date date,String datePattern){
        DateFormat dateFormat = new SimpleDateFormat(datePattern);
        return dateFormat.format(date);

    }


    /**
     * String转换成日期
     * @param strDate   字符串表示的日期
     * @return  返回对应的日期对象
     */
    public static Date string2Date(String strDate,String datePattern)  {
        Date date =null ;
       DateFormat dateFormat =  new SimpleDateFormat(datePattern);
        try {
         date =    dateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }



}
