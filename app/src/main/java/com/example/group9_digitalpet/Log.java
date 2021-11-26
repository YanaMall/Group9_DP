package com.example.group9_digitalpet;

import java.time.LocalDate;

public class Log
{
    Pedometer pedometer;
    public Log createLog(long elapsed)
    {
        int step = pedometer.getCurrentSteps();
        long duration = elapsed;
        LocalDate currentDate = LocalDate.of(2021, 11, 29);
        /*var Distance; will this data be pulled from map activity?*/
        return null;
    }
}
