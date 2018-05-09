package com.schedulesmadeeasy.groupsxyz;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
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
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

public class ManagerScheduleActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private EditText mUsernameEditText;
    private Button   mAddUsernameButton;
    private String mID;
    private String mTitle;
    private SpeedDialView mSpeedDialView;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mRef;
    private Group mGroup;
    String TAG = "MANAGERSCHEDULE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_schedule);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar_manager_schedules);
        setSupportActionBar(toolbar);
        Log.d(TAG, "IN APP MANAGER");

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            mID = extras.getString("ID");
            mTitle = extras.getString("TITLE");
        }

        mUsernameEditText = findViewById(R.id.addMemberEditText);
        //mAddUsernameButton = findViewById(R.id.addMemberButton);
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

        /*
        mAddUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm()){
                    addUserToGroup();
                }
            }
        });
        */

        //FAB
        mSpeedDialView = findViewById(R.id.speedDialManager);
        mSpeedDialView.setMainFabOpenBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark, getTheme()));
        mSpeedDialView.setMainFabCloseBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()));

        mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_add_member, R.drawable.ic_add_member_white_24dp)
                .setLabel("Add Member")
                .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorFABADD, getTheme()))
                .create());

        Drawable drawable = AppCompatResources.getDrawable(ManagerScheduleActivity.this, R.drawable.ic_alarm_on_black_24dp);
        mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_custom_color, drawable)
                .setLabel("Assign Shifts")
                .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorFABRED, getTheme()))
                .create());

        mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_requests, R.drawable.ic_priority_high_black_24dp)
            .setLabel("Requests")
            .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorFABREQUESTS, getTheme()))
            .create());


        mSpeedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem actionItem) {
                switch(actionItem.getId()){
                    case R.id.fab_add_member:
                        Toast.makeText(getApplicationContext(), "CLICKED", Toast.LENGTH_SHORT).show();
                        Intent addMemberPage = new Intent(getApplicationContext(), AddMember.class);
                        addMemberPage.putExtra("ID", mID);
                        addMemberPage.putExtra("TITLE", mTitle);
                        startActivity(addMemberPage);
                        return false;
                    case R.id.fab_custom_color:
                        Intent nextFab = new Intent(getApplicationContext(), ManagerAssignShift.class);
                        nextFab.putExtra("ID", mID);
                        nextFab.putExtra("TITLE", mTitle);
                        startActivity(nextFab);
                        return false;
                    default:
                        return false;
                }
            }
        });


        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        final NavigationView navigationView = findViewById(R.id.nav_view_manager_schedules);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()

                {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        switch (item.getItemId()) {
                            case R.id.my_shifts:
                                Intent myShiftsPage = new Intent(getApplicationContext(), MyShifts.class);
                                startActivity(myShiftsPage);
                                break;

                            case R.id.action_settings:

                                Intent settingsPage = new Intent(getApplicationContext(), MySettingsActivity.class);
                                startActivity(settingsPage);
                                break;


                            case R.id.my_groups:
                                Intent groupPage = new Intent(getApplicationContext(), HomePageActivity.class);
                                startActivity(groupPage);
                                break;


                            case R.id.my_availability:
                                Intent availabilityPage = new Intent(getApplicationContext(), myAvailability.class);
                                startActivity(availabilityPage);
                                break;

                            case R.id.requests:
                                Intent requestsPage = new Intent(getApplicationContext(), RequestActivity.class);
                                startActivity(requestsPage);
                                break;

                        }
                        return true;
                    }
                }
        );


        //GETTING TOOLBAR
        mDrawerLayout = findViewById(R.id.drawer_layout_manager_schedules);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_manager_schedules);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

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
                }else{
                    //IF KEY EXISTS ADD USER TO GROUP
                    //TODO MAKE SURE USERNAME IS NOT SELF
                    String pushReference = "users/" + key + "/groups/" + mGroup.id;
                    Log.d(TAG, "REFERENCE: " + pushReference);
                    Log.d(TAG, "GROUP\n" + mGroup.toString());
                    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference(pushReference);
                    int groupMembers = Integer.parseInt(mGroup.getMembers()) + 1;
                    Group memberGroup = new Group(mGroup.title, groupMembers + "", "Member", mGroup.id);
                    userRef.setValue(memberGroup);
                    //ADD ONE TO YOUR OWN GROUP
                    pushReference = "users/" + mUser.getUid() + "/groups/" + mGroup.id;
                    userRef = FirebaseDatabase.getInstance().getReference(pushReference);
                    Group managerGroup = new Group(mGroup.title, groupMembers + "", "Manager", mGroup.id);
                    userRef.setValue(managerGroup);
                    Toast.makeText(getApplicationContext(), "USERNAME ADDED",
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //USER CHOSE SETTINGS ITEM, CHANGE TO APP SETTINGS SCREEN
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

            default:
                //USER'S ACTION WAS NOT RECOGNIZED.
                //INVOKE THE SUPERCLASS TO HANDLE IT.
                return super.onOptionsItemSelected(item);
        }
    }

}
