package com.example.group9_digitalpet;
import android.view.View;

public class GameActivity extends Pedometer
{
    private Pet pet;
    private Pedometer pedometer;
    private Log log;
    private long startTime;
    private long endTime;
    public long timeElapsed;

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

    public void onStartButtonClicked(View view)
    {
        startTime = System.currentTimeMillis();
    }

    public void onEndButtonClicked(View view)
    {
        endTime = System.currentTimeMillis();
        timeElapsed = (endTime - startTime) / 1000;
        Log newLog  = log.createLog(timeElapsed);
        pedometer.resetSteps();
    }
}
