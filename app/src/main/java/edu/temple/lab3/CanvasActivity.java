package edu.temple.lab3;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        setTitle(R.string.activity_canvas_name);

        constraintLayout = findViewById(R.id.constraintLayout);

        Intent colorIntent = getIntent();
        int color = colorIntent.getIntExtra("color", Color.WHITE);
        constraintLayout.setBackgroundColor(color);
    }
}
