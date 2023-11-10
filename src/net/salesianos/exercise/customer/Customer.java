package net.salesianos.exercise.customer;

import net.salesianos.exercise.restaurant.Restaurant;

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
        return (int)(Math.floor(Math.random()*(15-1+1)+1));
    }

    @Override
    public void run(){
        for (int i = 0; i < quantityVegetablesConsumed; i++) {
            try {
                Thread.sleep(calculateTimeConsumtion()*100);
                restaurant.eatVegetable();
                this.vegetablesConsumed++;
                System.out.println("-> El cliente " + this.nameCustomer + " está consumiendo un vegetal.");
                System.out.println("\t-> Estado del almacen: " + restaurant.getVegetableCollectionSize());
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
