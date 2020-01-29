package com.example.admin.sunon_ceiling_fan;

import android.content.Intent;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class FourthActivity extends AppCompatActivity {

    GlobalVariable GlobalVariable = new GlobalVariable();
    private int Fill_Fan[][] = new int[GlobalVariable.GetFanType()][GlobalVariable.GetFanType()];
    //private int Fill_Area[][] = new int[GlobalVariable.GetWidth()][GlobalVariable.GetLength()];
    //private int Area[][] = new int[GlobalVariable.GetWidth()][GlobalVariable.GetLength()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //隱藏標題
        setContentView(R.layout.fourthactivity);

        Button Index_Button = (Button) findViewById(R.id.Index_Button);
        Index_Button.setOnClickListener(Index_Button_Listner);

        for (int i=0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {

            }
        }

        for(int i = 0; i < Fill_Fan.length; i++){
            for(int j = 0; j < Fill_Fan[i].length; j++){
                Fill_Fan[i][j] = 10;
            }
        }
    }

    private Button.OnClickListener Index_Button_Listner = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(FourthActivity.this,FirstActivity.class);
            startActivity(intent);
        }
    };
}
