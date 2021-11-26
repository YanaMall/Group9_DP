package com.example.group9_digitalpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
    }
    private int HatPrice; // placeholder for the cost of the hat
    private int PetPrice; // placeholder for the cost of the pet
    private int Currency; // this is the currency for the entire app
    public StoreActivity(int petPrice, int hatPrice, int currency){
        PetPrice = petPrice;
        HatPrice = hatPrice;
        Currency = currency;
    }

    // class contains selection of items for user to buy.
    public void item(){

    }

    public void Purchase(){

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
    }
}

}