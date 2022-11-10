package com.si5b.kampuskita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnvKampusKita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        bnvKampusKita = findViewById(R.id.bnv_kampus_kita);

        bnvKampusKita.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        bukaFragment(new HomeFragment());
                        getSupportActionBar().setTitle("Home");
                        return true;
                    case R.id.menu_jadwal:
                        bukaFragment(new JadwalFragment());
                        getSupportActionBar().setTitle("Jadwal");
                        return true;
                    case R.id.menu_nilai:
                        bukaFragment(new NilaiFragment());
                        getSupportActionBar().setTitle("Nilai");
                        return true;

                }

            }
        });
    }

    private void bukaFragment(Fragment varFragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_container, varFragment);
        ft.commit();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_atas, menu);
        return super.onCreateOptionsMenu(menu);
    }
}