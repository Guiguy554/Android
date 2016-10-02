package com.example.lg403756.td4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

/**
 * Created by lg403756 on 26/09/2016.
 */
public class MyFragment extends Fragment{

    public MyFragment() {}

    public static MyFragment newInstance (NumberPicker np){

        MyFragment MyF = new MyFragment();
        return MyF;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.my_fragment, container, false);
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
            throw new ClassCastException(activity.toString()+ " must implement OnActionListener");
        }
    }
}
