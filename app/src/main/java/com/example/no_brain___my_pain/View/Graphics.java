package com.example.no_brain___my_pain.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.no_brain___my_pain.R;

public class Graphics extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics);

        iv = (ImageView)findViewById(R.id.imageView);
    }

    public void rotate(View view) {
        final Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        iv.startAnimation(rotate);
    }

    public void scale(View view) {
        final Animation rotate = AnimationUtils.loadAnimation(this, R.anim.scale);
        iv.startAnimation(rotate);
    }

    public void translate(View view) {
        final Animation rotate = AnimationUtils.loadAnimation(this, R.anim.translate);
        iv.startAnimation(rotate);
    }

    public void alpha(View view) {
        final Animation rotate = AnimationUtils.loadAnimation(this, R.anim.alpha);
        iv.startAnimation(rotate);
    }
}