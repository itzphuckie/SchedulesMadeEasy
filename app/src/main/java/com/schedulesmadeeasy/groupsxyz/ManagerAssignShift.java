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
    String[] time = {"N/A", "12:00 A.M.", "12:30 A.M.", "1:00 A.M.", "1:30 A.M.", "2:00 A.M.", "2:30 A.M.", "3:00 A.M.", "3:30 A.M.", "4:00 A.M.",
            "4:30 A.M.", "5:00 A.M.", "5:30 A.M.", "6:00 A.M.", "6:30 A.M.", "7:00 A.M.", "7:30 A.M.", "8:00 A.M.", "8:30 A.M.", "9:00 A.M.",
            "9:30 A.M.", "10:00 A.M.", "10:30 A.M.", "11:00 A.M.", "11:30 A.M.",
            "12:00 P.M.", "12:30 P.M.", "1:00 P.M.", "1:30 P.M.", "2:00 P.M.", "2:30 P.M.", "3:00 P.M.", "3:30 P.M.", "4:00 P.M.",
            "4:30 P.M.", "5:00 P.M.", "5:30 P.M.", "6:00 P.M.", "6:30 P.M.", "7:00 P.M.", "7:30 P.M.", "8:00 P.M.", "8:30 P.M.", "9:00 P.M.",
            "9:30 P.M.", "10:00 P.M.", "10:30 P.M.", "11:00 P.M.", "11:30 P.M."
            };

    String[] shifts = {"N/A", "M(9-3)", "M(3-9)"};
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
