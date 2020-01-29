package com.example.admin.sunon_ceiling_fan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstActivity extends AppCompatActivity {

    TextView Length_Text, Width_Text;
    EditText EditLength_Text, EditWidth_Text;
    private static Boolean isExit = false;
    private static Boolean hasTask = false;
    Timer timerExit = new Timer();
    GlobalVariable GlobalVariable = new GlobalVariable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //隱藏標題
        setContentView(R.layout.firstactivity);

        Button Next_Button = (Button) findViewById(R.id.Next_Button);
        Length_Text = (TextView) findViewById(R.id.LengthText);
        Width_Text = (TextView) findViewById(R.id.WidthText);
        EditLength_Text = (EditText) findViewById(R.id.EditLengthText);
        EditWidth_Text = (EditText) findViewById(R.id.EditWidthText);
        Next_Button.setOnClickListener(Next_Button_Listner);
    }

    private Button.OnClickListener Next_Button_Listner = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            if(!(EditLength_Text.getText().toString().matches("")) && !(EditWidth_Text.getText().toString().matches("")) )
            {
                int tmplength = 0,tmpwidth = 0;
                tmplength = (int)(Float.parseFloat(EditLength_Text.getText().toString())*10);
                tmpwidth = (int)(Float.parseFloat(EditWidth_Text.getText().toString())*10);

                GlobalVariable.SetLength(tmplength);
                GlobalVariable.SetWidth(tmpwidth);
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast toast = Toast.makeText(FirstActivity.this,"請輸入數字",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    };

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            isExit = false;
            hasTask = true;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {// 判斷是否按下Back
            // 是否要退出
            if(isExit == false ) {
                isExit = true; //記錄下一次要退出
                Toast.makeText(this, "再按一次Back退出APP", Toast.LENGTH_SHORT).show();
                if(!hasTask) {// 如果超過兩秒則恢復預設值
                    timerExit.schedule(task, 2000);
                }
            } else {
                android.os.Process.killProcess(android.os.Process.myPid()); // 離開程式
            }
        }
        return false;
    }
}
