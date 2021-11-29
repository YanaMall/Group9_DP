package com.example.group9_digitalpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoreActivity extends AppCompatActivity {
    public int Snacks = 0;
    public int Kibbles = 0;
    public int Steaks = 0;
    TextView snackCount;
    TextView kibbleCount;
    TextView steakCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        snackCount = (TextView) findViewById(R.id.snack);
        kibbleCount = (TextView) findViewById(R.id.kibble);
        steakCount = (TextView) findViewById(R.id.steak);
        Button backToMain = (Button)findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(StoreActivity.this, PetViewActivity.class);
                startActivity(i);
            }
        });

        Button snack = (Button)findViewById(R.id.button);
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Snacks++;
                snackCount.setText(Integer.toString(Snacks));
            }
        });

        Button kibble = (Button)findViewById(R.id.button2);
        kibble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Kibbles++;
                kibbleCount.setText(Integer.toString(Kibbles));
            }
        });

        Button steak = (Button)findViewById(R.id.button3);
        steak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Steaks++;
                steakCount.setText(Integer.toString(Steaks));
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