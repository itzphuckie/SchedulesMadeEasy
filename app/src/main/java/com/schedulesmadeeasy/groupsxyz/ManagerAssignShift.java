package com.schedulesmadeeasy.groupsxyz;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;

public class ManagerAssignShift extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    String[] time = {}; // name 1

    String[] shifts = {}; // name 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_assign_shift);
        // Spinner 1
        final Spinner spin2 = (Spinner) findViewById(R.id.timeSpinnerManager2);
        spin2.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, time);
        a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin2.setAdapter(a2);
        // Spinner 2
        final Spinner spin3 = (Spinner) findViewById(R.id.timeSpinnerManager3);
        spin3.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter a3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, time);
        a3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin3.setAdapter(a3);

        // Spinner 3
        final Spinner spin4 = (Spinner) findViewById(R.id.timeSpinnerManager4);
        spin4.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter a4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, time);
        a4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin4.setAdapter(a4);

        // Spinner 4
        final Spinner spin5 = (Spinner) findViewById(R.id.timeSpinnerManager5);
        spin5.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter a5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, time);
        a5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin5.setAdapter(a5);

        // Spinner 1=5
        final Spinner spin6 = (Spinner) findViewById(R.id.timeSpinnerManager6);
        spin6.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter a6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, time);
        a6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin6.setAdapter(a6);

        // Spinner 7
        final Spinner spin7 = (Spinner) findViewById(R.id.timeSpinnerManager7);
        spin7.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter a7 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, time);
        a7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin7.setAdapter(a7);

        // Shift Spinner
        // Spinner 1
        final Spinner shift = (Spinner) findViewById(R.id.shiftSpinnerManager);
        shift.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, shifts);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        shift.setAdapter(aa);

        // Spinner 2
        final Spinner shift2 = (Spinner) findViewById(R.id.shiftSpinnerManager2);
        shift2.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, shifts);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        shift2.setAdapter(aa2);

        // Spinner 3
        final Spinner shift3 = (Spinner) findViewById(R.id.shiftSpinnerManager3);
        shift3.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, shifts);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        shift3.setAdapter(aa3);

        // Spinner 4
        final Spinner shift4 = (Spinner) findViewById(R.id.shiftSpinnerManager4);
        shift4.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, shifts);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        shift4.setAdapter(aa4);

        // Spinner 5
        final Spinner shift5 = (Spinner) findViewById(R.id.shiftSpinnerManager5);
        shift5.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, shifts);
        aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        shift5.setAdapter(aa5);

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //Toast.makeText(getApplicationContext(), time[position], Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }




}
