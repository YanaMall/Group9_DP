package com.example.group9_digitalpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class StoreActivity extends AppCompatActivity {
    private int Snacks = MainActivity.store.getSnackCount();
    private int Kibbles = MainActivity.store.getKibbleCount();
    private int Steaks = MainActivity.store.getSteakCount();
    private int petHealth = MainActivity.pet.getPetHealth();
    TextView snackCount;
    TextView kibbleCount;
    TextView steakCount;
    TextView currencyCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        int storeCurrency = MainActivity.store.getCurrency();
        currencyCount = (TextView) findViewById(R.id.currency);
        currencyCount.setText(Integer.toString(storeCurrency));
        snackCount = (TextView) findViewById(R.id.snack);
        kibbleCount = (TextView) findViewById(R.id.kibble);
        steakCount = (TextView) findViewById(R.id.steak);
        snackCount.setText(Integer.toString(Snacks));
        kibbleCount.setText(Integer.toString(Kibbles));
        steakCount.setText(Integer.toString(Steaks));
        ProgressBar healthMeter = (ProgressBar)findViewById(R.id.progressBar);
        healthMeter.setProgress(MainActivity.pet.getPetHealth());
        Button backToMain = (Button)findViewById(R.id.backToMain);




        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
                //Intent i = new Intent(StoreActivity.this, PetViewActivity.class);
                //startActivity(i);
            }
        });

        Button snack = (Button)findViewById(R.id.button);
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int currency = MainActivity.store.getCurrency();

                if (currency >= 5) {
                    Snacks++;
                    MainActivity.store.decreaseCurrency(5);
                    snackCount.setText(Integer.toString(Snacks));
                    currency = MainActivity.store.getCurrency();
                    MainActivity.store.setSnackCount(1);
                    currencyCount.setText(Integer.toString(currency));
                }
                else{
                    Toast.makeText(StoreActivity.this, "insufficient currency", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button kibble = (Button)findViewById(R.id.button2);
        kibble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int currency = MainActivity.store.getCurrency();
                if (currency >= 10) {
                    Kibbles++;
                    MainActivity.store.decreaseCurrency(10);
                    kibbleCount.setText(Integer.toString(Kibbles));
                    currency = MainActivity.store.getCurrency();
                    MainActivity.store.setKibbleCount(1);
                    currencyCount.setText(Integer.toString(currency));
                }
                else{
                    Toast.makeText(StoreActivity.this, "insufficient currency", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button steak = (Button)findViewById(R.id.button3);
        steak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int currency = MainActivity.store.getCurrency();
                if (currency >= 15) {
                    Steaks++;
                    MainActivity.store.decreaseCurrency(15);
                    steakCount.setText(Integer.toString(Steaks));
                    currency = MainActivity.store.getCurrency();
                    MainActivity.store.setSteakCount(1);
                    currencyCount.setText(Integer.toString(currency));
                }
                else{
                    Toast.makeText(StoreActivity.this, "insufficient currency", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button feedSnack = (Button)findViewById(R.id.button4);
        feedSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (petHealth + 5 <= 100){
                    if (MainActivity.store.getSnackCount() > 0) {
                        MainActivity.pet.updateHealth(5);
                        MainActivity.store.decreaseSnack();
                        Snacks = MainActivity.store.getSnackCount();
                        snackCount.setText(Integer.toString(Snacks));
                        healthMeter.setProgress(MainActivity.pet.getPetHealth());
                    }
                    else {
                        Toast.makeText(StoreActivity.this, "Out of snacks", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(StoreActivity.this, "Pet is at full health", Toast.LENGTH_LONG).show();
                }
                petHealth = MainActivity.pet.getPetHealth();
            }
        });

        Button feedKibble = (Button)findViewById(R.id.button5);
        feedKibble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (petHealth + 10 <= 100){
                    if (MainActivity.store.getKibbleCount() > 0) {
                        MainActivity.pet.updateHealth(10);
                        MainActivity.store.decreaseKibble();
                        Kibbles = MainActivity.store.getKibbleCount();
                        kibbleCount.setText(Integer.toString(Kibbles));
                        healthMeter.setProgress(MainActivity.pet.getPetHealth());
                    }
                    else {
                        Toast.makeText(StoreActivity.this, "Out of kibble", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(StoreActivity.this, "Pet is at full health", Toast.LENGTH_LONG).show();
                }
                petHealth = MainActivity.pet.getPetHealth();
            }
        });

        Button feedSteak = (Button)findViewById(R.id.button6);
        feedSteak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (petHealth + 15 <= 100){
                    if (MainActivity.store.getSteakCount() > 0) {
                        MainActivity.pet.updateHealth(15);
                        MainActivity.store.decreaseSteak();
                        Steaks = MainActivity.store.getSteakCount();
                        steakCount.setText(Integer.toString(Steaks));
                        healthMeter.setProgress(MainActivity.pet.getPetHealth());
                    }
                    else {
                        Toast.makeText(StoreActivity.this, "out of steak", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(StoreActivity.this, "Pet is at full health", Toast.LENGTH_LONG).show();
                }
                petHealth = MainActivity.pet.getPetHealth();
            }
        });
    }
    /*private int HatPrice; // placeholder for the cost of the hat
    private String Hat;
    private int PetPrice; // placeholder for the cost of the pet
    private int Currency; // this is the currency for the entire app

    public StoreActivity(int petPrice, int hatPrice, int currency, String hat){
        PetPrice = petPrice;
        HatPrice = hatPrice;
        Hat = hat;
        Currency = currency;
    }

    // class contains selection of items for user to buy.
    public void item(Store store){
        Hat = store.getAccessoryNameAcc();
        HatPrice = store.getAccessoryCost();
    }

    public void Purchase() {

    }

    public void checkCurrency(){
        if (Currency >= HatPrice) {
            // give confirmation message to the user
            // If given confirmation
            Currency -= HatPrice;
        }
        else{
            // send message to user to tell them that they do not have enough currency
        }
    }

    // method that adds currency to the users account when various actions happen
    // takes in a variable which is the amount of currency to be added
    public void addCurrency(int amount){
        Currency += amount;
    }*/
}