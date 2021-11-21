package com.example.group9_digitalpet;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.time.LocalDate;

public class Pedometer extends AppCompatActivity implements SensorEventListener
{
    private float totalSteps;
    private float previousTotalSteps;
    private int currentSteps;
    TextView tv_steps;
    SensorManager sensorManager;
    Sensor sensor;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        tv_steps = (TextView) findViewById ( R.id.tv_steps );

        viewLog();
        resetSteps();

        sensorManager = (SensorManager) getSystemService ( Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume()
    {
        //A button to tap to start tracking walk?
        super.onResume ();
        running = true;
        Sensor stepSensor = sensorManager.getDefaultSensor ( sensor.TYPE_STEP_COUNTER );
        if(stepSensor!= null)
        {
            //This
            sensorManager.registerListener ( this,stepSensor,SensorManager.SENSOR_DELAY_UI );
        }
        else
        {
            //The device is too old to sense the sensor and can't show it
            Toast.makeText ( this,"SENSOR NOT FOUND",Toast.LENGTH_SHORT ).show ();
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause ();
        running = false;
        //if you unregister the hardware will stop detecting steps
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if (running)
        {
            totalSteps =  event.values[0];
            currentSteps = (int)totalSteps - (int)previousTotalSteps; //So its  a whole number
            tv_steps.setText(currentSteps); //need to set the current steps as what is viewed
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    public void resetSteps()
    {
        //A button to press to stop tracking walk?
        tv_steps.setOnClickListener(Toast.makeText(this, "Ending walk session", Toast.LENGTH_SHORT).show());
        previousTotalSteps =totalSteps; //updates the current total number of steps
        tv_steps.setText(0);
        createLog(); // creates and saves the record log
    }

    public void createLog()
    {
        int step = currentSteps;
        int duration = 0; //Using a timer in onStartButtonClicked in GameActivity?
        LocalDate currentDate = LocalDate.now();
        //Distance traveled
    }

    public void viewLog()
    {
        //Need to find a way to recall saved logs
    }
}
