package edu.temple.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    static final String[] COLORS = new String[]{"white", "red", "blue", "green", "gray", "cyan",
            "magenta", "yellow", "maroon", "olive", "silver", "teal"};
    static boolean isIntentional = false;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setTitle("Palette Activity");

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ColorAdapter(this, COLORS));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isIntentional) {
                    Intent startCanvasActivity = new Intent(PaletteActivity.this, CanvasActivity.class);
                    startCanvasActivity.putExtra("color", ((TextView) view).getText());
                    startActivity(startCanvasActivity);
                } else {
                    isIntentional = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }
}
