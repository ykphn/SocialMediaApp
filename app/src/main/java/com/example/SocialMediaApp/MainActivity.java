package com.example.SocialMediaApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.SocialMediaApp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportFragmentManager().beginTransaction().replace(binding.container.getId(),new HomeFragment()).commit();
        bottomNavigation();

    }
    public void bottomNavigation() {
        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        transaction(new HomeFragment());
                        return true;
                    case R.id.search:
                        transaction(new SearchFragment());
                        return true;
                    case R.id.Profile:
                        transaction(new ProfileFragment());
                        return  true;
                }
                return false;
            }
        });
    }
    public void transaction(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(binding.container.getId(),fragment).commit();
    }
}