package com.schedulesmadeeasy.groupsxyz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//TODO MAKE EDIT TEXT EMPTY WHEN THEY FIRST CLICK ON IT, THEN MAKE IT EDITABLE FROM THE END
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "Login";
    private FirebaseAuth mAuth;
    private EditText mUserName;
    private EditText mPassword;
    private static int sUserNameCount;
    private static int sPasswordCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sUserNameCount = 0;
        sPasswordCount = 0;
        mUserName = findViewById(R.id.user_name_edit_text);
        mPassword = findViewById(R.id.password_edit_text);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            mUserName.setText(extras.getString("Email"));
        }

        //[START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        //[END initialize_auth]

        //LISTENERS//
        final Button button = findViewById(R.id.sign_in_button_login);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //TODO VALIDATE LOGIN CREDENTIALS
                String userName = mUserName.getText().toString();
                String passWord = mPassword.getText().toString();
                signIn(userName, passWord);

                //Intent intent = new Intent(v.getContext(), HomePageActivity.class);
                //startActivity(intent);
            }
        });

        mUserName.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(sUserNameCount == 0){
                    mUserName.setText("");
                    sUserNameCount++;
                }
            }
        });
        mPassword.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(sPasswordCount == 0){
                    mPassword.setText("");
                    sPasswordCount++;
                }
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        //Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    public void onBackPressed(){
        Log.d(TAG, "onBackPressed:LoginActivity");
        mAuth.signOut();
        Intent setIntent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(setIntent);
    }

    private void signIn(String email, String password){
        Log.d(TAG, "signIn: " + email);
        if(!validateForm()){
            return;
        }
        //showProgressDialog();
        //[START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }else{
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        if(!task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        //hideProgressDialog();
                    }
                });
        // [END sign_in_with_email]
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mUserName.getText().toString();
        if (TextUtils.isEmpty(email)){
            mUserName.setError("Required.");
            valid = false;
        }else{
            mUserName.setError(null);
        }

        String password = mPassword.getText().toString();
        if (TextUtils.isEmpty(password)){
            mPassword.setError("Required.");
        }else{
            mPassword.setError(null);
        }
        return valid;
    }

    /*
    private void signOut(){
        mAuth.signOut();
        updateUI(null);
    }*/

    private void updateUI(FirebaseUser user){
        if(user != null){
            if(user.isEmailVerified()){
                Intent i = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(i);
            }else{
                Toast.makeText(LoginActivity.this,
                        "Please verify email.",
                        Toast.LENGTH_LONG).show();
            }
        }else{
            mUserName.setText(R.string.placeholder_user_name);
            mPassword.setText(R.string.password_login);
            sPasswordCount = 0;
            sUserNameCount = 0;
        }
    }


}
