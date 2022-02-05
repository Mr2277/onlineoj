package com.huawei.test;

import cn.hutool.core.date.DateUtil;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        String str = "1970-01";
        SimpleDateFormat sf =  new SimpleDateFormat("yyyy-MM");
        System.out.println(sf.parse(str));

        System.out.println(new Timestamp(DateUtil.parse(str, "yyyy-MM").getTime()));


    }
}
