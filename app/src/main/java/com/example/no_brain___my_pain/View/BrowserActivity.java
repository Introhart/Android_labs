package com.example.no_brain___my_pain.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.no_brain___my_pain.R;

public class BrowserActivity extends AppCompatActivity {
    EditText urlEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        urlEdit = (EditText)findViewById(R.id.url_edit);
    }

    public void start_browser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlEdit.getText().toString()));
        startActivity(intent);
    }
}