package com.schedulesmadeeasy.groupsxyz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ManagerScheduleActivity extends AppCompatActivity {
    private EditText mUsernameEditText;
    private Button   mAddUsernameButton;
    private String mID;
    private String mTitle;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mRef;
    private Group mGroup;
    String TAG = "MANAGERSCHEDULE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_schedule);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG, "IN APP MANAGER");

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            mID = extras.getString("ID");
            mTitle = extras.getString("TITLE");
        }
        mUsernameEditText = findViewById(R.id.addMemberEditText);
        mAddUsernameButton = findViewById(R.id.addMemberButton);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        String reference = "users/" + mUser.getUid() + "/groups/" + mID;
        mRef = FirebaseDatabase.getInstance().getReference(reference);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mGroup = dataSnapshot.getValue(Group.class);
                if(mGroup == null){
                    Log.d(TAG, "could not find group");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAddUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm()){
                    addUserToGroup();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void addUserToGroup(){
        String username = mUsernameEditText.getText().toString();
        String reference = "usernames/" + username;
        DatabaseReference usernamesRef = FirebaseDatabase.getInstance().getReference(reference);
        usernamesRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String key;
                key = dataSnapshot.getValue(String.class);
                Log.d(TAG, "KEY: " + key);
                if(key == null){
                    Toast.makeText(getApplicationContext(), "USERNAME DOESN'T EXIST",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private boolean validateForm(){
        boolean valid = true;
        String username = mUsernameEditText.getText().toString();
        if(TextUtils.isEmpty(username)){
            mUsernameEditText.setError("Required");
            valid = false;
        }else{
            mUsernameEditText.setError(null);
        }

        return valid;
    }

}