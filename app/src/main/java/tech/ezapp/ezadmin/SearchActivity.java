package tech.ezapp.ezadmin;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import tech.ezapp.ezadmin.Model.Post;
import tech.ezapp.ezadmin.dummy.DummyContent;

public class SearchActivity extends AppCompatActivity implements SearchResultFragment.OnListFragmentInteractionListener{
    private MyPostRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private static FirebaseFirestore rootRef;
    private EditText queryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        ImageView toolbar = findViewById(R.id.back);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        rootRef = FirebaseFirestore.getInstance();

        queryText = findViewById(R.id.queryText);

        recyclerView = findViewById(R.id.searchResultLists);
        progressBar = findViewById(R.id.progressBar);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        queryText.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if(actionId == EditorInfo.IME_ACTION_SEARCH){
                            firebaseUserSearch(queryText.getText().toString());
                            return true;
                        }
                        return false;
                    }
                }
        );


            firebaseUserSearch("");


    }
    private void firebaseUserSearch(String searchText) {

        /*Toast.makeText(AllUserActivity.this, "Started Search", Toast.LENGTH_LONG).show();*/
        //progressBar.setVisibility(View.VISIBLE);


        Query firebaseSearchQuery = rootRef.collection("draftPosts").orderBy("judul").startAt(searchText).endAt(searchText + "\uf8ff");

        //set Options
        FirestoreRecyclerOptions<Post> options =
                new FirestoreRecyclerOptions.Builder<Post>()
                        .setQuery(firebaseSearchQuery, Post.class)
                        .setLifecycleOwner(this)
                        .build();

        adapter = new MyPostRecyclerViewAdapter(options);

        recyclerView.setAdapter(adapter);

    }


    @Override
    protected void onStart() {
        super.onStart();


    adapter.startListening();



    }

    @Override
    protected void onStop() {
        super.onStop();

        adapter.stopListening();
    }



    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
