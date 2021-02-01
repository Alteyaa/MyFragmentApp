package io.geektech.myapplicationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IFragments {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
        public void onSendText(String text) {
        fragmentManager = getSupportFragmentManager();
        TExtFragment fragment =(TExtFragment) fragmentManager.findFragmentById(R.id.fragment_second);
        transaction = fragmentManager.beginTransaction();
        fragment.showText(text);
        transaction.commit();
    }

    @Override
    public void onReplace() {
        fragmentManager = getSupportFragmentManager();
        ChangeFragment fragment =  new ChangeFragment();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container,fragment);
        transaction.commit();
    }
}