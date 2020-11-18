package com.example.no_brain___my_pain.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.no_brain___my_pain.Model.MusicService;
import com.example.no_brain___my_pain.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void start_service(View view) {
        startService(new Intent(ServiceActivity.this, MusicService.class));
    }

    public void stop_service(View view) {
        stopService(new Intent(ServiceActivity.this, MusicService.class));
        saveFile();
    }





    public void saveFile(){
        FileOutputStream out = null;
        try{
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String data = dateFormat.format(date);
            out = openFileOutput("data.txt", MODE_PRIVATE);
            out.write(data.getBytes());
            // Toast.makeText(this, "File Done", Toast.LENGTH_SHORT).show();


        }
        catch(IOException ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        try {
            if(out != null)
                out.close();
        }
        catch(IOException ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void show_file(View view) {
        this.openFile();
    }

    private void openFile() {
        Toast.makeText(this, "func", Toast.LENGTH_SHORT);
        FileInputStream fin = null;

        try {
            fin = openFileInput("data.txt");
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String data = new String(bytes);
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}