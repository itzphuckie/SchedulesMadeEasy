package com.schedulesmadeeasy.groupsxyz;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.Calendar;

public class RequestActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    Button End_Date_Button;
    Button Start_Date_Button;
    TextView Start_Date_View;
    TextView End_Date_View;
    String startDate, endDate;
    int choice = 0;

    int day, month, year, hour, minute;
    String dayName;
    int dayOfWeek;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        Start_Date_Button = (Button) findViewById(R.id.Start_Date_Button);
        End_Date_Button = (Button) findViewById(R.id.End_Date_Button);
        Start_Date_View = (TextView) findViewById(R.id.Start_Date_View);
        End_Date_View = (TextView) findViewById(R.id.End_Date_View);
        Start_Date_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                choice = 1;
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(RequestActivity.this, RequestActivity.this, year, month, day);
                datePickerDialog.show();
            }

        });
        End_Date_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                choice = 2;
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(RequestActivity.this, RequestActivity.this, year, month, day);
                datePickerDialog.show();
            }

        });

    }

        public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
        {
            yearFinal = i;
            monthFinal = i1 + 1;
            dayFinal = i2;

            Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(RequestActivity.this, RequestActivity.this, hour, minute, DateFormat.is24HourFormat(this));
            timePickerDialog.show();
        }


        public void onTimeSet(TimePicker timePicker, int i, int i1)
        {
            Calendar c = Calendar.getInstance();
            hourFinal = i;
            minuteFinal = i1;
            dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            switch(dayOfWeek)
            {
                case 1:
                    dayName = "Monday";
                    break;
                case 2:
                    dayName = "Tuesday";
                    break;
                case 3:
                    dayName = "Tuesday";
                    break;
                case 4:
                    dayName = "Tuesday";
                    break;
                case 5:
                    dayName = "Tuesday";
                    break;
                case 6:
                    dayName = "Tuesday";
                    break;
                case 7:
                    dayName = "Tuesday";
                    break;
                default:
                    break;

            }
            if (choice == 1) {
                Start_Date_View.setText(dayName + " , " + dayFinal + " " + yearFinal + "\n" + hourFinal + ":" + minuteFinal);

                startDate = "" + dayFinal + hourFinal + minuteFinal;

                Toast.makeText(RequestActivity.this, startDate, Toast.LENGTH_SHORT).show();
            }
            else if (choice == 2)
            {
                End_Date_View.setText(dayName + " , " + dayFinal + " " + yearFinal + "\n" + hourFinal + ":" + minuteFinal);

                endDate = "" + dayFinal + hourFinal + minuteFinal;

                Toast.makeText(RequestActivity.this, endDate, Toast.LENGTH_SHORT).show();
            }


        }

    }

