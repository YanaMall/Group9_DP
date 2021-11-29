package com.example.group9_digitalpet;

public class Store {
    private int currency;
    private int snackCount;
    private int kibbleCount;
    private int steakCount;

    Store(int currency, int snackCount, int kibbleCount, int steakCount){
        this.currency = currency;
        this.snackCount = snackCount;
        this.kibbleCount = kibbleCount;
        this.steakCount = steakCount;
    }

    public int getCurrency(){
        return currency;
    }

    public void setCurrency(int newCurrency){
        currency += newCurrency;
    }

    public void decreaseCurrency(int newCurrency){
        currency -= newCurrency;
    }

    public int getSnackCount(){
        return snackCount;
    }

    public void setSnackCount(int newSnack){
        snackCount +=newSnack;
    }

    public int getKibbleCount(){
        return kibbleCount;
    }

    public void setKibbleCount(int newKibble){
        kibbleCount += newKibble;
    }

    public int getSteakCount(){
        return steakCount;
    }

    public void setSteakCount(int newSteak){
        steakCount += newSteak;
    }

    public void decreaseSnack() { snackCount -= 1; }

    public void decreaseKibble() { kibbleCount -= 1; }

    public void decreaseSteak() { steakCount -= 1; }

}
