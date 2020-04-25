package tech.ezapp.ezadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEmailField;
    private EditText mPasswordField;
    private static final String TAG = "EmailPassword";
    FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailField = findViewById(R.id.emailField);
        mPasswordField = findViewById(R.id.passwordField);

        findViewById(R.id.loginBtn).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


    }


    @Override
    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.loginBtn) {
            signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());
        }
    }

    private void signIn(final String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        //showProgressDialog();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            currentUser = mAuth.getCurrentUser();

                            Log.d(TAG, "signInWithEmail:success");
                            SharedPreferences sharedPreferences
                                    = getSharedPreferences("akun",
                                    MODE_PRIVATE);
                            SharedPreferences.Editor myEdit
                                    = sharedPreferences.edit();
                            myEdit.putString("email",
                                    email);
                            myEdit.putString("userId",
                                    currentUser.getUid());
                            myEdit.putBoolean("is_logged_before",true);
                            myEdit.commit();
                            Intent home = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(home);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Email/Password Anda Salah",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // [START_EXCLUDE]
//                        if (!task.isSuccessful()) {
//                            mStatusTextView.setText(R.string.auth_failed);
//                        }
//                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        return valid;
    }
}
