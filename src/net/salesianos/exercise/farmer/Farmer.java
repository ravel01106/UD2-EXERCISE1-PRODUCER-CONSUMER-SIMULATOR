package net.salesianos.exercise.farmer;

import net.salesianos.exercise.restaurant.Restaurant;
import net.salesianos.exercise.vegetable.Vegetable;

public class Farmer  extends Thread{
    private String name;
    private int maximumPlanting;
    private int vegetablesProduced;
    private Restaurant restaurant;


    public Farmer(String name, int maximumPlanting, Restaurant restaurant){
        this.name = name;
        this.maximumPlanting = maximumPlanting;
        this.restaurant = restaurant;
        this.vegetablesProduced = 0;
    }

    @Override
    public void run(){
        for (int i = 0; i < this.maximumPlanting; i++) {
            try {
                Vegetable vegetable = new Vegetable();
                Thread.sleep(vegetable.getGrowingTime()*100);
                restaurant.storeVegetable(vegetable);
                this.vegetablesProduced++;
                System.out.println("-> El granjero " + this.name + " ha añadido una verdura al restaurante.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getVegetablesProduced() {
        return vegetablesProduced;
    }

    
}
