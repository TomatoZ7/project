package com.apeces.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Season {
	/**
     * 获取 x 个季度之前的日期
     * @param x
     * @return
     */
    public static Date getBeforQuarterStartDate(Date nowDate,int x){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        int tempYear =calendar.get(Calendar.YEAR);	// 2021
        int m = calendar.get(Calendar.MONTH)+1;	// 2
        int currentQuarter = getCurrentQuarter(m);	// 1
        int tempQuarter = currentQuarter;	// 1

        for(int i = 0 ;i < x ;i++){
            if(i == 0){
                tempQuarter = currentQuarter - 1;
            }else{
                tempQuarter = tempQuarter - 1;
            }
            //年度减一
            if(tempQuarter <= 0){
                tempYear -= 1;
                tempQuarter = 4;
            }
        }

        String dateTime = tempYear+""+getQuarterStartDate(tempQuarter);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        System.out.println(dateTime);

        try{
            return sdf.parse(dateTime);
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
   
    /**
     * 返回当前季度
     * 
     * @param nowDate
     * @return
     */
    public static int getSeason(Date nowDate) {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        int m = calendar.get(Calendar.MONTH)+1;
        return getCurrentQuarter(m);
    }

    /**
     * 获得当前季度
     * @param m
     * @return
     */
    public static int getCurrentQuarter(int m){
        if(m>= 1 && m <=3){
            return 1;
        }else if(m>= 4 && m <=6){
            return 2;
        }else if(m>= 7 && m <=9){
            return 3;
        }else if(m>= 10 && m <=12){
            return 4;
        }
        return  -1;
    }

    /**
     * 获得季度的开始日期
     * @param q
     * @return
     */
    public static String getQuarterStartDate(int q){
        if(q == 1){
            return "0101";
        }else if(q == 2){
            return "0401";
        }else if(q == 3){
            return "0701";
        }else if(q == 4){
            return "1001";
        }
        return  "";
    }
}
