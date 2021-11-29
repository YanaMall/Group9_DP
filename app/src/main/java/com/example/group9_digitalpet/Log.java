package com.example.group9_digitalpet;

import java.time.LocalDate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class Log extends AppCompatActivity
{
    private int logCount;
    Pedometer pedometer;
    int step;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewlogs);

        createLog(pedometer.getCurrentSteps());
        //This finds the tablelayout element
        TableLayout tableLayout = (TableLayout)findViewById(R.id.logTable);
        //this is the row to added to the table
        TableRow tr = new TableRow(this);
        //Log Number
        TextView logcount = new TextView(this);
        logcount.setText(logCount++);
        tr.addView(logcount);
        //Date
        TextView date = new TextView(this);
        date.setText(29/11);
        tr.addView(date);
        //Steps Taken
        TextView stepsTaken = new TextView(this);
        stepsTaken.setText(step);
        tr.addView(stepsTaken);
        //Distance
        TextView distance = new TextView(this);
        distance.setText(step);
        tr.addView(distance);
        //Duration
        TextView duration = new TextView(this);
        duration.setText(step);
        tr.addView(duration);

        //Add row to table
        tableLayout.addView(tr);
    }

    public void createLog(long elapsed)
    {
        step = pedometer.getCurrentSteps();
        long duration = elapsed;
        LocalDate currentDate = LocalDate.of(2021, 11, 29);
        /*var Distance; will this data be pulled from map activity?*/
        //return null;
    }
}
