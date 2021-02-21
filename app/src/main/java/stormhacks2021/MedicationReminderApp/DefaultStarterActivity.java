package stormhacks2021.MedicationReminderApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DefaultStarterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_starter_screen);
        getSupportActionBar().setTitle("Home");
        setupNavigationBar();
    }

    /**
     * This method allows for the functions, such as switching screens, of the bottom navigation bar on the app.
     */
    private void setupNavigationBar() {
        BottomNavigationView bottomNavigationBar = (BottomNavigationView) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case (R.id.bottom_navigation_homepage):
                        selectedFragment = new HomeFragment();
                        getSupportActionBar().setTitle("Home");
                        break;

                    case (R.id.bottom_navigation_reminder):
                        selectedFragment = new ReminderFragment();
                        getSupportActionBar().setTitle("Reminders List");
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }
}