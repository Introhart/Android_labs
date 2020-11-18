package com.example.no_brain___my_pain.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ListView;

import com.example.no_brain___my_pain.Model.UndeadPainAdapter;
import com.example.no_brain___my_pain.R;
import com.example.no_brain___my_pain.ViewModel.ListViewModel;

import java.util.List;

import static android.os.Build.VERSION_CODES.R;

public class DeadListActivity extends AppCompatActivity {

    ListViewModel listViewModel;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.no_brain___my_pain.R.layout.activity_dead_list);
        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);

        listView = findViewById(com.example.no_brain___my_pain.R.id.deadList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listViewModel.listOfPain.observe(this, Observer -> {
            UndeadPainAdapter UPA = new UndeadPainAdapter(
                    this, listViewModel.getPainList());
            listView.setAdapter(UPA);
        });
    }
}