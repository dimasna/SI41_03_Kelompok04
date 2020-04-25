package tech.ezapp.ezadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import tech.ezapp.ezadmin.dummy.DummyContent;

import android.os.Bundle;

public class UserTaxRListActivity extends AppCompatActivity implements DetailTaxRateFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tax_list);

        loadFragment(new DetailTaxRateFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.tax_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
