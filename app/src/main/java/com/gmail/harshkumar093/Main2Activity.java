package com.gmail.harshkumar093;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

class LayOut  {
    RelativeLayout myLayout;
    //boolean alarm;
    boolean Timer,stopwatch;
    //Button alarmBut;
    Button timerBut,stopWatchBut;
    Button timerButOn;
    //Numbers for timer
    NumberPicker HH,MM,SS;
    //TextView for timer
    TextView H,M,S,noTimeEntered;
    LayOut(Context ctx){
        //alarm = false;
        Timer=true;
        stopwatch=false;
        timerBut = new Button(ctx);
        stopWatchBut = new Button(ctx);
        timerButOn = new Button(ctx);
        HH = new NumberPicker(ctx);
        HH.setMaxValue(23);
        HH.setMinValue(0);
        MM = new NumberPicker(ctx);
        MM.setMaxValue(59);
        MM.setMinValue(0);
        SS = new NumberPicker(ctx);
        SS.setMaxValue(59);
        SS.setMinValue(0);
        H=new TextView(ctx);
        M=new TextView(ctx);
        S=new TextView(ctx);
        noTimeEntered=new TextView(ctx);
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
        layoutParams.leftMargin=310;
        layoutParams.topMargin=140;
        final TextView alarmBut = new TextView(ctx);
        alarmBut.setText("Timer");
        alarmBut.setTextSize(15);
        alarmBut.setTextColor(Color.parseColor("#2962ff"));
        alarmBut.setAllCaps(true);
        myLayout.addView(alarmBut,layoutParams);
        showTimerButOn(ctx);
    }
    void showFakeSW(Context ctx){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParams.leftMargin=550;
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

    void showTimerButOn(Context ctx){
        RelativeLayout.LayoutParams layoutParamsTimerButOn = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParamsTimerButOn.topMargin=1500;
        layoutParamsTimerButOn.leftMargin=390;
        timerButOn.setText("start timer");
        myLayout.addView(timerButOn,layoutParamsTimerButOn);
        showAllTimeAttributes(ctx);
    }
    void showAllTimeAttributes(Context ctx){
        RelativeLayout.LayoutParams layoutParamsHH = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParamsHH.topMargin=500;
        layoutParamsHH.leftMargin=250;
        RelativeLayout.LayoutParams layoutParamsMM = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParamsMM.topMargin=500;
        layoutParamsMM.leftMargin=450;
        RelativeLayout.LayoutParams layoutParamsSS = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParamsSS.topMargin=500;
        layoutParamsSS.leftMargin=650;
        myLayout.addView(HH,layoutParamsHH);
        myLayout.addView(MM,layoutParamsMM);
        myLayout.addView(SS,layoutParamsSS);
    }
    void NoTimeEntered(){
        RelativeLayout.LayoutParams layoutParamsNoTimeEntered = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsNoTimeEntered.topMargin=420;
        layoutParamsNoTimeEntered.leftMargin=300;
        noTimeEntered.setText("Enter time to start");
        noTimeEntered.setTextSize(20);
        noTimeEntered.setTextColor(Color.parseColor("#ff0000"));
        myLayout.addView(noTimeEntered,layoutParamsNoTimeEntered);
    }
    void addingViewForTimer(){
        RelativeLayout.LayoutParams layoutParamsHours = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParamsMin = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParamsSec = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsHours.leftMargin=250;
        layoutParamsHours.topMargin=500;
        H.setTextSize(20);
        H.setTextColor(Color.parseColor("#00ff00"));
        layoutParamsMin.leftMargin=450;
        layoutParamsMin.topMargin=500;
        M.setTextSize(20);
        M.setTextColor(Color.parseColor("#00ff00"));
        layoutParamsSec.leftMargin=650;
        layoutParamsSec.topMargin=500;
        S.setTextSize(20);
        S.setTextColor(Color.parseColor("#00ff00"));
        myLayout.addView(H,layoutParamsHours);
        myLayout.addView(M,layoutParamsMin);
        myLayout.addView(S,layoutParamsSec);
    }
    void showTimeGetReduced(int h,int m,int s){
        H.setText(h+"");
        M.setText(m+"");
        S.setText(s+"");
    }

}
public class Main2Activity extends AppCompatActivity {
    Context ctx;
    LayOut obj;
    int hours,min,sec;
    int i=0;
    Timer timer = new Timer();
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
        obj.timerButOn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                obj.addingViewForTimer();
                hours = obj.HH.getValue();
                min = obj.MM.getValue();
                sec = obj.SS.getValue();
                if(hours==0 && min==0 && sec==0){
                    obj.NoTimeEntered();
                }
                else {
                            new CountDownTimer(1000*(sec+(min*60)+(hours*60*60)), 1000) {
                                public void onTick(long millisUntilFinished) {
                                    obj.showTimeGetReduced(hours,min,sec);
                                    if(sec>0){
                                        sec--;
                                    }else if(sec<=0){
                                        min--;
                                        if(min<0){
                                            hours--;
                                            if(hours<0){
                                                cancel();
                                            }
                                            min=59;
                                        }
                                        sec=59;
                                    }
                                }
                                public void onFinish() {
                                }
                            }.start();
                }
            }
        });
    }
}
