package net.salesianos.exercise;

import net.salesianos.exercise.farmer.Farmer;
import net.salesianos.exercise.restaurant.Restaurant;

public class App {
    public static void main(String[] args){
        Restaurant restaurant = new Restaurant(5);

        Farmer farmerOne = new Farmer("Paco", 4, restaurant);
        Farmer farmerTwo = new Farmer("Pepe", 2, restaurant);

        farmerOne.start();
        farmerTwo.start();
        try {
            farmerOne.join();
            farmerTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Los vegetables producidos en total son : " + (farmerOne.getVegetablesProduced() + farmerTwo.getVegetablesProduced()));
        
    }
}
