package com.example.group9_digitalpet;
import java.io.Serializable;

public class GameActivity implements Serializable
{
    private Pet pet;
    private int startTime;
    private int endTime;
    private Pedometer pedometer;

    public GameActivity(Pet pet)
    {
        this.pet = pet;
    }

    public void feed(Food food)
    {
        if(food.getFoodCost() < pet.getPetHealth())
        {
            int foodHealthValue = food.getFoodRestoreValue();
            int cost = food.getFoodCost();
            pet.feedPet(cost);
            pet.updateHealth(foodHealthValue);
        }
    }

    public void levelUp()
    {
        // Happiness and walking
    }

    public void onStartButtonClicked()
    {

    }

    public void onEndButtonClicked()
    {
        pedometer.createLog();
    }
}
