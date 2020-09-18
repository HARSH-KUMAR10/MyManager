package com.gmail.harshkumar093;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

class ControlViews{
    /*
    ALl the views
     */
    TextView Name,DateNow,TimeNow;
    EditText EnterTask;
    Button Completed,Back,AddTask;
    RelativeLayout myLayOutForToDo;
    Context classctx;
    TaskListItem TaskArrayList[] = new TaskListItem[30];
    int currentItemNumber =0;
    /*
    Task List save
     */
    class TaskListItem {
        Button done, delete;
        TextView TaskList;
        TaskListItem(){
            done = new Button(classctx);
            delete = new Button(classctx);
            TaskList = new TextView(classctx);
            done.setText("O");
            done.setTextSize(15);
            done.setBackgroundResource(R.color.lightgreen);
            done.setTextColor(Color.parseColor("#ffffff"));
            delete.setText("X");
            delete.setTextSize(15);
            delete.setBackgroundResource(R.color.red);
            delete.setTextColor(Color.parseColor("#ffffff"));
            TaskList.setText("hello");
            TaskList.setTextSize(20);
            TaskList.setBackgroundResource(R.color.buttonColor);
        }
    }
    ControlViews(Context ctx){
        classctx = ctx;
        /*
        All time is controlled by HarshTimer
         */
        /*
        View Object initialization
         */
        HarshTime obj = new HarshTime();
        Name = new TextView(ctx);
        DateNow = new TextView(ctx);
        TimeNow = new TextView(ctx);
        Completed = new Button(ctx);
        Back = new Button(ctx);
        EnterTask =new  EditText(ctx);
        AddTask = new Button(ctx);
        for(int i=0;i<20;i++){
            TaskArrayList[i] = new TaskListItem();
        }
        /*
        setting attribute values of all the Views
         */
        //Name TextView --> Heading of the page
        Name.setText("TO DO LIST");
        Name.setTextSize(30);
        Name.setTextColor(Color.parseColor("#22ff22"));
        //DateNow TextView --> displays current date
        DateNow.setText(obj.harshGetCurrentDate());
        DateNow.setTextSize(20);
        DateNow.setTextColor(Color.parseColor("#000000"));
        //TimeNow TextView --> displays current time
        TimeNow.setText(obj.harshGetCurrentTime());
        TimeNow.setTextSize(20);
        TimeNow.setTextColor(Color.parseColor("#000000"));
        //Completed Button --> shows the completed tasks
        Completed.setText("Completed");
        Completed.setBackgroundResource(R.color.lightgreen);
        Completed.setTextColor(Color.parseColor("#ffffff"));
        //Back Button --> gets you back to the main task page
        Back.setText("Done");
        Back.setTextColor(Color.parseColor("#22ff22"));
        Back.setTextColor(Color.parseColor("#ffffff"));
        //EnterTask EditText --> To take the task from the user
        EnterTask.setHint("       ** Enter Task **");
        EnterTask.setTextSize(20);
        EnterTask.setWidth(600);
        EnterTask.setBackgroundResource(R.color.colorAccent);
        //AddTask Button --> to add task to the list
        AddTask.setText("add");
        AddTask.setBackgroundResource(R.color.white);
        AddTask.setTextColor(Color.parseColor("#22ff22"));
    }
    void showAllViews(){
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
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams1.leftMargin=30;
        layoutParams1.topMargin=50;
        layoutParams2.topMargin=50;
        layoutParams2.leftMargin=750;
        layoutParams3.topMargin=200;
        layoutParams3.leftMargin=100;
        layoutParams4.leftMargin=700;
        layoutParams4.topMargin=200;
        layoutParams5.topMargin=1700;
        layoutParams5.leftMargin=70;
        layoutParams6.leftMargin=730;
        layoutParams6.topMargin=1700;
        myLayOutForToDo.addView(Name,layoutParams1);
        myLayOutForToDo.addView(Completed,layoutParams2);
        myLayOutForToDo.addView(DateNow,layoutParams3);
        myLayOutForToDo.addView(TimeNow,layoutParams4);
        myLayOutForToDo.addView(EnterTask,layoutParams5);
        myLayOutForToDo.addView(AddTask,layoutParams6);
    }
    void RemoveAllTask(){
        for(int i=0;i<currentItemNumber;i++){
            myLayOutForToDo.removeView(TaskArrayList[i].TaskList);
            myLayOutForToDo.removeView(TaskArrayList[i].done);
            myLayOutForToDo.removeView(TaskArrayList[i].delete);
        }
    }
    void ShowAllTask(){
        RelativeLayout.LayoutParams layoutParams[] = new RelativeLayout.LayoutParams[60];
        int ItemNumber=0;
        for(int i=0;i<currentItemNumber*3;i+=3){
            layoutParams[i] = new RelativeLayout.LayoutParams
                    (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams[i+1] = new RelativeLayout.LayoutParams
                    (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams[i+2] = new RelativeLayout.LayoutParams
                    (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams[i].topMargin=300+(50*i);
            layoutParams[i].leftMargin=50;
            layoutParams[i+1].topMargin=320+(50*i);
            layoutParams[i+1].leftMargin=350;
            layoutParams[i+2].topMargin=300+(50*i);
            layoutParams[i+2].leftMargin=800;
            myLayOutForToDo.addView(TaskArrayList[ItemNumber].TaskList,layoutParams[i+1]);
            myLayOutForToDo.addView(TaskArrayList[ItemNumber].done,layoutParams[i]);
            myLayOutForToDo.addView(TaskArrayList[ItemNumber].delete,layoutParams[i+2]);
            ItemNumber++;
            if(ItemNumber>currentItemNumber){
                break;
            }
        }
    }
}


public class Main3Activity extends AppCompatActivity {
    Context ctx;
    ControlViews object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ctx = getApplication();
        object = new ControlViews(ctx);
        object.myLayOutForToDo = (RelativeLayout) findViewById(R.id.ToDoListLayoutXML);
        object.showAllViews();
        object.AddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.RemoveAllTask();
                String task = object.EnterTask.getText().toString();
                object.TaskArrayList[object.currentItemNumber++].TaskList.setText(task);
                object.ShowAllTask();
                object.EnterTask.setText("");
            }
        });
    }
}
