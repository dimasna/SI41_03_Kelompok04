package tech.ezapp.ezadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class PostDetail extends AppCompatActivity {
    private String mJudul,mDeskripsi,mRequirement,mPoster,mStatus,mDocId;
    private TextView tvJudul,tvDeskripsi,tvRequirement,tvPoster,tvStatus;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_post_detail);
        ImageView toolbar = findViewById(R.id.back);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });

        mJudul = getIntent().getExtras().get("judul").toString();
        mDeskripsi = getIntent().getExtras().get("deskripsi").toString();
        mRequirement = getIntent().getExtras().get("requirement").toString();
        mPoster = getIntent().getExtras().get("poster").toString();
        mStatus = getIntent().getExtras().get("status").toString();
        mDocId = getIntent().getExtras().get("docId").toString();

        tvJudul = findViewById(R.id.judul);
        tvJudul.setText(mJudul);

        tvDeskripsi = findViewById(R.id.deskripsi);
        tvDeskripsi.setText(mDeskripsi);

        tvRequirement = findViewById(R.id.requirement);
        tvRequirement.setText(mRequirement);

        tvPoster = findViewById(R.id.poster);
        tvPoster.setText(mPoster);

        tvStatus = findViewById(R.id.status);
        tvStatus.setText(mStatus);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        currentUser = mAuth.getCurrentUser();

    }



    public void revisi(View view) {
        Intent intent = new Intent(this, RevisiActivity.class);
        intent.putExtra("docId", mDocId);
        startActivity(intent);
    }

    public void hapus(View view) {
        db.collection("draftPosts").document(mDocId)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), R.string.statusHapusBerhasil, Toast.LENGTH_SHORT).show();
                        Intent home = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(home);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), R.string.statusHapusGagal, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void konfirmasi(View view) {
        db.collection("draftPosts").document(mDocId).update("status","konfirmasi").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), R.string.statusKonfirmasiBerhasil, Toast.LENGTH_SHORT).show();
                Intent home = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(home);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), R.string.statusKonfirmasiGagal, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
