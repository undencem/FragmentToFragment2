package com.undencem.fragmenttofragment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView mTextView;

    public SecondFragment() {  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.second_fragment, container, false);
        mTextView = view.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        String surname = bundle.getString("surname");
        mTextView.setText(name+" "+surname);
        return view;
    }
}