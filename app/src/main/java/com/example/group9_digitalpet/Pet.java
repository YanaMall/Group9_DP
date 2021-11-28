package com.example.group9_digitalpet;
import static java.lang.Math.abs;

class Pet
{
    private String name;
    private int hunger;
    private int maxHunger;
    private int health;
    private int maxHealth;
    private int happiness;
    private int maxHappiness;
    private int awayTime;
    private int level;
    public Pet(String Name, int Hunger, int MaxHunger, int Health, int MaxHealth, int Happiness, int MaxHappiness, int AwayTime, int Level)
    {
        name = Name;
        hunger = Hunger;
        maxHunger = MaxHunger;
        health = Health;
        maxHealth = MaxHealth;
        happiness = Happiness;
        maxHappiness = MaxHappiness;
        awayTime = AwayTime;
        level = Level;
    }
    public String getPetName()
    {
        return name;
    }
    public int getPetHunger()
    {
        return hunger;
    }
    public int getPetHealth()
    {
        return health;
    }
    public int getPetHappiness()
    {
        return happiness;
    }
    public int getAwayTime()
    {
        return awayTime;
    }

    public void feedPet (int foodPoints)
    {
        if (foodPoints % 5 == 0 && foodPoints <= 15)
            updateHunger(foodPoints, true);

        /*if(foodPoints == 5)
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
        }*/
    }

    public void updateHealth (int health2)
    {
        health += health2;
        health = Math.min(health, maxHealth);
        health = Math.max(health, 0);

        /*if(health + health2 > 100)
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
        }*/
    }

    public void updateHunger (int food, boolean fed)
    {
        hunger += food;
        hunger = Math.min(hunger, maxHunger);

        if (hunger <= 0)
        {
            hunger = 0;
            updateHealth(food);
        }
        if (fed)
        {
            happiness(5, false);
            updateHealth(5);
        }

        /*if(hunger + food > 100)
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
        }*/
    }

    public void customize ()
    {
        // Closet for clothes/hats?
    }

    public void happiness (int happy, boolean happy2)
    {
        // Need to incorporate walks
        happiness += happy;
        happiness = Math.min(happiness, maxHappiness);

        if(happiness <= 0)
        {
            if(!happy2)
            {
                updateHealth(happiness);
            }
            happiness = 0;
        }

        /*if(happiness + happy > 100)
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
        }*/
    }

    public void levelUp ()
    {
        // What will leveling up do?
        level++;
        // just suggestions as to what could happen, also level could influence the decrease in stats?
        maxHealth += 50;
        maxHunger += 50;
        maxHappiness += 50;
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
        int timeIncrementsAway = (time - awayTime) / 900; // 15 minute increments
        int statDecrease = (int)(-1 * timeIncrementsAway * (1 / Math.log(level)));

        if(timeIncrementsAway > 0){
            //updateHealth(statDecrease, false);
            updateHunger(statDecrease, false);
            happiness(statDecrease, false);
        }
        awayTime = time;

        /*if((time - awayTime) / 900 > 0){
            int hoursAway = (time - awayTime) / 900;
            //updateHealth(-hoursAway, false);
            updateHunger(-hoursAway, false);
            happiness(-hoursAway, false);
        }
        awayTime = time;*/
    }

    public void setPetName(String petName){
        name = petName;
    }

    public void petChoice()
    {

    }
}