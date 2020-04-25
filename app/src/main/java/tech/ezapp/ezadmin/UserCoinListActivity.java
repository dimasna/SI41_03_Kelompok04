package tech.ezapp.ezadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import tech.ezapp.ezadmin.dummy.DummyContent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UserCoinListActivity extends AppCompatActivity implements DetailUserCoinFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_coin_list);

        loadFragment(new DetailUserCoinFragment());

        ImageView toolbar = findViewById(R.id.headerBackIcon);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.user_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
