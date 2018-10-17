package edu.temple.lab3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ParentListener} interface
 * to handle interaction events.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {
    private static final String COLORS_ARRAY_KEY = "colors_array";

    private String[] colors_array;
    private ListView listView;
    private ParentListener parentListener;

    public PaletteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param colors_array Colors array.
     * @return A new instance of fragment PaletteFragment.
     */
    public static PaletteFragment newInstance(String[] colors_array) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(COLORS_ARRAY_KEY, colors_array);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            colors_array = getArguments().getStringArray(COLORS_ARRAY_KEY);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);
        listView = v.findViewById(R.id.listView);
        listView.setAdapter(new ColorAdapter((Context) parentListener, colors_array));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onColorPicked(ColorAdapter.COLORS[position]);
            }
        });
        return v;
    }

    public void onColorPicked(int color) {
        if (parentListener != null)
            parentListener.onColorPicked(color);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ParentListener)
            parentListener = (ParentListener) context;
        else
            throw new RuntimeException(context.toString() + " must implement ParentListener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        parentListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface ParentListener {
        void onColorPicked(int color);
    }
}
