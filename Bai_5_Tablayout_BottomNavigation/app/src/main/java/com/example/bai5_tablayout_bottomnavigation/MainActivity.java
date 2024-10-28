package com.example.bai5_tablayout_bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bai5_tablayout_bottomnavigation.databinding.ActivityMainBinding;
import com.example.bai5_tablayout_bottomnavigation.fragments.AccountFragment;
import com.example.bai5_tablayout_bottomnavigation.fragments.NewFragment;
import com.example.bai5_tablayout_bottomnavigation.fragments.OrderFragment;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        changeFragment(new NewFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.account)
                    changeFragment(new AccountFragment());
                else if (item.getItemId() == R.id.order)
                    changeFragment(new OrderFragment());
                else changeFragment(new NewFragment());
                return true;
            }
        });

    }


    private void changeFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}