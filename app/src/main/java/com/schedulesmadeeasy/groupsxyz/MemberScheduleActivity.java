package com.schedulesmadeeasy.groupsxyz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

public class MemberScheduleActivity extends AppCompatActivity {
    SpeedDialView mSpeedDialView;
    private String mID;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_schedules);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            mID = extras.getString("ID");
            mTitle = extras.getString("TITLE");
        }

        //FAB
        mSpeedDialView = findViewById(R.id.speedDialManagerMember);
        mSpeedDialView.setMainFabCloseBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark,
                getTheme()));
        mSpeedDialView.setMainFabOpenBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary,
                getTheme()));

        mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_my_availability, R.drawable.ic_availability_white_24dp)
            .setLabel("My Availability")
            .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorFABADD, getTheme()))
            .create());

        mSpeedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_requests_member, R.drawable.ic_priority_high_black_24dp)
            .setLabel("Requests")
            .setFabBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorFABREQUESTS, getTheme()))
            .create());
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
    }

}
