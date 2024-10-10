package com.example.bai5_tablayout_bottomnavigation.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bai5_tablayout_bottomnavigation.R;
import com.example.bai5_tablayout_bottomnavigation.newFragment.NewAdapter;
import com.google.android.material.tabs.TabLayout;

public class NewFragment extends Fragment {

    TabLayout layout;
    ViewPager viewPager;
    View view;
    public NewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new, container, false);

        layout = view.findViewById(R.id.TabLayout);
        viewPager = view.findViewById(R.id.fragmentContainerView);

        NewAdapter adapter = new NewAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(adapter);

        layout.setupWithViewPager(viewPager);

        return view;
    }

}