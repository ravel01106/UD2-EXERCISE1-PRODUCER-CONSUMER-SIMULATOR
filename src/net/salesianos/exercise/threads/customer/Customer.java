package net.salesianos.exercise.threads.customer;

import net.salesianos.exercise.objects.restaurant.Restaurant;

public class Customer extends Thread{
    private String nameCustomer;
    private int quantityVegetablesConsumed;
    private int vegetablesConsumed;
    private Restaurant restaurant;

    public Customer(String name, int quantityVegetablesConsumed, Restaurant restaurant){
        this.nameCustomer = name;
        this.quantityVegetablesConsumed = quantityVegetablesConsumed;
        this.vegetablesConsumed = 0;
        this.restaurant = restaurant;
    }

    public int calculateTimeConsumtion(){
        return (int)(Math.floor(Math.random()*10));
    }

    @Override
    public void run(){
        for (int i = 0; i < quantityVegetablesConsumed; i++) {
            try {
                int timeConsumtion = calculateTimeConsumtion();
                System.out.println("\n-> The costumer " + this.nameCustomer + " is eating... will take " + timeConsumtion + " seconds...\n");
                Thread.sleep(timeConsumtion*1000);
                restaurant.eatVegetable(nameCustomer, timeConsumtion);
                this.vegetablesConsumed++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getVegetablesConsumed() {
        return vegetablesConsumed;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

}
