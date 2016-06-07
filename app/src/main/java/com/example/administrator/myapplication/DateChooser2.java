package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/6/7.
 */
public class DateChooser2 extends Activity {
    CalendarView cv;
    DatePicker dp;
    Bundle b;
    int y;
    int m;
    int d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datechooser2);
        b=new Bundle();
        //cv = (CalendarView) findViewById(R.id.calendarView);
        dp= (DatePicker) findViewById(R.id.datepicker);
        Calendar c=Calendar.getInstance();
        y=c.get(Calendar.YEAR);
        m=c.get(Calendar.MONTH);
        d=c.get(Calendar.DAY_OF_MONTH);
        dp.init(y, m, d, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                b.putInt("year", year);
                b.putInt("month", monthOfYear);
                b.putInt("date", dayOfMonth);

            }
        });

//        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                y = year;
//                m = month;
//                d = dayOfMonth;
//            }
//        });


    }

    public void backedit(View view) {
        Intent i = new Intent(this, DateChooser.class);
        i.putExtra("data",b);
        startActivity(i);
    }
}
