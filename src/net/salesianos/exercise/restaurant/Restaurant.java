package net.salesianos.exercise.restaurant;

import java.util.ArrayList;

import net.salesianos.exercise.vegetable.Vegetable;

public class Restaurant {
    private ArrayList<Vegetable> vegetableCollection = new ArrayList<>();
    private int maximumCapacity;

    public Restaurant(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
    }

    public synchronized void storeVegetable(Vegetable vegetable ) throws InterruptedException{
        if (vegetableCollection.size() >= maximumCapacity){
            wait();
        }
        vegetableCollection.add(vegetable);
        notifyAll();
    }

    public synchronized void eatVegetable() throws InterruptedException{
        if (vegetableCollection.size() == 0) {
            wait();
        }
        vegetableCollection.remove(vegetableCollection.size() - 1);
        notifyAll();
    }

    public int getVegetableCollectionSize(){
        return vegetableCollection.size();
    }
}
