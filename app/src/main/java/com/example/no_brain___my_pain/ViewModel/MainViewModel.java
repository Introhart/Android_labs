package com.example.no_brain___my_pain.ViewModel;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.no_brain___my_pain.Model.FrustrationDAO;
import com.example.no_brain___my_pain.Model.Pain;
import com.example.no_brain___my_pain.Model.RevivalModel;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {

    private RevivalModel revivalModel;
    public MutableLiveData<String> result;

    public MainViewModel(@NonNull Application application) {
        super(application);

        revivalModel = new RevivalModel(application);
        result = new MutableLiveData<String>();
        result.setValue(" . . . ");
    }

    public void calculateSum(String op1, String op2){
        if(op1.isEmpty() || op2.isEmpty()) return;
        double res = revivalModel.calculate_sum(Double.parseDouble(op1),Double.parseDouble(op2));
        result.setValue(Double.toString(res));
    }

    public void calculateMult(String op1, String op2){
        if(op1.isEmpty() || op2.isEmpty()) return;
        double res = revivalModel.calculate_mult(Double.parseDouble(op1),Double.parseDouble(op2));
        result.setValue(Double.toString(res));
    }

    public String getResult(){
        return result.getValue();
    }
}
