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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
//LayOut class for Timer and stopwatch
class LayOut  {
    RelativeLayout myLayout;

    /*Timer Section*/

    //boolean alarm;
    boolean Timer,stopwatch;
    //Button alarmBut;
    Button timerBut,stopWatchBut;
    Button timerButOn;
    //Numbers for timer
    NumberPicker HH,MM,SS;
    //TextView for timer
    TextView H,M,S,noTimeEntered;
    /*
    constructor to initialize value of above variables
     */
    LayOut(Context ctx){
        /*Timer Part*/
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
        /*Timer Part*/
        /*StopWatch part*/
        StopWatchHourTV = new TextView(ctx);
        StopWatchMinTV = new TextView(ctx);
        StopWatchSecTV = new TextView(ctx);
        StopWatchSecHalfTV = new TextView(ctx);
        StopWatchStartBut = new Button(ctx);
        StopWatchStopBut = new Button(ctx);
        StopWatchLapBut = new Button(ctx);
        horizontalLine = new View(ctx);
        for(int i=0;i<60;i++){
            arr[i] = new TextView(ctx);
            layoutParams[i] = new RelativeLayout.LayoutParams
                    (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        }
        /*StopWatch part*/
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
    //Function is used to display timer button on the layout
    void showTimerBut(Context ctx){
        RelativeLayout.LayoutParams layoutParamsTwo = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParamsTwo.leftMargin=250;
        layoutParamsTwo.topMargin=100;
        timerBut.setText("Timer");
        timerBut.setBackgroundResource(R.drawable.gradient_1);
        myLayout.addView(timerBut,layoutParamsTwo);
        ShowStopWatchAllAccessories();
    }
    //Function is used to display timer button on the layout
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
    //Function is used to display textview of Timer when we are inside the timer
    void showFakeTimer(Context ctx){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParams.leftMargin=310;
        layoutParams.topMargin=140;
        final TextView timerButTV = new TextView(ctx);
        timerButTV.setText("Timer");
        timerButTV.setTextSize(15);
        timerButTV.setTextColor(Color.parseColor("#2962ff"));
        timerButTV.setAllCaps(true);
        myLayout.addView(timerButTV,layoutParams);
        showTimerButOn(ctx);
    }
    //Function is used to display textview of StopWatch when we are inside the stopwatch
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
    //Used to add View(buttons) to the layout
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
    //Start Timer button in Timer layout
    void showTimerButOn(Context ctx){
        RelativeLayout.LayoutParams layoutParamsTimerButOn = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams. WRAP_CONTENT,RelativeLayout.LayoutParams. WRAP_CONTENT);
        layoutParamsTimerButOn.topMargin=1500;
        layoutParamsTimerButOn.leftMargin=390;
        timerButOn.setText("start timer");
        myLayout.addView(timerButOn,layoutParamsTimerButOn);
        showAllTimeAttributes(ctx);
    }
    //Shows the number pickers the start button for the timer layout
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
    //if no time is entered and user put start timer a message is printed saying enter timer
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
    //adds the hour,min,sec of timer to the layout which changes every second
    void addingViewForTimer(){
        RelativeLayout.LayoutParams layoutParamsHours = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParamsMin = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParamsSec = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsHours.leftMargin=320;
        layoutParamsHours.topMargin=720;
        H.setTextSize(30);
        H.setTextColor(Color.parseColor("#00ff00"));
        layoutParamsMin.leftMargin=520;
        layoutParamsMin.topMargin=720;
        M.setTextSize(30);
        M.setTextColor(Color.parseColor("#00ff00"));
        layoutParamsSec.leftMargin=720;
        layoutParamsSec.topMargin=720;
        S.setTextSize(30);
        S.setTextColor(Color.parseColor("#00ff00"));
        myLayout.addView(H,layoutParamsHours);
        myLayout.addView(M,layoutParamsMin);
        myLayout.addView(S,layoutParamsSec);
    }
    //This function changes the value of hour,min,sec every sec to h,m,s
    void showTimeGetReduced(int h,int m,int s){
        H.setText(h+"   -");
        M.setText(m+"   -");
        S.setText(s+"");
    }
    //When timer start but is pressed the number picker and start but disappear from this function
    void removeOtherTimerView(){
        myLayout.removeView(HH);
        myLayout.removeView(MM);
        myLayout.removeView(SS);
        myLayout.removeView(timerButOn);
    }
    //When Timer gets over number picker and start but is again added to the review from this function
    void addOtherTimerViewBack(){
        myLayout.addView(HH);
        myLayout.addView(MM);
        myLayout.addView(SS);
        myLayout.addView(timerButOn);
        myLayout.removeView(H);
        myLayout.removeView(M);
        myLayout.removeView(S);
    }

    /*Timer Section*/

    /*StopWatch Section*/

    TextView StopWatchHourTV,StopWatchMinTV,StopWatchSecTV,StopWatchSecHalfTV;
    View horizontalLine;
    Button StopWatchStartBut,StopWatchStopBut,StopWatchLapBut;
    RelativeLayout.LayoutParams layoutParams[] = new RelativeLayout.LayoutParams[120];
    TextView arr[] = new TextView[120];
    int arrItems=0,layoutParamsItem=0,Items=0;
    void setTextValues(){
        StopWatchStartBut.setText("START");
        StopWatchLapBut.setText("LAP");
        StopWatchStopBut.setText("STOP");
        StopWatchHourTV.setText("0   :");
        StopWatchMinTV.setText("0   :");
        StopWatchSecTV.setText("0   :");
        StopWatchSecHalfTV.setText("0");
    }
    void ShowStopWatchAllAccessories(){
        setTextValues();
        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams1.leftMargin=220;
        layoutParams1.topMargin=420;
        StopWatchHourTV.setTextSize(30);
        layoutParams2.leftMargin=420;
        layoutParams2.topMargin=420;
        StopWatchMinTV.setTextSize(30);
        layoutParams3.leftMargin=620;
        layoutParams3.topMargin=420;
        StopWatchSecTV.setTextSize(30);
        layoutParams4.leftMargin=420;
        layoutParams4.topMargin=620;
        StopWatchSecHalfTV.setTextSize(30);
        layoutParams5.leftMargin=820;
        layoutParams5.topMargin=420;
        myLayout.addView(StopWatchHourTV,layoutParams1);
        myLayout.addView(StopWatchMinTV,layoutParams2);
        myLayout.addView(StopWatchSecTV,layoutParams3);
        myLayout.addView(StopWatchSecHalfTV,layoutParams5);
        myLayout.addView(StopWatchStartBut,layoutParams4);
    }
    void StartStopWatch(){
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams5.leftMargin=270;
        layoutParams5.topMargin=620;
        layoutParams6.leftMargin=570;
        layoutParams6.topMargin=620;
        myLayout.removeView(StopWatchStartBut);
        myLayout.addView(StopWatchLapBut,layoutParams5);
        myLayout.addView(StopWatchStopBut,layoutParams6);
    }
    void removeStopWatchTime(){
        myLayout.removeView(StopWatchHourTV);
        myLayout.removeView(StopWatchMinTV);
        myLayout.removeView(StopWatchSecTV);
    }
    void ShowStopWatchTime(int h,int m,int s,int sh){
        removeStopWatchTime();
        StopWatchHourTV.setText(h+"   :");
        StopWatchMinTV.setText(m+"   :");
        StopWatchSecTV.setText(s+"   :");
        StopWatchSecHalfTV.setText(sh+"");
        myLayout.addView(StopWatchHourTV);
        myLayout.addView(StopWatchMinTV);
        myLayout.addView(StopWatchSecTV);
    }
    void SetStopWatchLap(int h,int m,int s,int sh){
        arr[arrItems].setText(h+" :");
        layoutParams[layoutParamsItem] = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams[layoutParamsItem].topMargin=850+(50*Items);
        layoutParams[layoutParamsItem].leftMargin=440;
        myLayout.addView(arr[arrItems++],layoutParams[layoutParamsItem++]);
        arr[arrItems].setText(m+" :");
        layoutParams[layoutParamsItem] = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams[layoutParamsItem].topMargin=850+(50*Items);
        layoutParams[layoutParamsItem].leftMargin=520;
        myLayout.addView(arr[arrItems++],layoutParams[layoutParamsItem++]);
        arr[arrItems].setText(s+" :");
        layoutParams[layoutParamsItem] = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams[layoutParamsItem].topMargin=850+(50*Items);
        layoutParams[layoutParamsItem].leftMargin=600;
        myLayout.addView(arr[arrItems++],layoutParams[layoutParamsItem++]);
        arr[arrItems].setText(sh+"");
        layoutParams[layoutParamsItem] = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams[layoutParamsItem].topMargin=850+(50*Items);
        layoutParams[layoutParamsItem].leftMargin=680;
        myLayout.addView(arr[arrItems++],layoutParams[layoutParamsItem++]);
        Items++;
    }
    void StopStopWatch(){
        myLayout.removeView(StopWatchHourTV);
        myLayout.removeView(StopWatchMinTV);
        myLayout.removeView(StopWatchSecTV);
        myLayout.removeView(StopWatchSecHalfTV);
        myLayout.removeView(StopWatchStopBut);
        myLayout.removeView(StopWatchLapBut);
        setTextValues();
        ShowStopWatchAllAccessories();
    }
    void removeLapTimings(){
        for(int i=0;i<arrItems;i++){
            myLayout.removeView(arr[i]);
        }
        arrItems=0;
        layoutParamsItem=0;
        Items=0;
    }
    /*StopWatch Section*/
}
//Main Class
public class Main2Activity extends AppCompatActivity {
    //Context object to take application current context for
    Context ctx;
    //LayOut user defined class created by Harsh for Timer LayOut Object obj is created
    LayOut obj;
    //variables to store the value from the number picker
    int hours,min,sec;
    int StopWatchHour=0,StopWatchMin=0,StopWatchSec=0,StopWatchSecHalf=0;
    /*
    to check is "Timer values not entered" Text view is on screen
    and the timer textview are visible on the layout or not
     */
    boolean isTimerPickerVisible = false,isNoTimerEnteredVisible=false,stop=false,lap=false;
    @Override
    //OnCreate method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //application context given to the ctx
        ctx=getApplicationContext();
        //LayOut object initialized
        obj = new LayOut(ctx);
        //myLayout RelativeLayout Variable is intantiated
        obj.myLayout = (RelativeLayout) findViewById(R.id.HarshLayout);
        //Buttons are printed as per settings
        obj.showAllButton(ctx);
        //if Timer button is clicked
        obj.timerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.myLayout.removeAllViews();
                obj.Timer=true;
                obj.stopwatch=false;
                obj.showAllButton(ctx);
            }
        });
        //if Stopwatch button is clicked
        obj.stopWatchBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.myLayout.removeAllViews();
                obj.Timer=false;
                obj.stopwatch=true;
                obj.showAllButton(ctx);
            }
        });
        //if Start timer button is clicked in Timer section
        obj.timerButOn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!isTimerPickerVisible) {
                    obj.addingViewForTimer();
                    isTimerPickerVisible=true;
                }
                hours = obj.HH.getValue();
                min = obj.MM.getValue();
                sec = obj.SS.getValue();
                if(hours==0 && min==0 && sec==0){
                    if(!isNoTimerEnteredVisible) {
                        obj.NoTimeEntered();
                        isNoTimerEnteredVisible=true;
                        obj.myLayout.removeView(obj.H);
                        obj.myLayout.removeView(obj.M);
                        obj.myLayout.removeView(obj.S);
                        isTimerPickerVisible=false;
                    }
                }
                else {
                    obj.removeOtherTimerView();
                    isTimerPickerVisible=false;
                    obj.myLayout.removeView(obj.noTimeEntered);
                    isNoTimerEnteredVisible=false;
                            //Count Down is handled through this function
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
                                //This method is executed when CountDownTimer Get over
                                public void onFinish() {
                                    obj.addOtherTimerViewBack();
                                    hours=0;
                                    min=0;
                                    sec=0;
                                }
                            }.start();
                }
            }
        });
        obj.StopWatchStartBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.StartStopWatch();
                new CountDownTimer(1000*60*60, 100) {
                    public void onTick(long millisUntilFinished) {
                        if(lap){
                            obj.SetStopWatchLap(StopWatchHour,StopWatchMin,StopWatchSec,StopWatchSecHalf);
                            lap=false;
                        }
                        StopWatchSecHalf++;
                        if(stop){
                            cancel();
                            StopWatchSecHalf=0;
                            StopWatchSec=0;
                            StopWatchMin=0;
                            StopWatchHour=0;
                            obj.StopStopWatch();
                            obj.removeLapTimings();
                            stop=false;
                        }
                        if(StopWatchSecHalf>9){
                            StopWatchSec++;
                            if(StopWatchSec>59){
                                StopWatchMin++;
                                if(StopWatchMin>59){
                                    StopWatchHour++;
                                    StopWatchMin=0;
                                }
                                StopWatchSec=0;
                            }
                            StopWatchSecHalf=0;
                        }
                        obj.ShowStopWatchTime(StopWatchHour,StopWatchMin,StopWatchSec,StopWatchSecHalf);
                    }
                    //This method is executed when CountDownTimer Get over
                    public void onFinish() {
                        StopWatchSecHalf=0;
                        StopWatchSec=0;
                        StopWatchMin=0;
                        StopWatchHour=0;
                        obj.StopStopWatch();
                    }
                }.start();
            }
        });
        obj.StopWatchStopBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop=true;
            }
        });
        obj.StopWatchLapBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lap=true;
            }
        });
    }
}
