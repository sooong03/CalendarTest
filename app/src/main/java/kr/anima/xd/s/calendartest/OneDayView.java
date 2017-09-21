package kr.anima.xd.s.calendartest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by alfo6-10 on 9/21/2017.
 */

public class OneDayView extends LinearLayout {

    private TextView TV_Date;
    private TextView TV_Msg;
    private ImageView IV_Event_Dot;
    private OneDayData dailyData;

    public OneDayView(Context context) {
        super(context);
        init(context);
    }

    public OneDayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OneDayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        View v=View.inflate(context, R.layout.item_one_day, this);
        TV_Date=v.findViewById(R.id.TV_Date);
        TV_Msg=v.findViewById(R.id.TV_Event_Msg);
        IV_Event_Dot=v.findViewById(R.id.IV_Event_Dot);
        dailyData=new OneDayData();
    }

    public void setDay(OneDayData dailyData){
        this.dailyData=dailyData;
    }

    public void setDay(int year, int month, int date){
        this.dailyData.setDay(year, month, date);
    }

    public void setDay(Calendar calendar){
        this.dailyData.setDay((Calendar) calendar);
    }

    public OneDayData getDay(){
        return dailyData;
    }

    public void setMessage(String message){
        this.dailyData.setMsg(message);
    }

    public String getMessage(){
        return dailyData.getMsg();
    }


}
