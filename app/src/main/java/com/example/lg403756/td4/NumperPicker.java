package com.example.lg403756.td4;

/**
 * Created by Guiguy on 02/10/2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

public class NumperPicker extends Fragment {

    public NumperPicker() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.number_picker, container, false);

        NumberPicker n = ((NumberPicker)v.findViewById(R.id.numberPicker));

        n.setMinValue(0);
        n.setMaxValue(100);

        n.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mListener.onAction(newVal);
            }
        });

        return v;
    }

    public interface OnActionListener {
        public void onAction(int d);
    }

    OnActionListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnActionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnActionListener");
        }
    }
}

