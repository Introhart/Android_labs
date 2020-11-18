package com.example.no_brain___my_pain.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.no_brain___my_pain.Model.RevivalModel;
import com.example.no_brain___my_pain.R;

public class SettingsActivity extends AppCompatActivity {

    RadioButton rb1, rb2, rb3;
    Button btn_sbm;
    RevivalModel rm;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        rb1 = (RadioButton)findViewById(R.id.rb_1);
        rb2 = (RadioButton)findViewById(R.id.rb_2);
        rb3 = (RadioButton)findViewById(R.id.rb_3);
        btn_sbm = (Button)findViewById(R.id.btn_settings_submit);
        rm = new RevivalModel(this.getApplication());

        String color = rm.getBtnColor(this);

        btn_sbm.setBackgroundColor(Color.parseColor(color));
//        if(color.equals("purple")){
//            btn_sbm.setBackgroundColor(R.color.purple_500);
//        }
//        if(color.equals("teal")){
//            btn_sbm.setBackgroundColor(R.color.teal_200);
//        }
//        if(color.equals("red")){
//            btn_sbm.setBackgroundColor(Color.parseColor("#B50808"));
//        }
    }

    public void setSettings(View view) {
        if(rb1.isChecked()){
            rm.setBtnColor("#FF6200EE", this);
            return;
        }
        if(rb2.isChecked()){
            rm.setBtnColor("#FF018786", this);
            return;
        }
        if(rb3.isChecked()){
            rm.setBtnColor("#B50808", this);
            return;
        }
    }


}