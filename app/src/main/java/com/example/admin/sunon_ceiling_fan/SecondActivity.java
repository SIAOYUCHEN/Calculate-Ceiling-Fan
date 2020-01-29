package com.example.admin.sunon_ceiling_fan;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    int tmpwidthedit1=0,tmplengthedit1=0,tmpwidthedit2=0,tmplengthedit2=0,tmpwidthedit3=0,tmplengthedit3=0;
    int tmpwidthedit4=0,tmplengthedit4=0,tmpwidthedit5=0,tmplengthedit5=0,tmpwidthedit6=0,tmplengthedit6=0;
    int tmpwidthedit7=0,tmplengthedit7=0,tmpwidthedit8=0,tmplengthedit8=0,tmpwidthedit9=0,tmplengthedit9=0;
    Button LeftTop_Button,MiddleTop_Button,RightTop_Button,LeftMiddle_Button,MiddleMiddle_Button,RightMiddle_Button,LeftBottom_Button,MiddleBottom_Button,RightBottom_Button;
    Boolean LeftTop_Flag = false,MiddleTop_Flag = false,RightTop_Flag = false;
    Boolean LeftMiddle_Flag = false,MiddleMiddle_Flag = false,RightMiddle_Flag = false;
    Boolean LeftBottom_Flag = false,MiddleBottom_Flag = false,RightBottom_Flag = false;
    GlobalVariable GlobalVariable = new GlobalVariable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //隱藏標題
        setContentView(R.layout.secondactivity);

        Button Back_Button = (Button) findViewById(R.id.Back_Button);
        Button Next_Button = (Button) findViewById(R.id.Next_Button);
        LeftTop_Button = (Button) findViewById(R.id.LeftTop_Button);
        MiddleTop_Button = (Button) findViewById(R.id.MiddleTop_Button);
        RightTop_Button = (Button) findViewById(R.id.RightTop_Button);
        LeftMiddle_Button = (Button) findViewById(R.id.LeftMiddle_Button);
        MiddleMiddle_Button = (Button) findViewById(R.id.MiddleMiddle_Button);
        RightMiddle_Button = (Button) findViewById(R.id.RightMiddle_Button);
        LeftBottom_Button = (Button) findViewById(R.id.LeftBottom_Button);
        MiddleBottom_Button = (Button) findViewById(R.id.MiddleBottom_Button);
        RightBottom_Button = (Button) findViewById(R.id.RightBottom_Button);
        Back_Button.setOnClickListener(Back_Button_Listner);
        Next_Button.setOnClickListener(Next_Button_Listner);
        LeftTop_Button.setOnClickListener(Area_Listner);
        MiddleTop_Button.setOnClickListener(Area_Listner);
        RightTop_Button.setOnClickListener(Area_Listner);
        LeftMiddle_Button.setOnClickListener(Area_Listner);
        MiddleMiddle_Button.setOnClickListener(Area_Listner);
        RightMiddle_Button.setOnClickListener(Area_Listner);
        LeftBottom_Button.setOnClickListener(Area_Listner);
        MiddleBottom_Button.setOnClickListener(Area_Listner);
        RightBottom_Button.setOnClickListener(Area_Listner);

        GlobalVariable.InitArea(GlobalVariable.GetWidth(),GlobalVariable.GetLength());
        for(int i = 0; i<GlobalVariable.GetWidth(); i++)
        {
            for (int j = 0; j<GlobalVariable.GetLength(); j++)
            {
                GlobalVariable.SetArea(i,j,1);
            }
        }
    }

    private Button.OnClickListener Back_Button_Listner = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,FirstActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener Next_Button_Listner = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,ThirdActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener Area_Listner = new Button.OnClickListener()
    {
        public void onClick(final View v)
        {
            final AlertDialog.Builder EditDialog = new AlertDialog.Builder(SecondActivity.this);
            LayoutInflater inflater = getLayoutInflater();
            EditDialog.setTitle("請輸入長寬");
            LinearLayout layout = new LinearLayout(SecondActivity.this);
            layout.setOrientation(LinearLayout.VERTICAL);

            final EditText WidthEdit = new EditText(SecondActivity.this);
            WidthEdit.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            layout.addView(WidthEdit);

            final EditText LengthEdit = new EditText(SecondActivity.this);
            LengthEdit.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            layout.addView(LengthEdit);

            EditDialog.setView(layout);
            EditDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                // do something when the button is clicked
                public void onClick(DialogInterface arg0, int arg1) {
                    switch (v.getId())
                    {
                        case R.id.LeftTop_Button:
                            LeftTop_Flag = !LeftTop_Flag;
                            if(LeftTop_Flag)
                            {
                                //GlobalVariable.SetAreaSelect(0,0);
                                //GlobalVariable.SetFillWidthArea(0,0,(int)(Float.parseFloat(WidthEdit.getText().toString())*10));
                                //GlobalVariable.SetFillLengthArea(0,0,(int)(Float.parseFloat(LengthEdit.getText().toString())*10));
                                if((int)(Float.parseFloat(LengthEdit.getText().toString())*10) <= GlobalVariable.GetLength() &&
                                        (int)(Float.parseFloat(WidthEdit.getText().toString())*10) <= GlobalVariable.GetWidth())
                                {
                                    LeftTop_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                    tmpwidthedit1 = (int)(Float.parseFloat(WidthEdit.getText().toString())*10);
                                    tmplengthedit1 = (int)(Float.parseFloat(LengthEdit.getText().toString())*10);

                                    for(int i = 0; i<(int)(Float.parseFloat(LengthEdit.getText().toString())*10); i++)
                                    {
                                        for(int j = 0; j<(int)(Float.parseFloat(WidthEdit.getText().toString())*10); j++)
                                        {
                                            GlobalVariable.SetArea(i,j,0);
                                        }
                                    }
                                }
                                else
                                {
                                    Toast toast = Toast.makeText(SecondActivity.this,"請輸入正確範圍",Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                            else
                            {
                                LeftTop_Button.setBackgroundColor(Color.parseColor("#ffd6d7d7"));
                                //GlobalVariable.ClearAreaSelect(0,0);
                                for(int i = 0; i<tmplengthedit1; i++)
                                {
                                    for(int j = 0; j<tmpwidthedit1; j++)
                                    {
                                        GlobalVariable.SetArea(i,j,1);
                                    }
                                }
                            }
                            break;
                        case R.id.MiddleTop_Button:
                            MiddleTop_Flag = !MiddleTop_Flag;
                            if(MiddleTop_Flag)
                            {
                                //GlobalVariable.SetAreaSelect(0,1);
                                //GlobalVariable.SetFillWidthArea(0,1,(int)(Float.parseFloat(WidthEdit.getText().toString())*10));
                                //GlobalVariable.SetFillLengthArea(0,1,(int)(Float.parseFloat(LengthEdit.getText().toString())*10));
                                int tmp = (GlobalVariable.GetWidth() - (int)(Float.parseFloat(WidthEdit.getText().toString())*10)) / 2;
                                if((int)(Float.parseFloat(WidthEdit.getText().toString())*10) <= GlobalVariable.GetWidth() &&
                                        (int)(Float.parseFloat(LengthEdit.getText().toString())*10) <= GlobalVariable.GetLength())
                                {
                                    MiddleTop_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                    tmpwidthedit2 = (int)(Float.parseFloat(WidthEdit.getText().toString())*10);
                                    tmplengthedit2 = (int)(Float.parseFloat(LengthEdit.getText().toString())*10);

                                    for(int i = 0; i<(int)(Float.parseFloat(LengthEdit.getText().toString())*10); i++)
                                    {
                                        for(int j = tmp; j<(GlobalVariable.GetWidth()-tmp); j++)
                                        {
                                            GlobalVariable.SetArea(i,j,0);
                                        }
                                    }
                                    /*
                                    for(int i = 0; i<GlobalVariable.GetLength(); i++)
                                    {
                                        for (int j = 0; j<GlobalVariable.GetWidth(); j++)
                                        {
                                            Log.d("i",String.valueOf(i));
                                            Log.d("j",String.valueOf(j));
                                            Log.d("value",String.valueOf(GlobalVariable.GetArea(i,j)));
                                        }
                                    }*/
                                }
                                else
                                {
                                    Toast toast = Toast.makeText(SecondActivity.this,"請輸入正確範圍",Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                            else
                            {
                                MiddleTop_Button.setBackgroundColor(Color.parseColor("#ffd6d7d7"));
                                //GlobalVariable.ClearAreaSelect(0,1);
                                for(int i = 0; i<tmplengthedit2; i++)
                                {
                                    for(int j = 0; j<tmpwidthedit2; j++)
                                    {
                                        GlobalVariable.SetArea(i,j,1);
                                    }
                                }
                            }
                            break;
                        case R.id.RightTop_Button:
                            RightTop_Flag = !RightTop_Flag;
                            if(RightTop_Flag)
                            {
                                //RightTop_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                //GlobalVariable.SetAreaSelect(0,2);
                                //GlobalVariable.SetFillWidthArea(0,2,(int)(Float.parseFloat(WidthEdit.getText().toString())*10));
                                //GlobalVariable.SetFillLengthArea(0,2,(int)(Float.parseFloat(LengthEdit.getText().toString())*10));
                                if((int)(Float.parseFloat(WidthEdit.getText().toString())*10) <= GlobalVariable.GetWidth() &&
                                        (int)(Float.parseFloat(LengthEdit.getText().toString())*10) <= GlobalVariable.GetLength())
                                {
                                    RightTop_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                    tmpwidthedit3 = (int)(Float.parseFloat(WidthEdit.getText().toString())*10);
                                    tmplengthedit3 = (int)(Float.parseFloat(LengthEdit.getText().toString())*10);

                                    for(int i = 0; i<(int)(Float.parseFloat(LengthEdit.getText().toString())*10); i++)
                                    {
                                        for(int j = GlobalVariable.GetWidth()-1; j>=(GlobalVariable.GetWidth()-(int)(Float.parseFloat(WidthEdit.getText().toString())*10)); j--)
                                        {
                                            GlobalVariable.SetArea(i,j,0);
                                        }
                                    }
/*
                                    for(int i = 0; i<GlobalVariable.GetLength(); i++)
                                    {
                                        for (int j = 0; j<GlobalVariable.GetWidth(); j++)
                                        {
                                            Log.d("i",String.valueOf(i));
                                            Log.d("j",String.valueOf(j));
                                            Log.d("value",String.valueOf(GlobalVariable.GetArea(i,j)));
                                        }
                                    }*/
                                }
                                else
                                {
                                    Toast toast = Toast.makeText(SecondActivity.this,"請輸入正確範圍",Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                            else
                            {
                                RightTop_Button.setBackgroundColor(Color.parseColor("#ffd6d7d7"));
                                //GlobalVariable.ClearAreaSelect(0,2);
                                for(int i = 0; i<tmplengthedit2; i++)
                                {
                                    for(int j = 0; j<tmpwidthedit2; j++)
                                    {
                                        GlobalVariable.SetArea(i,j,1);
                                    }
                                }
                            }
                            break;
                        case R.id.LeftMiddle_Button:
                            LeftMiddle_Flag = !LeftMiddle_Flag;
                            if(LeftMiddle_Flag)
                            {
                                LeftMiddle_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                GlobalVariable.SetAreaSelect(1,0);
                                GlobalVariable.SetFillWidthArea(1,0,(int)(Float.parseFloat(WidthEdit.getText().toString())*10));
                                GlobalVariable.SetFillLengthArea(1,0,(int)(Float.parseFloat(LengthEdit.getText().toString())*10));
                            }
                            else
                            {
                                LeftMiddle_Button.setBackgroundColor(Color.parseColor("#ffd6d7d7"));
                                GlobalVariable.ClearAreaSelect(1,0);
                            }
                            break;
                        case R.id.MiddleMiddle_Button:
                            MiddleMiddle_Flag = !MiddleMiddle_Flag;
                            if(MiddleMiddle_Flag)
                            {
                                MiddleMiddle_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                GlobalVariable.SetAreaSelect(1,1);
                                GlobalVariable.SetFillWidthArea(1,1,(int)(Float.parseFloat(WidthEdit.getText().toString())*10));
                                GlobalVariable.SetFillLengthArea(1,1,(int)(Float.parseFloat(LengthEdit.getText().toString())*10));
                            }
                            else
                            {
                                MiddleMiddle_Button.setBackgroundColor(Color.parseColor("#ffd6d7d7"));
                                GlobalVariable.ClearAreaSelect(1,1);
                            }
                            break;
                        case R.id.RightMiddle_Button:
                            RightMiddle_Flag = !RightMiddle_Flag;
                            if(RightMiddle_Flag)
                            {
                                RightMiddle_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                GlobalVariable.SetAreaSelect(1,2);
                                GlobalVariable.SetFillWidthArea(1,2,(int)(Float.parseFloat(WidthEdit.getText().toString())*10));
                                GlobalVariable.SetFillLengthArea(1,2,(int)(Float.parseFloat(LengthEdit.getText().toString())*10));
                            }
                            else
                            {
                                RightMiddle_Button.setBackgroundColor(Color.parseColor("#ffd6d7d7"));
                                GlobalVariable.ClearAreaSelect(1,2);
                            }
                            break;
                        case R.id.LeftBottom_Button:
                            LeftBottom_Flag = !LeftBottom_Flag;
                            if(LeftBottom_Flag)
                            {
                                LeftBottom_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                GlobalVariable.SetAreaSelect(2,0);
                                GlobalVariable.SetFillWidthArea(2,0,(int)(Float.parseFloat(WidthEdit.getText().toString())*10));
                                GlobalVariable.SetFillLengthArea(2,0,(int)(Float.parseFloat(LengthEdit.getText().toString())*10));
                            }
                            else
                            {
                                LeftBottom_Button.setBackgroundColor(Color.parseColor("#ffd6d7d7"));
                                GlobalVariable.ClearAreaSelect(2,0);
                            }
                            break;
                        case R.id.MiddleBottom_Button:
                            MiddleBottom_Flag = !MiddleBottom_Flag;
                            if(MiddleBottom_Flag)
                            {
                                MiddleBottom_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                GlobalVariable.SetAreaSelect(2,1);
                                GlobalVariable.SetFillWidthArea(2,1,(int)(Float.parseFloat(WidthEdit.getText().toString())*10));
                                GlobalVariable.SetFillLengthArea(2,1,(int)(Float.parseFloat(LengthEdit.getText().toString())*10));
                            }
                            else
                            {
                                MiddleBottom_Button.setBackgroundColor(Color.parseColor("#ffd6d7d7"));
                                GlobalVariable.ClearAreaSelect(2,1);
                            }
                            break;
                        case R.id.RightBottom_Button:
                            RightBottom_Flag = !RightBottom_Flag;
                            if(RightBottom_Flag)
                            {
                                RightBottom_Button.setBackgroundColor(Color.parseColor("#F4511E"));
                                GlobalVariable.SetAreaSelect(2,2);
                                GlobalVariable.SetFillWidthArea(2,2,(int)(Float.parseFloat(WidthEdit.getText().toString())*10));
                                GlobalVariable.SetFillLengthArea(2,2,(int)(Float.parseFloat(LengthEdit.getText().toString())*10));
                            }
                            else
                            {
                                RightBottom_Button.setBackgroundColor(Color.parseColor("#ffd6d7d7"));
                                GlobalVariable.ClearAreaSelect(2,2);
                            }
                            break;
                    }
                }
            });
            EditDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {

                }
            });
            EditDialog.show();
        }
    };
}
