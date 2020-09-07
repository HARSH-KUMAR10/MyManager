package com.gmail.harshkumar093;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

class HarshTime{
    int hourNow,minuteNow,secondNow,dateNow,monthNow,yearNow,dayofweeknum;
    String AmOrPm;
    HarshTime(){
        Date obj = new Date();
        hourNow = obj.getHours();
        minuteNow = obj.getMinutes();
        secondNow = obj.getSeconds();
        dateNow = obj.getDate();
        monthNow = obj.getMonth();
        yearNow = obj.getYear();
        dayofweeknum = obj.getDay();
        checkAmOrPm();
    }
    void checkAmOrPm(){
        if(hourNow>12){
            hourNow-=12;
            AmOrPm="PM";
        }else{
            AmOrPm="AM";
        }
    }
    String harshGetCurrentTime(){
        String hourNowString=""+hourNow,minuteNowString=""+minuteNow;
        if(hourNow<10){
            hourNowString = "0"+hourNow;
        }
        if(minuteNow<10){
            minuteNowString ="0"+minuteNow;
        }
        return hourNowString+":"+minuteNowString+" "+AmOrPm;
    }
    String harshGetCurrentDate(){
        String dateNowString,monthNowString,yearNowString;
        if(dateNow<10){
            dateNowString="0"+dateNow;
        }else{
            dateNowString=""+dateNow;
        }
        if(monthNow<10){
            monthNowString="0"+monthNow;
        }else{
            monthNowString=""+monthNow;
        }
        yearNowString = ""+(yearNow+1900);
        return dateNowString+"/"+monthNowString+"/"+yearNowString;
    }
    String harshGetCurrentDay(){
        switch (dayofweeknum){
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
        }
        return "";
    }
}

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.HarshTime);
        HarshTime obj = new HarshTime();
        String HarshTimeNow = obj.harshGetCurrentTime();
        String HarshDateNow = obj.harshGetCurrentDate();
        String HarshDayNow = obj.harshGetCurrentDay();
        tv1.setText(HarshTimeNow+"\t\t\t"+HarshDateNow+"\n"+HarshDayNow);
    }
}
