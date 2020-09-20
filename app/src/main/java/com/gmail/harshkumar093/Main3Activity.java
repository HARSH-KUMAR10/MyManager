package com.gmail.harshkumar093;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class ControlViews{
    /*
    ALl the views
     */
    TextView Name,DateNow,TimeNow,CompletedTask;
    EditText EnterTask;
    Button Completed,Back,AddTask;
    RelativeLayout myLayOutForToDo;
    Context classctx;
    TaskListItem TaskArrayList[] = new TaskListItem[100];
    int DeletedIndexes[] = new int[100];
    int posisitonofdeletedIndexes=0;
    int currentItemNumber =0;
    FileOutputStream fos =null;
    /*
    Task List save
     */
    class TaskListItem {
        TextView done, delete;
        TextView TaskList;
        TaskListItem(){
            done = new TextView(classctx);
            delete = new TextView(classctx);
            TaskList = new TextView(classctx);
            done.setText("O");
            done.setTextSize(20);
            done.setBackgroundResource(R.color.lightgreen);
            done.setTextColor(Color.parseColor("#ffffff"));
            done.setPadding(20,5,20,5);
            delete.setText("X");
            delete.setTextSize(20);
            delete.setBackgroundResource(R.color.red);
            delete.setTextColor(Color.parseColor("#ffffff"));
            delete.setPadding(20,5,20,5);
            TaskList.setText("hello");
            TaskList.setTextSize(15);
            TaskList.setAllCaps(true);
            TaskList.setBackgroundResource(R.color.buttonColor);
            TaskList.setPadding(20,5,20,5);
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
        CompletedTask = new TextView(ctx);
        Back = new Button(ctx);
        EnterTask =new  EditText(ctx);
        AddTask = new Button(ctx);
        for(int i=0;i<100;i++){
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

        for(int i=0;i<100;i++){
            DeletedIndexes[i]=-1;
        }
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
        layoutParams1.topMargin=20;
        layoutParams2.topMargin=20;
        layoutParams2.leftMargin=750;
        layoutParams3.topMargin=170;
        layoutParams3.leftMargin=100;
        layoutParams4.leftMargin=700;
        layoutParams4.topMargin=170;
        layoutParams5.topMargin=1550;
        layoutParams5.leftMargin=70;
        layoutParams6.leftMargin=730;
        layoutParams6.topMargin=1550;
        myLayOutForToDo.addView(Name,layoutParams1);
        myLayOutForToDo.addView(Completed,layoutParams2);
        myLayOutForToDo.addView(DateNow,layoutParams3);
        myLayOutForToDo.addView(TimeNow,layoutParams4);
        myLayOutForToDo.addView(EnterTask,layoutParams5);
        myLayOutForToDo.addView(AddTask,layoutParams6);
        setOnClickForDone();
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
        int layOutincrement=0;
        for(int i=0;i<currentItemNumber*3;i+=3){
            layoutParams[i] = new RelativeLayout.LayoutParams
                    (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams[i+1] = new RelativeLayout.LayoutParams
                    (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams[i+2] = new RelativeLayout.LayoutParams
                    (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams[i].topMargin=300+(40*layOutincrement);
            layoutParams[i].leftMargin=50;
            layoutParams[i+1].rightMargin=150;
            layoutParams[i+1].topMargin=300+(40*layOutincrement);
            layoutParams[i+1].leftMargin=170;
            layoutParams[i+2].topMargin=300+(40*layOutincrement);
            layoutParams[i+2].leftMargin=950;
            boolean toprint=true;
            for(int j=0;j<posisitonofdeletedIndexes;j++){
                if(ItemNumber==DeletedIndexes[j]){
                    toprint=false;
                }
            }
            if(toprint) {
                layOutincrement+=3;
                myLayOutForToDo.addView(TaskArrayList[ItemNumber].TaskList, layoutParams[i + 1]);
                myLayOutForToDo.addView(TaskArrayList[ItemNumber].done, layoutParams[i]);
                myLayOutForToDo.addView(TaskArrayList[ItemNumber].delete, layoutParams[i + 2]);
            }
            ItemNumber++;
            if(ItemNumber>currentItemNumber){
                break;
            }
        }
    }
/*    void removefromlist(int in){
        if(in==(currentItemNumber-1)){
            currentItemNumber--;
        }else {
            for (int i = in; i < currentItemNumber; i++) {
                TaskArrayList[i]=TaskArrayList[i+1];
            }
            currentItemNumber--;
        }
    }*/
    void setOnClickForDone(){
        try {
            fos = classctx.openFileOutput("CompletedTask.txt",Context.MODE_APPEND);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<100;i++){
            final int finalI = i;
            TaskArrayList[i].done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String toSave =TaskArrayList[finalI].TaskList.getText().toString()+"\n";
                        fos.write(toSave.getBytes());
                        Toast.makeText(classctx,"Task added to completed list"+"--",Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    RemoveAllTask();
                    DeletedIndexes[posisitonofdeletedIndexes++] = finalI;
                    ShowAllTask();

                }
            });
            TaskArrayList[i].delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RemoveAllTask();
                    DeletedIndexes[posisitonofdeletedIndexes++] = finalI;
                    ShowAllTask();
                }
            });
        }
    }
}


public class Main3Activity extends AppCompatActivity {
    Context ctx;
    ControlViews object;
    TextView obj ;
    int i=0;
    int index;
    private static final String FILE_NAME = "TaskList.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ctx = getApplication();
        obj = new TextView(ctx);
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
        object.Completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView back,erase;
                back = new TextView(ctx);
                erase = new TextView(ctx);
                back.setText("BACK");
                back.setBackgroundResource(R.color.black);
                back.setTextColor(Color.parseColor("#FFFFFF"));
                back.setPadding(10,10,10,10);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        object.myLayOutForToDo.removeView(object.CompletedTask);
                        object.myLayOutForToDo.removeView(back);
                        object.myLayOutForToDo.removeView(erase);
                        object.myLayOutForToDo.addView(object.Completed);
                        object.ShowAllTask();
                    }
                });
                erase.setText("CLEAR");
                erase.setBackgroundResource(R.color.black);
                erase.setTextColor(Color.parseColor("#FFFFFF"));
                erase.setPadding(10,10,10,10);
                erase.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        object.CompletedTask.setText("");
                        FileOutputStream fos = null;
                        try {
                            fos = openFileOutput("CompletedTask.txt",MODE_PRIVATE);
                            fos.write("".getBytes());
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                FileInputStream fis = null;
                try {
                    fis = openFileInput("CompletedTask.txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String text="";
                while((text = br.readLine())!=null){
                    sb.append(text).append("\n");
                }
                object.RemoveAllTask();
                object.CompletedTask.setText(sb.toString());
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams
                            (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams7.leftMargin=70;
                    layoutParams7.topMargin=300;
                    layoutParams7.rightMargin=70;
                    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams
                            (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams1.leftMargin=500;
                    layoutParams1.topMargin=50;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams
                            (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams2.leftMargin=500;
                    layoutParams2.topMargin=150;
                    object.myLayOutForToDo.addView(back,layoutParams1);
                    object.myLayOutForToDo.addView(erase,layoutParams2);
                    object.CompletedTask.setTextColor(Color.parseColor("#22FF22"));
                    object.CompletedTask.setTextSize(20);
                    object.CompletedTask.setAllCaps(true);
                object.myLayOutForToDo.addView(object.CompletedTask,layoutParams7);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                object.myLayOutForToDo.removeView(object.Completed);
            }
        });
        /*obj.setText("click me");
        obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             obj.setText("clicked"+(i++)+"times");
            }
        });
        object.myLayOutForToDo.addView(obj);*/

    }

    @Override
    protected void onPause() {
        int index=0;
        FileOutputStream fos=null;
        String storeLine="";
        for(int i=0;i<object.currentItemNumber;i++){
            boolean toAdd = true;
            for(int j=0;j<object.posisitonofdeletedIndexes;j++){
                if(i==object.DeletedIndexes[j]){
                    toAdd=false;
                }
            }
            if(toAdd){
                storeLine+=object.TaskArrayList[i].TaskList.getText().toString()+"\n";
            }
        }
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(storeLine.getBytes());
            Toast.makeText(this,"Task Saved",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this,"FileNotFoundException",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this,"IOException",Toast.LENGTH_LONG).show();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this,"close()",Toast.LENGTH_LONG).show();
                }
            }
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text="";
            while((text = br.readLine())!=null){
                sb.append(text);
                object.TaskArrayList[object.currentItemNumber++].TaskList.setText(sb.toString());
                sb.setLength(0);
            }
            object.RemoveAllTask();
            object.ShowAllTask();
            Toast.makeText(this,"Recovering Tasks",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            FileOutputStream fos = null;
            try {
                fos = openFileOutput(FILE_NAME,MODE_APPEND);
                fos.write("".getBytes());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
            Toast.makeText(this,"File Not Found",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this,"Input Output Exception",Toast.LENGTH_LONG).show();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    Toast.makeText(this,"Input output Ecxeption 2",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }

        super.onResume();
    }
}
