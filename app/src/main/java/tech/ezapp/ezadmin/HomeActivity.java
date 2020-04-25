package tech.ezapp.ezadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

import tech.ezapp.ezadmin.dummy.DummyContent;


public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, HomeFragment.OnFragmentInteractionListener,PostFragment.OnListFragmentInteractionListener,AnalisisFragment.OnFragmentInteractionListener,TransaksiFragment.OnFragmentInteractionListener,SaldoFragment.OnFragmentInteractionListener,AkunFragment.OnFragmentInteractionListener {

    private FirebaseAuth mAuth;
    String email = "null";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();



        if(currentUser == null){
            Intent login = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(login);
            finish();
        }else{
            email = currentUser.getEmail();
        }




        loadFragment(new HomeFragment());
        BottomNavigationView bv = findViewById(R.id.nav_view);

        bv.setOnNavigationItemSelectedListener(this);
    }


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.menu_home:
                fragment = new HomeFragment();

                break;
            case R.id.menu_analisis:
                fragment = new AnalisisFragment();
                break;
            case R.id.menu_transaksi:
                fragment = new TransaksiFragment();
                break;
            case R.id.menu_saldo:
                fragment = new SaldoFragment();
                break;
            case R.id.menu_akun:
                fragment = new AkunFragment();
                break;
        }

        return loadFragment(fragment);
    }

    public String getEmail(){
        return email;
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
