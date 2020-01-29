package com.example.admin.sunon_ceiling_fan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private Spinner Spinner_List;
    private String[] List = {"7.3","6","5","4.2","3.6","3","2.5","2","1.5","1"};
    private ArrayAdapter<String> ListAdapter;
    GlobalVariable GlobalVariable = new GlobalVariable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //隱藏標題
        setContentView(R.layout.thirdactivity);

        Button Back_Button = (Button) findViewById(R.id.Back_Button);
        Button Next_Button = (Button) findViewById(R.id.Next_Button);
        Button Index_Button = (Button) findViewById(R.id.Index_Button);
        Spinner_List = (Spinner) findViewById(R.id.Spinner);
        Back_Button.setOnClickListener(Back_Button_Listner);
        Next_Button.setOnClickListener(Next_Button_Listner);
        Index_Button.setOnClickListener(Index_Button_Listner);
        Spinner_List.setOnItemSelectedListener(SpnOnItemSelected);
        ListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, List);
        Spinner_List.setAdapter(ListAdapter);

        for(int i = 0; i<GlobalVariable.GetLength(); i++)
        {
            for (int j = 0; j<GlobalVariable.GetWidth(); j++)
            {
                Log.d("i",String.valueOf(i));
                Log.d("j",String.valueOf(j));
                Log.d("value",String.valueOf(GlobalVariable.GetArea(i,j)));
            }
        }
    }

    private Button.OnClickListener Back_Button_Listner = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(ThirdActivity.this,SecondActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener Next_Button_Listner = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(ThirdActivity.this,FourthActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener Index_Button_Listner = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(ThirdActivity.this,FirstActivity.class);
            startActivity(intent);
        }
    };

    private AdapterView.OnItemSelectedListener SpnOnItemSelected = new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
        {
            GlobalVariable.SetFanType((int)(Float.parseFloat(parent.getSelectedItem().toString())*10));
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0)
        {

        }
    };
}
