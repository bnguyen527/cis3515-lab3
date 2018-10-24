package edu.temple.lab3;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ParentListener {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setTitle(R.string.activity_palette_name);

        fragmentManager = getSupportFragmentManager();
        Resources res = getResources();
        String[] colors = res.getStringArray(R.array.colors_array);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PaletteFragment paletteFragment = PaletteFragment.newInstance(colors);
        fragmentTransaction.add(R.id.container1, paletteFragment).commit();
    }


    @Override
    public void onColorPicked(int color) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CanvasFragment canvasFragment = CanvasFragment.newInstance(color);
        fragmentTransaction.replace(R.id.container1, canvasFragment).addToBackStack(null).commit();
    }
}
