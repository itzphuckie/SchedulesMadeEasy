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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddGroupActivity extends AppCompatActivity {
    private Button mCreateGroup;
    private EditText mTitleEditText;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mRefUserGroups;
    private DatabaseReference mRefGroupInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        String reference = "users/" + mUser.getUid() + "/groups";
        mRefUserGroups = FirebaseDatabase.getInstance().getReference(reference);
        mRefGroupInfo = FirebaseDatabase.getInstance().getReference("groups");

        //MAKE BUTTON AND LISTENER
        mTitleEditText = findViewById(R.id.titleAddGroupEditText);
        mCreateGroup = findViewById(R.id.addGroupButton);
        mCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm()){
                    addGroupInfo();
                    //TODO POST "GROUP_ID":{ "events": "username": "time", "requests"..., "members"
                }
            }
        });
    }

    private void addGroupInfo(){
        String title = mTitleEditText.getText().toString();
        DatabaseReference groupRef = mRefUserGroups.push();
        groupRef.setValue(new Group(title, "1", "Manager", groupRef.getKey()));
        //TODO ADD ON SUCCESS LISTENER
        Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
        startActivity(intent);
    }

    private boolean validateForm(){
        boolean valid = true;
        String title = mTitleEditText.getText().toString();
        if(TextUtils.isEmpty(title)){
            mTitleEditText.setError("Required.");
            valid = false;
        }else{
            mTitleEditText.setError(null);
        }
        return valid;
    }
}
