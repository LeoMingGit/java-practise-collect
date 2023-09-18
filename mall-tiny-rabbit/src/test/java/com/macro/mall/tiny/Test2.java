package com.macro.mall.tiny;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {



    @Test
    public    void testDateCompare() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2009-12-31");
        Date date2 = sdf.parse("2019-01-31");

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 时间在 Date2 之后");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 时间在 Date2 之前");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 时间与 Date2 相等");
        } else {
            System.out.println("程序怎么会运行到这里?正常应该不会");
        }
    }

    @Test
   public   void testDateCompare2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2009-12-31");
        Date date2 = sdf.parse("2019-01-31");

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.after(date2)) {
            System.out.println("Date1 时间在 Date2 之后");
        }

        if (date1.before(date2)) {
            System.out.println("Date1 时间在 Date2 之前");
        }

        if (date1.equals(date2)) {
            System.out.println("Date1 时间与 Date2 相等");
        }
    }


    @Test
    public  void  testInteger01 (){
        Integer  a =1;
        Integer  b=2;

        if (a.compareTo(b) > 0) {
            // 在这里执行操作，如果a大于b
            System.out.println("在这里执行操作，如果a大于b");
        } else if (a.compareTo(b) < 0) {
            // 在这里执行操作，如果a小于b
            System.out.println("在这里执行操作，如果a小于b");

        } else {
            // 在这里执行操作，如果a等于b
            System.out.println(" 在这里执行操作，如果a等于b");

        }


    }


}
