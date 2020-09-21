package com.gmail.harshkumar093;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;



class harshCLASS{
    TextView tv[] = new TextView[18];
    RelativeLayout layoutForCalculations;
    RelativeLayout.LayoutParams layoutParams[] = new RelativeLayout.LayoutParams[18];
    Context harshCLASSctx ;

    double NumberOne,NumberTwo;
    TextView Zero,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Add,Sub,Div,Mul;

    void setNormalCalculatorViews(){
        Zero = new TextView(harshCLASSctx);
        Zero.setText("0");
    }
    harshCLASS(Context ctx){
        harshCLASSctx = ctx;
        for(int i=0;i<18;i++) {
            tv[i] = new TextView(ctx);
            layoutParams[i] = new RelativeLayout.LayoutParams
                    (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        }
        setNormalCalculatorViews();
        setAttributesOfviews();
    }
    void setAttributesOfviews(){
        tv[0].setText("Basic\n Calculator \n");
        tv[1].setText("Simple\n   Interest   \n");
        tv[2].setText("Compound\n  Interest  \n");
        tv[3].setText("Higest\n  Common  \nFactor");
        tv[4].setText("Lowest\nCommon\n   Multiple   ");
        tv[5].setText("Height\nAnd\n   Distance   ");
        tv[6].setText("Infix\nTo\n     Postfix     ");
        tv[7].setText("Age\n    Today    \n");
        tv[8].setText("Number\nSystem\n Conversion ");
        tv[9].setText("Temprature\nConversion\n");
        tv[10].setText("Angle\nMeasure\nConversion");
        tv[11].setText("Binary\nNumber\nCalculations");
        tv[12].setText("Height\nFeet to CM\nCM to Feet");
        for(int i=0;i<18;i++) {
            tv[i].setTextSize(15);
            tv[i].setPadding(10, 30, 10, 30);
            tv[i].setBackgroundResource(R.color.buttonColor);
            tv[i].setTextColor(Color.parseColor("#FFFFFF"));
            tv[i].setGravity(1);
        }
        for(int i=0;i<3;i++) {
            layoutParams[i].leftMargin = 100+(300*i);
            layoutParams[i].topMargin = 100;
        }
        for(int i=3;i<6;i++){
            layoutParams[i].leftMargin = 100+(300*(i-3));
            layoutParams[i].topMargin=400;
        }
        for(int i=6;i<9;i++){
            layoutParams[i].leftMargin = 100+(300*(i-6));
            layoutParams[i].topMargin=700;
        }
        for(int i=9;i<12;i++){
            layoutParams[i].leftMargin = 100+(300*(i-9));
            layoutParams[i].topMargin=1000;
        }
        for(int i=12;i<15;i++){
            layoutParams[i].leftMargin = 100+(300*(i-12));
            layoutParams[i].topMargin=1300;
        }
        setOnclickForAllViews();
    }
    void setOnclickForAllViews(){
        tv[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutForCalculations.removeAllViews();
                layoutForCalculations.addView(Zero);
            }
        });
    }
    void showAllViewsOnCreate(){
        for(int i=0;i<13;i++) {
            layoutForCalculations.addView(tv[i], layoutParams[i]);
        }
    }
}


public class Main4Activity extends AppCompatActivity {
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ctx = getApplicationContext();
        harshCLASS object = new harshCLASS(ctx);
        object.layoutForCalculations = (RelativeLayout) findViewById(R.id.relativelayoutforcalculations);
        object.showAllViewsOnCreate();


    }
}
