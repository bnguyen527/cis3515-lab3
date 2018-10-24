package edu.temple.lab3;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    static final int[] COLORS = new int[]{
            Color.WHITE, Color.RED, Color.BLUE, Color.GREEN,
            Color.GRAY, Color.CYAN, Color.MAGENTA, Color.YELLOW
    };

    private Context context;
    private String[] colors;

    ColorAdapter(Context context, String[] colors) {
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return this.colors.length;
    }

    @Override
    public Object getItem(int position) {
        return this.colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView colorView = new TextView(context);
        colorView.setText(colors[position]);
        colorView.setTextSize(28);
        colorView.setBackgroundColor(COLORS[position]);
        return colorView;
    }
}
