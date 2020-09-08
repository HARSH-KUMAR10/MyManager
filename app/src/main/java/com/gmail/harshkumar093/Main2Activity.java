package com.gmail.harshkumar093;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

class LayOut  {
    RelativeLayout myLayout;
    //boolean alarm;
    boolean Timer,stopwatch;
    //Button alarmBut;
    Button timerBut,stopWatchBut;
    LayOut(Context ctx){
        //alarm = false;
        Timer=false;
        stopwatch=true;
        timerBut = new Button(ctx);
        stopWatchBut = new Button(ctx);
    }
    /*void showAlarmBut(Context ctx){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParams.leftMargin=50;
        layoutParams.topMargin=100;
        alarmBut = new Button(ctx);
        alarmBut.setText("Alarm");
        alarmBut.setBackgroundResource(R.drawable.gradient_1);
        myLayout.addView(alarmBut,layoutParams);
    }*/
    void showTimerBut(Context ctx){
        RelativeLayout.LayoutParams layoutParamsTwo = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParamsTwo.leftMargin=250;
        layoutParamsTwo.topMargin=100;
        timerBut.setText("Timer");
        timerBut.setBackgroundResource(R.drawable.gradient_1);
        myLayout.addView(timerBut,layoutParamsTwo);
    }
    void showSWBut(Context ctx){
        RelativeLayout.LayoutParams layoutParamsThree = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParamsThree.leftMargin=550;
        layoutParamsThree.topMargin=100;
        stopWatchBut.setText("StopWatch");
        stopWatchBut.setBackgroundResource(R.drawable.gradient_1);
        stopWatchBut.setPadding(20,0,20,0);
        myLayout.addView(stopWatchBut,layoutParamsThree);
    }
    /*void showFakeAlarm(Context ctx){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParams.leftMargin=100;
        layoutParams.topMargin=140;
        final TextView alarmBut = new TextView(ctx);
        alarmBut.setText("Alarm");
        alarmBut.setTextSize(15);
        alarmBut.setTextColor(Color.parseColor("#2962ff"));
        alarmBut.setAllCaps(true);
        myLayout.addView(alarmBut,layoutParams);
    }*/
    void showFakeTimer(Context ctx){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParams.leftMargin=380;
        layoutParams.topMargin=140;
        final TextView alarmBut = new TextView(ctx);
        alarmBut.setText("Timer");
        alarmBut.setTextSize(15);
        alarmBut.setTextColor(Color.parseColor("#2962ff"));
        alarmBut.setAllCaps(true);
        myLayout.addView(alarmBut,layoutParams);
    }
    void showFakeSW(Context ctx){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParams.leftMargin=590;
        layoutParams.topMargin=140;
        final TextView alarmBut = new TextView(ctx);
        alarmBut.setText("StopWatch");
        alarmBut.setTextSize(15);
        alarmBut.setTextColor(Color.parseColor("#2962ff"));
        alarmBut.setAllCaps(true);
        myLayout.addView(alarmBut,layoutParams);
    }

    void showAllButton(Context ctx){
        /*if(alarm){
            showTimerBut(ctx);
            showSWBut(ctx);
            showFakeAlarm(ctx);
        }*/
        if(Timer){
            //showAlarmBut(ctx);
            showSWBut(ctx);
            showFakeTimer(ctx);
        }
        if(stopwatch){
            //showAlarmBut(ctx);
            showTimerBut(ctx);
            showFakeSW(ctx);
        }
    }
}
public class Main2Activity extends AppCompatActivity {
    Context ctx;
    LayOut obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ctx=getApplicationContext();
        obj = new LayOut(ctx);
        obj.myLayout = (RelativeLayout) findViewById(R.id.HarshLayout);
        obj.showAllButton(ctx);
        obj.timerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.myLayout.removeAllViews();
                obj.Timer=true;
                obj.stopwatch=false;
                obj.showAllButton(ctx);
            }
        });
        obj.stopWatchBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.myLayout.removeAllViews();
                obj.Timer=false;
                obj.stopwatch=true;
                obj.showAllButton(ctx);
            }
        });
    }
}
