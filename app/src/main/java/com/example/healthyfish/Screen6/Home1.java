package com.example.healthyfish.Screen6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.codebyashish.autoimageslider.AutoImageSlider;
import com.codebyashish.autoimageslider.Enums.ImageActionTypes;
import com.codebyashish.autoimageslider.Enums.ImageScaleType;
import com.codebyashish.autoimageslider.ExceptionsClass;
import com.codebyashish.autoimageslider.Interfaces.ItemsListener;
import com.codebyashish.autoimageslider.Models.ImageSlidesModel;
import com.example.healthyfish.R;
import com.example.healthyfish.Screen1.MainActivity;
import com.example.healthyfish.Screen15.EditProfile;
import com.example.healthyfish.Screen17.WalletActivity;
import com.example.healthyfish.Screen18.ReferEarn;
import com.example.healthyfish.Screen19.AboutUs;
import com.example.healthyfish.Screen21.Contact;
import com.example.healthyfish.Screen6.Fragment1.CategoryFragment;
import com.example.healthyfish.Screen6.Fragment1.HomeFragment;
import com.example.healthyfish.Screen6.Fragment1.SettingFragment;
import com.example.healthyfish.Screen7.Freshfish;
import com.example.healthyfish.Screen8.Fishquantity;
import com.example.healthyfish.screen22.Recipes;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home1 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerlayout;

    BottomNavigationView bottomNavigationView;
    SearchView searchView;

    HomeFragment fragment1 = new HomeFragment();
    CategoryFragment fragment2 = new CategoryFragment();
    SettingFragment fragment3 = new SettingFragment();

    Toolbar toolbar;

    NavigationView navigation;

    ActionBarDrawerToggle actionBarDrawerToggle;

    ImageView imageView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

        searchView = findViewById(R.id.searchView);


        setNavigationDrawer();

        imageView = findViewById(R.id.cartimg);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home1.this, Fishquantity.class);
                startActivity(intent);

            }
        });

    }


    private boolean setNavigationDrawer() {
        drawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment frag = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nav_login) {
                        Intent intent = new Intent( Home1.this, MainActivity.class);
                        startActivity(intent);
                } else if (itemId == R.id.nav_product) {
                        Intent intent = new Intent( Home1.this, Freshfish.class);
                        startActivity(intent);
                } else if (itemId == R.id.nav_refer) {
                    Intent intent = new Intent( Home1.this, ReferEarn.class);
                    startActivity(intent);
                } else if (itemId == R.id.nav_offer) {
                } else if (itemId == R.id.nav_recipes) {
                    Intent intent = new Intent( Home1.this, Recipes.class);
                    startActivity(intent);
                } else if (itemId == R.id.nav_editpro) {
                    Intent intent = new Intent( Home1.this, EditProfile.class);
                    startActivity(intent);
                } else if (itemId == R.id.nav_about) {
                    Intent intent = new Intent( Home1.this, AboutUs.class);
                    startActivity(intent);
                } else if (itemId == R.id.nav_contact) {
                    Intent intent = new Intent( Home1.this, Contact.class);
                    startActivity(intent);
                }
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag);
                    transaction.commit();
                    drawerlayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });

        return false;
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment1)
                    .commit();
            return true;
        } else if (itemId == R.id.categories) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment2)
                    .commit();
            return true;
        } else if (itemId == R.id.settings) {
            searchView.setVisibility(View.GONE);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment3)
                    .commit();
            return true;
        }
        return false;
    }

}

