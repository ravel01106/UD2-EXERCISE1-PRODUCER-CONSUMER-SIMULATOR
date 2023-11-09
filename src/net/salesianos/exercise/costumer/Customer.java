package net.salesianos.exercise.costumer;

import net.salesianos.exercise.restaurant.Restaurant;
import net.salesianos.exercise.vegetable.Vegetable;

public class Customer extends Thread{
    private String name;
    private int quantityVegetablesConsumed;
    private int vegetablesConsumed;
    private Restaurant restaurant;

    public Customer(String name, int quantityVegetablesConsumed, Restaurant restaurant){
        this.name = name;
        this.quantityVegetablesConsumed = quantityVegetablesConsumed;
        this.vegetablesConsumed = 0;
        this.restaurant = restaurant;
    }

    public int calculateTimeConsumtion(){
        return (int)(Math.floor(Math.random()*(15-1+1)+1));
    }

    @Override
    public void run(){
        for (int i = 0; i < quantityVegetablesConsumed; i++) {
            try {
                Vegetable vegatable = new Vegetable();
                Thread.sleep(calculateTimeConsumtion()*100);
                restaurant.eatVegetable(vegatable);
                this.vegetablesConsumed++;
                System.out.println("-> El cliente " + this.name + " está consumiendo un vegetal.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getVegetablesConsumed() {
        return vegetablesConsumed;
    }

    

}
