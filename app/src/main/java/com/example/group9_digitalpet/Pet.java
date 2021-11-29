package com.example.group9_digitalpet;

class Pet
{
    private String name;
    private int health;
    private int maxHealth;
    private int happiness;
    private int maxHappiness;
    private int awayTime;
    private int level;
    public Pet(String Name, int Health, int MaxHealth, int Happiness, int MaxHappiness, int AwayTime, int Level)
    {
        name = Name;
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
    public int decreasePetHealth()
    {
        health -= 1;
        return health;
    }

    public void updateHealth (int health2)
    {
        health += health2;
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
    }



    public void updateAwayTime(int time)
    {
        int timeIncrementsAway = (time - awayTime) / 900; // 15 minute increments
        int statDecrease = (int)(-1 * timeIncrementsAway * (1 / Math.log(level)));

        if(timeIncrementsAway > 0){
            //updateHealth(statDecrease, false);
            happiness(statDecrease, false);
        }
        awayTime = time;
    }

    public String setPetName(String petName){
        name = petName;
        return petName;
    }
}