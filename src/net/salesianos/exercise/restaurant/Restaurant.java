package net.salesianos.exercise.restaurant;

import java.util.LinkedList;
import java.util.Queue;
//import java.util.ArrayList;

import net.salesianos.exercise.vegetable.Vegetable;

public class Restaurant {
    private Queue<Vegetable> vegetableCollection = new LinkedList<>();
    private int maximumCapacity;

    public Restaurant(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
    }

    public synchronized void storeVegetable(Vegetable vegetable ) throws InterruptedException{
        while (vegetableCollection.size() >= maximumCapacity){
            wait();
        }
        vegetableCollection.add(vegetable);
        notifyAll();
    }

    public synchronized void eatVegetable() throws InterruptedException{
        while (vegetableCollection.isEmpty()) {
            wait();
        }
        vegetableCollection.poll();
        notifyAll();
    }

    public int getVegetableCollectionSize(){
        return vegetableCollection.size();
    }
}
