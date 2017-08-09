package com.wyman.wangyin.myapplication.utils;

import android.os.Build;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/6/14.
 */
public class AccountUtil {
    /**
     * 100000转换成100，000.00
     */
    public static String LongToString(double l) {
        // 创建格式化对象
        NumberFormat format = NumberFormat.getCurrencyInstance();
        String ff = format.format(l);
        return ff.substring(1, ff.length());
    }

    /**
     * 100000转换成￥100，000.00
     */
    public static String LongToStringCn(long l) {
        // 创建格式化对象
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        return format.format(l);
    }

    /**
     * 100,000.00转换成100000
     */
    public static long MoneyTolong(String money) {
        //String regEx = "[0-9]";
        String regEx = "[,.]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(money);
        String trim = m.replaceAll("").trim();
        String money1 = trim.substring(0, trim.length() - 2);
        long l = Long.parseLong(money1);
        return l;
    }

    /**
     * "100000"转换成&100，000.00
     */
    public static String StringToMString(String s) {
        long ll = Long.parseLong(s);
        String s1 = LongToString(ll);
        return s1;
    }

    public static String DoubleToString(double availableCredit) {
        // 创建格式化对象
        if (0 == availableCredit) {
            return "0.00";
        }
        NumberFormat format = NumberFormat.getCurrencyInstance();
        String ff = format.format(availableCredit);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return ff.substring(1, ff.length());
        } else {
            return ff.substring(1, ff.length());
        }
    }

    /**
     * 吧10000元转换成1.00万元
     */
    public static String parseNum(double Num) {
        double result = Num / 10000;
        BigDecimal b = new BigDecimal(result);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        String str = f1 + "";
        if (str.indexOf(".") == str.length() - 2) {
            str = str + "0";
        }
        return str;
    }

    /**
     * 吧牛德阳转换成***阳
     */
    public static String nameSecret(String string) {
        String newString = string.substring(string.length() - 1, string.length());
        return "***" + newString;
    }

    /**
     * 手机号******
     */
    public static String phoneSecret(String s){
        String head=s.substring(0,3);
        String end=s.substring(s.length()-4,s.length());
        return head+"****"+end;
    }
}
