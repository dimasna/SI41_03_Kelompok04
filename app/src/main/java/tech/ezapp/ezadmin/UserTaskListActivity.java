package tech.ezapp.ezadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import tech.ezapp.ezadmin.Model.saldoPost;
import tech.ezapp.ezadmin.dummy.DummyContent;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UserTaskListActivity extends AppCompatActivity implements DetailUserTaskFragment.OnListFragmentInteractionListener {

    private MyDetailUserTaskRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    private static final FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
    private static final Query query = rootRef.collection("saldoPost")
            .orderBy("timestamp", Query.Direction.ASCENDING);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_task_list);

        ImageView toolbar = findViewById(R.id.headerBackIcon);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        recyclerView = findViewById(R.id.list);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
    }


    @Override
    public void onStart() {
        super.onStart();
        FirestoreRecyclerOptions<saldoPost> options = new FirestoreRecyclerOptions.Builder<saldoPost>()
                .setQuery(query, saldoPost.class)
                .build();
        adapter = new MyDetailUserTaskRecyclerViewAdapter(options);
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
