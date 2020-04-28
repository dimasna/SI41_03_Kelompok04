package tech.ezapp.ezadmin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UbahSandi extends AppCompatActivity {

    EditText etOld, etNew;
    Button btngantiPs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sandi_ubah);

        etNew = findViewById(R.id.newPas);
        etOld = findViewById(R.id.oldPass);

        btngantiPs = findViewById(R.id.btnUbahPass);

        btngantiPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String etOldPass, etNewPass;
                etNewPass = etNew.getText().toString();
                etOldPass = etOld.getText().toString();
                if (etOldPass.equals("")) {
                    Toast.makeText(UbahSandi.this, "Password6 is required", Toast.LENGTH_SHORT).show();
                } else if (etNewPass.equals("")) {
                    Toast.makeText(UbahSandi.this, "New Password is required", Toast.LENGTH_SHORT).show();
                } else if (etNewPass.length() < 6 && etOldPass.length() < 6) {
                    Toast.makeText(UbahSandi.this, "Password too short", Toast.LENGTH_SHORT).show();
                }
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), etOldPass);

                user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            user.updatePassword(etNewPass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(UbahSandi.this, "Password Changed", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(UbahSandi.this, "Password Not Changed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
    }

}