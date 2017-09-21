package kr.anima.xd.s.calendartest;


import org.joda.time.JodaTimePermission;

import java.util.Calendar;

/**
 * Created by alfo6-10 on 9/21/2017.
 */

public class OneDayData {
    Calendar calendar;
    String msg="";
    JodaTimePermission permission;

    public OneDayData() {
        calendar=Calendar.getInstance();
    }

    public void setDay(int year, int month, int date){
        calendar=Calendar.getInstance();
        calendar.set(year, month, date);
    }

    public void setDay(Calendar calendar){
        this.calendar= (Calendar) calendar.clone();
    }

    public Calendar getDay(){
        return calendar;
    }

    public void setMsg(String msg){
        this.msg=msg;
    }

    public String getMsg(){
        return msg;
    }
}
