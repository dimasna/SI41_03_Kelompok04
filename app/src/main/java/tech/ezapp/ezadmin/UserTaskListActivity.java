package tech.ezapp.ezadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import tech.ezapp.ezadmin.dummy.DummyContent;

import android.os.Bundle;

public class UserTaskListActivity extends AppCompatActivity implements DetailUserTaskFragment.OnListFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_task_list);

        loadFragment(new DetailUserTaskFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.task_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
