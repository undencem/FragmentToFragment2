package com.undencem.fragmenttofragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.SendDataFragment{

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.Container) != null){

            if(savedInstanceState!=null){
                return;
            }

            fragmentManager.beginTransaction()
                    .add(R.id.Container,new FirstFragment(),null)
                    .commit();

        }
    }

    @Override
    public void sendData(String name, String surname) {
        SecondFragment mSecondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);;
        bundle.putString("surname",surname);
        mSecondFragment.setArguments(bundle);

        fragmentManager.beginTransaction().add(R.id.Container,mSecondFragment,null).commit();
    }
}