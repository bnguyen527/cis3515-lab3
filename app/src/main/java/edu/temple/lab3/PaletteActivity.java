package edu.temple.lab3;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PaletteActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setTitle(R.string.activity_palette_name);

        Resources res = getResources();
        String[] colors = res.getStringArray(R.array.colors_array);

        listView = findViewById(R.id.listView);
        listView.setAdapter(new ColorAdapter(this, colors));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CanvasFragment canvasFragment = CanvasFragment.newInstance(ColorAdapter.COLORS[position]);
                fragmentTransaction.replace(R.id.container, canvasFragment).addToBackStack(null).commit();
            }
        });
    }


}
