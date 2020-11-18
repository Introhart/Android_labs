package com.example.no_brain___my_pain.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.no_brain___my_pain.R;
import com.example.no_brain___my_pain.ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    TextView textViewResult;
    EditText operand_1, operand_2;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        textViewResult = (TextView)findViewById(R.id.textView_Result);
        operand_1 = (EditText)findViewById(R.id.operand_1);
        operand_2 = (EditText)findViewById(R.id.operand_2);

        btn1 = (Button)findViewById(R.id.button_sum);
        btn2 = (Button)findViewById(R.id.btn_mult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.menuList:
                Intent deadActivityList = new Intent(this, DeadListActivity.class);
                startActivity(deadActivityList);
                break;
            case R.id.menuPlayer:
                Intent playerActivity = new Intent(this, ServiceActivity.class);
                startActivity(playerActivity);
                break;
            case R.id.menuBrowser:
                Intent browserActivity = new Intent(this, BrowserActivity.class);
                startActivity(browserActivity);
                break;
            case R.id.menuSettings:
                Intent settingsActivity = new Intent(this, SettingsActivity.class);
                startActivity(settingsActivity);
                break;
            case R.id.menuGraphics:
                Intent graphicsActivity = new Intent(this,Graphics.class);
                startActivity(graphicsActivity);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainViewModel.result.observe(this, Observer -> {
            textViewResult.setText(mainViewModel.getResult());
        });
    }

    public void calcSum(View view) {
        mainViewModel.calculateSum(operand_1.getText().toString(), operand_2.getText().toString());
    }

    public void calcMult(View view) {
        mainViewModel.calculateMult(operand_1.getText().toString(), operand_2.getText().toString());
    }
}