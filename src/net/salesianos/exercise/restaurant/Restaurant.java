package net.salesianos.exercise.restaurant;

import java.util.ArrayList;

import net.salesianos.exercise.vegetable.Vegetable;

public class Restaurant {
    private ArrayList<Vegetable> vegetableCollection = new ArrayList<>();
    private int maximumCapacity;

    public Restaurant(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
    }

    public synchronized void storeVegetable(Vegetable vegetable) throws InterruptedException{
        if (vegetableCollection.size() > maximumCapacity){
            wait();
        }
        vegetableCollection.add(vegetable);
    }

    public synchronized void eatVegetable(Vegetable vegetable) throws InterruptedException{
        if (vegetableCollection.size() >= 0) {
            wait();
        }
        vegetableCollection.remove(vegetable);
    }
}
