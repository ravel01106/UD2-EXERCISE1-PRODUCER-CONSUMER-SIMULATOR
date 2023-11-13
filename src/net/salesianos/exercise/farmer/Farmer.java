package net.salesianos.exercise.farmer;

import net.salesianos.exercise.restaurant.Restaurant;
import net.salesianos.exercise.vegetable.Vegetable;

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
                Thread.sleep(vegetable.getGrowingTime()*1000);
                restaurant.storeVegetable(vegetable);
                this.vegetablesProduced++;
                System.out.println("-> El granjero " + this.nameFarmer + " ha añadido una verdura al restaurante.");
                System.out.println("\t-> Estado del almacen: " + restaurant.getVegetableCollectionSize());
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
