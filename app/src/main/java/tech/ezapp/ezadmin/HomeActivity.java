package tech.ezapp.ezadmin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import tech.ezapp.ezadmin.Model.Post;
import tech.ezapp.ezadmin.dummy.DummyContent;


<<<<<<< HEAD
public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, HomeFragment.OnFragmentInteractionListener,PostFragment.OnListFragmentInteractionListener,AnalisisFragment.OnFragmentInteractionListener,taskTab.OnFragmentInteractionListener,TransaksiFragment.OnFragmentInteractionListener,SaldoFragment.OnFragmentInteractionListener,AkunFragment.OnFragmentInteractionListener {
=======
public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, HomeFragment.OnFragmentInteractionListener, PostFragment.OnListFragmentInteractionListener, AnalisisFragment.OnFragmentInteractionListener, TransaksiFragment.OnFragmentInteractionListener, SaldoFragment.OnFragmentInteractionListener, BalanceTab.OnFragmentInteractionListener, DetailSaldoFragment.OnListFragmentInteractionListener, RequestTab.OnFragmentInteractionListener, AkunFragment.OnFragmentInteractionListener {
>>>>>>> 6ee2cdedc6577e5ad76ab97593f97b3ba67be61d


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences mPrefs = getSharedPreferences("akun", MODE_PRIVATE);
        if (mPrefs.getBoolean("is_logged_before",false)) {
            loadFragment(new HomeFragment());
            BottomNavigationView bv = findViewById(R.id.nav_view);

            bv.setOnNavigationItemSelectedListener(this);
        } else {
            // continue to login part
            Intent login = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(login);
            finish();
        }




//
//        if(currentUser == null){
//            Intent login = new Intent(HomeActivity.this, LoginActivity.class);
//            startActivity(login);
//            finish();
//        }else{
//            email = currentUser.getEmail();
//        }





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





    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onListFragmentInteraction(Post item) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
