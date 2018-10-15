package edu.temple.lab3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    private boolean isIntentional = false;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setTitle(R.string.activity_palette_name);

        Resources res = getResources();
        String[] colors = res.getStringArray(R.array.colors_array);

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ColorAdapter(this, colors));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isIntentional) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    CanvasFragment canvasFragment = CanvasFragment.newInstance(ColorAdapter.COLORS[position]);
                    fragmentTransaction.replace(R.id.container, canvasFragment).addToBackStack(null).commit();
                } else {
                    isIntentional = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }


}
