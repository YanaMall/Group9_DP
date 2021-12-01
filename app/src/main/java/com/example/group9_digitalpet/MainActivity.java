package com.example.group9_digitalpet;

import android.content.Context;
import android.content.Intent;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
{
    private GameActivity gameactivity;
    public static Pet pet;
    private Log log;
    public static Store store;
    int numOfWalks;
    Log[] logArray = new Log[numOfWalks];
    public static int petChoice;
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
        //handler.post(runnableCode);
        EditText petName = (EditText) findViewById(R.id.petName);
        final ImageView[] petView = {(ImageView) findViewById(R.id.petView)};
        ImageButton dog1 = (ImageButton) findViewById(R.id.imageButton);

        dog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chosen pet is beagle
                petView[0].setImageResource(R.drawable.beagle);
                petChoice = R.drawable.beagle;
            }
        });
        ImageButton dog2 = (ImageButton) findViewById(R.id.imageButton2);
        dog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chosen pet is bulldog
                petView[0].setImageResource(R.drawable.bulldog);
                petChoice = R.drawable.bulldog;
            }
        });
        ImageButton dog3 = (ImageButton) findViewById(R.id.imageButton3);
        dog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chosen pet is chihuahua
                petView[0].setImageResource(R.drawable.chihuahua);
                petChoice = R.drawable.chihuahua;
            }
        });
        ImageButton dog4 = (ImageButton) findViewById(R.id.imageButton4);
        dog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chosen pet is Chowchow
                petView[0].setImageResource(R.drawable.chowchow);
                petChoice = R.drawable.chowchow;
            }
        });
        ImageButton dog5 = (ImageButton) findViewById(R.id.imageButton5);
        dog5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chosen pet is Golden Retriever
                petView[0].setImageResource(R.drawable.goldenretriever);
                petChoice = R.drawable.goldenretriever;
            }
        });
        ImageButton dog6 = (ImageButton) findViewById(R.id.imageButton6);
        dog6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chosen pet is Husky
                petView[0].setImageResource(R.drawable.husky);
                petChoice = R.drawable.husky;
            }
        });
        ImageButton dog7 = (ImageButton) findViewById(R.id.imageButton7);
        dog7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chosen pet is Poodle
                petView[0].setImageResource(R.drawable.poodle);
                petChoice = R.drawable.poodle;
            }
        });
        ImageButton dog8 = (ImageButton) findViewById(R.id.imageButton8);
        dog8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chosen pet is Samoyed
                petView[0].setImageResource(R.drawable.samoyed);
                petChoice = R.drawable.samoyed;
            }
        });
        ImageButton dog9 = (ImageButton) findViewById(R.id.imageButton9);
        dog9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chosen pet is Shiba
                petView[0].setImageResource(R.drawable.shiba);
                petChoice = R.drawable.shiba;
            }
        });

        //Sets the pet name and starts game when button is pressed
        Button startGame = (Button) findViewById(R.id.startGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // I added this I believe this should get the pet name from the user when they press
                // The start game button, still need to change to main screen with the same button press
                pet = new Pet(String.valueOf(petName.getText()), 0, 100, 50, 100, 100, 100);
                store = new Store(100, 0, 0, 0);
                Intent startMain = new Intent(MainActivity.this, PetViewActivity.class);
                startActivity(startMain);
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
        });
    }


}