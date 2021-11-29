package com.example.group9_digitalpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Button backToMain = (Button)findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(StoreActivity.this, MainActivity.class);
                startActivity(i);
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