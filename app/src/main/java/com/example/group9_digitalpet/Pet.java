package com.example.group9_digitalpet;
import static java.lang.Math.abs;

class Pet
{
    private String name;
    private int hunger;
    private int health;
    private int happiness;
    private int awayTime;
    public Pet(String Name, int Hunger, int Health, int Happiness, int AwayTime)
    {
        name = Name;
        hunger = Hunger;
        health = Health;
        happiness = Happiness;
        awayTime = AwayTime;
    }

    public void feedPet (int foodPoints)
    {
        if(foodPoints == 5)
        {
            updateHunger(5, true);
        }
        else if(foodPoints == 10)
        {
            updateHunger(10, true);
        }
        else if(foodPoints == 15)
        {
            updateHunger(15, true);
        }
    }

    public void updateHealth (int health2)
    {
        if(health + health2 > 100)
        {
            health = 100;
        }
        else if(health + health2 <= 0)
        {
            health = 0;
        }
        else
        {
            health += health2;
        }
    }

    public void updateHunger (int food, boolean fed)
    {
        if(hunger + food > 100)
        {
            hunger = 100;
        }
        else if(hunger + food <= 0)
        {
            hunger = 0;
            updateHealth(food);
        }
        else
        {
            if(fed)
            {
                hunger += food;
                happiness(5, false);
                updateHealth(5);
            }
        }
    }

    public void customize ()
    {
        // Closet for clothes/hats?
    }

    public void happiness (int happy, boolean happy2)
    {
        // Need to incorporate walks
        if(happiness + happy > 100)
        {
            happiness = 100;
        }
        else if(happiness + happy <= 0)
        {
            if(!happy2)
            {
                updateHealth(-(abs(happiness + happy)));
            }
        }
        else
        {
            happiness += happy;
        }
    }

    public void levelUp ()
    {
        // What will leveling up do?
    }

    public void viewInventory ()
    {
        // Closet for clothes/hats?
    }

    public void changePet ()
    {
        // Multiple pets? Switching current pet?
    }

    public void updateAwayTime(int time)
    {
        // 15 minutes
        if((time - awayTime) / 900 > 0){
            int hoursAway = (time - awayTime) / 900;
            //updateHealth(-hoursAway, false);
            updateHunger(-hoursAway, false);
            happiness(-hoursAway, false);
        }
        awayTime = time;
    }
}