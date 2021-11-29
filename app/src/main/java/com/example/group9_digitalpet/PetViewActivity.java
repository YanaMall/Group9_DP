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
        EditText petName = (EditText)findViewById(R.id.petName);
        final ImageView petView = (ImageView) findViewById(R.id.petView);

        // I added this I believe this should get the pet name from the user when they press
        // The start game button, still need to change to main screen with the same button press
        pet = new Pet(String.valueOf(petName), 0, 100, 100, 100, 100, 100);
        petView.setImageResource(MainActivity.petChoice);

        Button shopButton = (Button)findViewById(R.id.shopButton);
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(PetViewActivity.this, StoreActivity.class);
                startActivity(intent);
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