package edu.temple.lab3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    static boolean isIntentional = false;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setTitle("Palette Activity");

        Resources res = getResources();
        String[] colors = res.getStringArray(R.array.colors_array);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ColorAdapter(this, colors));
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
