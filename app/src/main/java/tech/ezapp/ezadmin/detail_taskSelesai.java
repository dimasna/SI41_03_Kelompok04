package tech.ezapp.ezadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class detail_taskSelesai extends AppCompatActivity {

    FirebaseFirestore db;
    RecyclerView mRecyclerView;
    ArrayList<Model> modelArrayList;
    myAdapterselesai adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task_selesai);

        modelArrayList = new ArrayList<>();
        setUpRecyclerView();
        setUpFireBase();
        addTestDatasToFirebase();
        loadDataFromFirebase();
    }

    private void loadDataFromFirebase() {
        if(modelArrayList.size()>0)
            modelArrayList.clear();
        db.collection("task")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot querySnapshot: task.getResult()) {
                            Model title = new Model(querySnapshot.getString("title"), querySnapshot.getString("description"));
                            modelArrayList.add(title);
                        }
                        adapter = new myAdapterselesai(detail_taskSelesai.this, modelArrayList);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(detail_taskSelesai.this, "Problem", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void addTestDatasToFirebase() {

        Random random = new Random();

        for (int i =0; i< 2; i++) {
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("Anterin Katering", "Stefen Lisp" + random.nextInt(50));
            dataMap.put("Buatin Aplikasi Android", "Remaar Lee" + random.nextInt(50));

            db.collection("task")
                    .add(dataMap)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(detail_taskSelesai.this, "Added test datas", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private void setUpFireBase() {
        db = FirebaseFirestore.getInstance();
    }

    private void setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.taskRecyler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(detail_taskSelesai.this,AnalisisFragment.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}