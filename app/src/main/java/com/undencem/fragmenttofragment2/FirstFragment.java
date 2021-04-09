package com.undencem.fragmenttofragment2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    private EditText mEditName;
    private EditText mEditSurname;
    private Button mButton;

    SendDataFragment mSendDataFragment;

    public FirstFragment() {  }

    public interface SendDataFragment{
        public void sendData(String name, String surname);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.first_fragment, container, false);
        mEditName = view.findViewById(R.id.editName);
        mEditSurname = view.findViewById(R.id.editSurname);
        mButton = view.findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v) {
                    String name = mEditName.getText().toString();
                    String surname = mEditSurname.getText().toString();
                    mSendDataFragment.sendData(name,surname);
               }
           }
        );
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity)context;
        try{
            mSendDataFragment = (SendDataFragment)activity;
        }catch(RuntimeException e){
            throw new RuntimeException(activity.toString()+" must implement method");
        }
    }
}