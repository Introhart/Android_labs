package com.example.no_brain___my_pain.Model;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import androidx.room.Room;

import com.example.no_brain___my_pain.View.ServiceActivity;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class RevivalModel {
    SufferingDatabase database;
    FrustrationDAO frustrationDAO;
    private SharedPreferences sPref;


    public RevivalModel(Application application){
        database = Room.databaseBuilder(application,
                SufferingDatabase.class, "db-pain")
                .allowMainThreadQueries()
                .build();
        frustrationDAO = database.getPainDAO();
    }

    public double calculate_sum(double op1, double op2){
        double res = op1 + op2;
        db_addPain(op1,op2,'+',res);
        return res;
    }

    public double calculate_mult(double op1, double op2){
        double res = op1 * op2;
        db_addPain(op1,op2,'*', res);
        return res;
    }

    private void db_addPain(double op1, double op2, char operation, double result){
        Pain pain = new Pain();
        pain.setOperand_1(op1);
        pain.setOperand_2(op2);
        pain.setOperation(operation);
        pain.setResult(result);
        frustrationDAO.insert(pain);
    }

    public ArrayList<Pain> getPainList(){
        ArrayList<Pain> painList = new ArrayList<Pain>(frustrationDAO.getPain());
        return painList;
    }

    public void setBtnColor(String color, Activity activity){
        sPref = activity.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("btn_color", color);
        editor.apply();
        Toast.makeText(activity, color, Toast.LENGTH_SHORT).show();
    }

    public String getBtnColor(Activity activity){
        sPref = activity.getPreferences(MODE_PRIVATE);
        String color = sPref.getString("btn_color", "#FF3700B3");
        return color;
    }




}
