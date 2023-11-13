package net.salesianos.exercise.threads.farmer;

import net.salesianos.exercise.objects.restaurant.Restaurant;
import net.salesianos.exercise.objects.vegetable.Vegetable;

public class Farmer  extends Thread{
    private String nameFarmer;
    private int maximumPlanting;
    private int vegetablesProduced;
    private Restaurant restaurant;

    public Farmer(String name, int maximumPlanting, Restaurant restaurant){
        this.nameFarmer = name;
        this.maximumPlanting = maximumPlanting;
        this.restaurant = restaurant;
        this.vegetablesProduced = 0;
    }

    @Override
    public void run(){
        for (int i = 0; i < this.maximumPlanting; i++) {
            try {
                Vegetable vegetable = new Vegetable();
                System.out.println("\n-> A vegetable is growing... will take "+ vegetable.getGrowingTime() + " seconds..\n");
                Thread.sleep(vegetable.getGrowingTime()*1000);
                restaurant.storeVegetable(vegetable, this.nameFarmer);
                this.vegetablesProduced++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getVegetablesProduced() {
        return vegetablesProduced;
    }

    public String getNameFarmer() {
        return nameFarmer;
    }

}
