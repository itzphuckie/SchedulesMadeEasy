package com.schedulesmadeeasy.groupsxyz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyShifts extends AppCompatActivity {
    private List<Shift> shift;
    private RecyclerView rvShifts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shifts);
    }




    private void initializeData(){
        shifts = new ArrayList<>();
    }

    private void initializeAdapter(){
        GroupRVAdapter adapter = new GroupRVAdapter(shifts, this);
        rv.setAdapter(adapter);
    }



}
