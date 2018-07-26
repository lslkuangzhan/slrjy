package top.slrjy.edu.Util;

import top.slrjy.edu.Config.ServiceException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ Author : Luc .
 * Date :  Created in  14:29.   2018/7/24.
 * 功能 :  对日期操作的公共方法
 *         获取 yyyy-MM-dd 格式的日期   getDate(Calendar calendar)
 *         获取日期间隔                 calculateDifferDays(String date1,String date2)
 *         日期转星期                   dateToWeek(String date)
 */
public class DateUtil {
        public static String getDate(Calendar calendar){
            Date date = calendar.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(date);
        }

        public static boolean checkDateFormat(String date,String pattern){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            try {
                simpleDateFormat.parse(date);
            } catch (ParseException e) {
                return false;
            }
            return true;
        }

        public static boolean checkDateFormat(String date){
            return checkDateFormat(date,"yyyy-MM-dd");
        }

        public static Calendar stringToCalendar(String dateString){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = simpleDateFormat.parse(dateString);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return calendar;
            } catch (ParseException e) {
                throw new ServiceException("日期格式不正确");
            }

        }

        public static int calculateDifferDays(String date1,String date2){
            if(!checkDateFormat(date1)||!checkDateFormat(date2)){
                throw new ServiceException("日期格式不正确");
            }
            Calendar calendar1 = stringToCalendar(date1);
            Calendar calendar2 = stringToCalendar(date2);

            int betweenDays = (int)((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / (1000 * 60 * 60 *24));

            return betweenDays;
        }

        public static String getCurrentDateString(){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(date);
        }
    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
        public static void main(String[] args) {
            System.out.println(calculateDifferDays("2018-04-05","2018-04-08"));
            System.out.println(checkDateFormat("2018-04-05"));
        }


}
