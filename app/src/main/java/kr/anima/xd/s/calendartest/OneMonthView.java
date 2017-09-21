package kr.anima.xd.s.calendartest;

import android.content.Context;

import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by alfo6-10 on 9/21/2017.
 */

public class OneMonthView extends LinearLayout implements View.OnClickListener{

    ArrayList<OneDayView> oneDayViews;
    ArrayList<LinearLayout> weeks;

    private int mYear;
    private int mMonth;
    private Calendar calendar;
    private Context mContext;

    public OneMonthView(Context context) {
        super(context);
        this.mContext=context;
        init(context);
    }

    public OneMonthView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        init(context);
    }

    public OneMonthView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        init(context);
    }

    private void init(Context context){

        calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis()); // 디바이스 시간으로 맞춤

        oneDayViews=new ArrayList<>(42);
        weeks=new ArrayList<>(6);
        OneDayView dayView;
        LinearLayout LL_Weeks;

        for(int i=0; i<oneDayViews.size(); i++){

            dayView=new OneDayView(context);
            dayView.setOnClickListener(this);
            oneDayViews.add(dayView);

            if (i%7==0){
                LL_Weeks=new LinearLayout(context);
                LL_Weeks.setLayoutParams(new LayoutParams(getWidth(), getHeight()/6));
                LL_Weeks.setOrientation(LinearLayout.HORIZONTAL);
                weeks.add(LL_Weeks);
            }
        }

        makeCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));

//        if (weeks==null){
//            oneDayViews=new ArrayList<>(42);
//            weeks=new ArrayList<>(6);
//            OneDayView dayView;
//            LinearLayout LL_weeks;
//
//            for(int i=0; i<oneDayViews.size(); i++){
//                dayView=new OneDayView(context);
//                dayView.setOnClickListener(this);
//
//                oneDayViews.add(dayView);
//                if (i%7==0) {
//                    LL_weeks=new LinearLayout(context);
//                    LL_weeks.setOrientation(LinearLayout.HORIZONTAL);
//                    weeks.add(LL_weeks);
//                }
//            }
//        }

        if (isInEditMode()){
            Calendar calendar=Calendar.getInstance();
            makeCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
        }
    }

    private void makeCalendar(int year, int month){

        this.mYear=year;
        this.mMonth=month;

        Calendar calendar=Calendar.getInstance();
        calendar.set(year, month, 1);
        calendar.setFirstDayOfWeek(Calendar.MONDAY); // 첫주의 시작요일
        int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK); //1일의 요일
        int maxOfMonth=calendar.getActualMaximum(Calendar.DAY_OF_MONTH); //이 달의 마지막 일수

        calendar.add(Calendar.DAY_OF_MONTH, Calendar.MONDAY-dayOfWeek); // 주의 첫 일로 이동

        int seekDay;
        LinearLayout LL_Week=new LinearLayout(mContext);
        LL_Week.setOrientation(LinearLayout.HORIZONTAL);
        for(int i=0; i<maxOfMonth; i++){
            addView(inflate(mContext, R.layout.item_one_day, LL_Week), getWidth()/7, getHeight());
        }


        // add previous month
//        for(;;){
//            seekDay=calendar.get(Calendar.DAY_OF_WEEK);
//            if (dayOfWeek==seekDay) break;
//
//            OneDayData dailyData=new OneDayData();
//            dailyData.setDay(calendar);
//            dailyDatas.add(dailyData);
//            calendar.add(Calendar.DAY_OF_MONTH, 1); //하루 증가
//        }

        // add current month
//        for(int i=0; i<maxOfMonth; i++){
//            OneDayData dailyData=new OneDayData();
//            dailyData.setDay(calendar);
//            dailyDatas.add(dailyData);
//            calendar.add(Calendar.DAY_OF_MONTH, 1); //하루 증가
//        }

        // add next month
//        for(;;){
//            if (calendar.get(Calendar.DAY_OF_WEEK)!=Calendar.MONDAY){
//                OneDayData dailyData=new OneDayData();
//                dailyData.setDay(calendar);
//                dailyDatas.add(dailyData);
//            }
//            else break;
//            calendar.add(Calendar.DAY_OF_MONTH, 1); //하루 증가
//        }

//        if (dailyDatas.size()==0) return;







    }

    @Override
    public void onClick(View view) {

    }
}
