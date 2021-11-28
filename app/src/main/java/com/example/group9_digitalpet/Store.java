package com.example.group9_digitalpet;

public enum Store {
    Hat1("Hat1", 10),
    Hat2("Hat2", 15),
    Hat3("Hat3", 20);
// I think that maybe we should make it only accessories in the store we don't have the time to swap pets as well

    private final String accessoryName;
    private final int accessoryCost;

    Store (String accessoryName, int accessoryCost){
       this.accessoryName = accessoryName;
       this.accessoryCost = accessoryCost;
    }

    public String getAccessoryNameAcc() { return accessoryName; }
    public int getAccessoryCost() { return accessoryCost; }

}
