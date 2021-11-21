package com.example.group9_digitalpet;
// need to find a way to access currency in multiple classes.
public class Store {
    private int HatPrice; // placeholder for the cost of the hat
    private int PetPrice; // placeholder for the cost of the pet

    public Store(int petPrice, int hatPrice){
        PetPrice = petPrice;
        HatPrice = hatPrice;
    }

    // class contains selection of items for user to buy.
    public void item(){

    }

    public void Purchase(){

    }

    public void checkCurrency(int currency){
        if (currency >= HatPrice){
            // give confirmation message to the user
            // If given confirmation
            currency -= HatPrice;
        }
        else{
            // send message to user to tell them that they do not have enough currency
        }
    }
}
