package tech.ezapp.ezadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import tech.ezapp.ezadmin.dummy.DummyContent;

public class NotificationActivity extends AppCompatActivity implements NotifFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        loadFragment(new NotifFragment());

        ImageView toolbar = findViewById(R.id.back);

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
                    .replace(R.id.notif_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
