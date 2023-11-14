package net.salesianos.exercise.objects.restaurant;

import java.util.LinkedList;
import java.util.Queue;

import net.salesianos.exercise.objects.vegetable.Vegetable;

public class Restaurant {
    private Queue<Vegetable> vegetableCollection = new LinkedList<>();
    private int maximumCapacity;

    public Restaurant(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
    }

    public synchronized void storeVegetable(Vegetable vegetable, String nameFarmer ) throws InterruptedException{
        while (vegetableCollection.size() == maximumCapacity){
            wait();
        }
        notifyAll();
        vegetableCollection.add(vegetable);
        System.out.println("\n\n-> The farmer " + nameFarmer + " has added a " + vegetable.getName() + " in the restaurant.");
        System.out.println("\t-> The duration of vegetable growth is " + vegetable.getGrowingTime() + " seconds.");
        System.out.println("\t-> Warehouse status: " + vegetableCollection.size() + "\n");
    }

    public synchronized void eatVegetable(String nameCustomer, int timeConsumtion) throws InterruptedException{
        while (vegetableCollection.isEmpty()) {
            wait();
        }
        notifyAll();
        Vegetable vegetable = vegetableCollection.poll();
        System.out.println("\n\n-> The customer " + nameCustomer + " has consumed a " + vegetable.getName() + ".");
        System.out.println("\t-> The duration of vegetable consumed is " + timeConsumtion + " seconds.");
        System.out.println("\t-> Warehouse status: " + vegetableCollection.size() + "\n");
    }

    public int getVegetableCollectionSize(){
        return vegetableCollection.size();
    }
}
