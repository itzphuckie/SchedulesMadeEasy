package com.schedulesmadeeasy.groupsxyz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetUpActivity extends AppCompatActivity {
    private static final String TAG = "SETUP";
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private Button mButton;
    private EditText mUserName;
    private EditText mFirstName;
    private EditText mLastName;
    private DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        databaseUsers = FirebaseDatabase.getInstance().getReference("users");

        mButton = findViewById(R.id.setup_button);
        mUserName = findViewById(R.id.editTextUserNameSetup);
        mFirstName = findViewById(R.id.editTextFirstNameSetup);
        mLastName = findViewById(R.id.editTextLastNameSetup);

        /*
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName("Boats").build();
        mUser.updateProfile(profileUpdates);
        */

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateForm()){
                   return;
                }
                addUserInfo();
            }
        });
    }

    private void addUserInfo(){
        String user_name = mUserName.getText().toString().trim();
        String first_name = mFirstName.getText().toString().trim();
        String last_name = mLastName.getText().toString().trim();
        //Updating Name for User
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(mFirstName.getText().toString() + " " + mLastName.getText().toString()).build();

        String id = mUser.getUid();
        User user = new User(user_name, mUser.getEmail(), first_name, last_name, id);
        //ADDING USER TO DATABASE
        databaseUsers.child(id).setValue(user);
        Intent i = new Intent(getApplicationContext(), HomePageActivity.class);
        startActivity(i);
    }

    private boolean validateForm(){
        boolean valid = true;
        String user_name = mUserName.getText().toString().trim();
        if(TextUtils.isEmpty(user_name)){
            mUserName.setError("Required.");
            valid = false;
        }else{
            mUserName.setError(null);
        }

        String first_name = mFirstName.getText().toString().trim();
        if(TextUtils.isEmpty(first_name)){
            mFirstName.setError("Required.");
            valid = false;
        }else{
            mFirstName.setError(null);
        }

        String last_name = mLastName.getText().toString().trim();
        if(TextUtils.isEmpty(last_name)){
            mLastName.setError("Required.");
            valid = false;
        }else{
            mLastName.setError(null);
        }

        return valid;
    }
}
