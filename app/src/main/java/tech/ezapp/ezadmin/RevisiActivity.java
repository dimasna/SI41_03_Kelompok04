package tech.ezapp.ezadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RevisiActivity extends AppCompatActivity {
    private static final String TAG = "PESAN";
    private FirebaseFirestore db;
    private EditText et;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisi);
        ImageView toolbar = findViewById(R.id.back);
        et = findViewById(R.id.pesanRevisi);
        et.setRawInputType(InputType.TYPE_CLASS_TEXT);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        currentUser = mAuth.getCurrentUser();



    }

    public void kirimRevisi(View view) {
        // Create a new user with a first and last name
        String pesan = et.getText().toString();
        final String idPost = getIntent().getExtras().get("docId").toString();

        final Map<String, Object> revisiObject = new HashMap<>();
        revisiObject.put("idPost", idPost);
        revisiObject.put("pesan", pesan);
        revisiObject.put("penilai", currentUser.getEmail());

// Add a new document with a generated ID
        db.collection("revisiPost")
                .add(revisiObject)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        db.collection("draftPosts").document(idPost).update("status","revisi").addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(), R.string.statusKirimBerhasil, Toast.LENGTH_SHORT).show();
                                Intent home = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(home);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), R.string.statusKirimGagal, Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), R.string.statusKirimGagal, Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
