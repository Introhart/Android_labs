package com.example.no_brain___my_pain.ViewModel;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.no_brain___my_pain.Model.Pain;
import com.example.no_brain___my_pain.Model.RevivalModel;

import java.util.ArrayList;

public class ListViewModel extends AndroidViewModel {

    private RevivalModel revivalModel;
    public MutableLiveData<ArrayList<Pain>> listOfPain;

    public ListViewModel(@NonNull Application application) {
        super(application);
        revivalModel = new RevivalModel(application);
        listOfPain = new MutableLiveData<ArrayList<Pain>>();
        listOfPain.setValue(revivalModel.getPainList());
    }

    public ArrayList<Pain> getPainList(){
        return listOfPain.getValue();
    }

}
