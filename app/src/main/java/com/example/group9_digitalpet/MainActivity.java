package com.example.group9_digitalpet;

import android.content.Context;
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


public class MainActivity extends AppCompatActivity
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
        setContentView(R.layout.landing_page);

        /* //      Start up the game
        healthBar = findViewById(R.id.healthBarID);
        level = findViewById(R.id.levelTextViewID);
        lovePoints = findViewById(R.id.lovePointsTextViewID);
        name = findViewById(R.id.nameTextViewID);
        */
        handler.post(runnableCode);
        EditText petName = (EditText)findViewById(R.id.petName);
        ImageView petView = (ImageView)findViewById(R.id.petView);
        ImageButton dog1 = (ImageButton)findViewById(R.id.imageButton);
        dog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Chosen pet is beagle
                petView.setImageResource(R.drawable.beagle);
            }
        });
        ImageButton dog2 = (ImageButton)findViewById(R.id.imageButton2);
        dog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Chosen pet is bulldog
                petView.setImageResource(R.drawable.bulldog);
            }
        });
        ImageButton dog3 = (ImageButton)findViewById(R.id.imageButton3);
        dog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Chosen pet is chihuahua
                petView.setImageResource(R.drawable.chihuahua);
            }
        });
        ImageButton dog4 = (ImageButton)findViewById(R.id.imageButton4);
        dog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Chosen pet is Chowchow
                petView.setImageResource(R.drawable.chowchow);
            }
        });
        ImageButton dog5 = (ImageButton)findViewById(R.id.imageButton5);
        dog5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Chosen pet is Golden Retriever
                petView.setImageResource(R.drawable.goldenretriever);
            }
        });
        ImageButton dog6 = (ImageButton)findViewById(R.id.imageButton6);
        dog6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Chosen pet is Husky
                petView.setImageResource(R.drawable.husky);
            }
        });
        ImageButton dog7 = (ImageButton)findViewById(R.id.imageButton7);
        dog7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Chosen pet is Poodle
                petView.setImageResource(R.drawable.poodle);
            }
        });
        ImageButton dog8 = (ImageButton)findViewById(R.id.imageButton8);
        dog8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Chosen pet is Samoyed
                petView.setImageResource(R.drawable.samoyed);
            }
        });
        ImageButton dog9 = (ImageButton)findViewById(R.id.imageButton9);
        dog9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Chosen pet is Shiba
                petView.setImageResource(R.drawable.shiba);
            }
        });

        //Need to do the pet name and what happens when 'start game' button is pressed
          Button startGame = (Button)findViewById(R.id.startGame);
          startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // I added this I believe this should get the pet name from the user when they press
                // The start game button, still need to change to main screen with the same button press
                pet = new Pet(String.valueOf(petName), 0, 100, 100, 100, 100, 100 , 0 , 1);
                setContentView(R.layout.activity_main);

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