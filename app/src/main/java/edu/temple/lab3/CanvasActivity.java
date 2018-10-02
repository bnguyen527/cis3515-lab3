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
        setTitle("Canvas Activity");

        constraintLayout = findViewById(R.id.constraintLayout);

        Intent colorIntent = getIntent();
        String color = colorIntent.getStringExtra("color");
        constraintLayout.setBackgroundColor(Color.parseColor(color));
    }
}
