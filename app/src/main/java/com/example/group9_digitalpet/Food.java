package com.example.group9_digitalpet;

public enum Food
{
    Snack("Snack", 10, 5),
    Chicken("Chicken", 75, 30),
    Kibble("Kibble", 5, 1),
    Water("Water", 1, 10);

    private final String foodName;
    private final int foodCost;
    private final int foodRestoreValue;

    Food(String foodName, int foodCost, int foodRestoreValue)
    {
        this.foodName = foodName;
        this.foodCost = foodCost;
        this.foodRestoreValue = foodRestoreValue;
    }

    public String getFoodNameFood() {
        return foodName;
    }

    public int getFoodCost() {
        return foodCost;
    }

    public int getFoodRestoreValue() {
        return foodRestoreValue;
    }
}
