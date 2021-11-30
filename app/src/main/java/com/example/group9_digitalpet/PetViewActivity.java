package com.example.group9_digitalpet;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class PetViewActivity extends AppCompatActivity
{
    private GameActivity gameactivity;
    private Pet pet;
    private Pedometer pedometer;
    private Log log;
    int numOfWalks;
    Log[] logArray = new Log[numOfWalks];
    //handler will allow for the "timer" to run and decrease health/happiness
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.post(runnableCode);
        final ImageView petView = (ImageView) findViewById(R.id.petView);

        pet = MainActivity.pet;
        petView.setImageResource(MainActivity.petChoice);

        TextView petName = (TextView)findViewById(R.id.petNameLabel);
        petName.setText(pet.getPetName());

        Button shopButton = (Button)findViewById(R.id.shopButton);
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent swapToShop = new Intent(PetViewActivity.this, StoreActivity.class);
                startActivity(swapToShop);
            }
        });

        //Button labeled 'schedule walk with friends' is pressed, move to new xml
        Button friendWalk = (Button) findViewById(R.id.friendWalk);
        friendWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent swapToFW = new Intent(PetViewActivity.this, FriendWalk.class);
                startActivity(swapToFW);
            }
        });

        //Button labeled to view logs
        Button viewLogs = (Button) findViewById(R.id.viewlogs);
        viewLogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent swapToLog = new Intent(PetViewActivity.this, LogActivity.class);
                startActivity(swapToLog);
            }
        });
    }


    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            Log.d("Handlers", "Called on main thread");
           // pet.decreasePetHealth();
            handler.postDelayed(runnableCode, 1000);
          //  if (pet.getPetHealth() <= 0) {
           //     finish();
            //}
        }
    };
}