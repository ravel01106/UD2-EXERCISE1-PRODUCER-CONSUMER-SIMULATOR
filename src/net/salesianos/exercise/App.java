package net.salesianos.exercise;

import net.salesianos.exercise.objects.restaurant.Restaurant;
import net.salesianos.exercise.threads.customer.Customer;
import net.salesianos.exercise.threads.farmer.Farmer;
import net.salesianos.exercise.utils.Utils;

public class App {

    public static void main(String[] args){
        Restaurant restaurant = new Restaurant(3);

        Farmer farmerOne = new Farmer("Saúl", 5, restaurant);

        Customer customerOne = new Customer("Marco", 5, restaurant);

        System.out.println("\t-> Initial warehouse status: " + restaurant.getVegetableCollectionSize());
        farmerOne.start();
        customerOne.start();

        try {
            farmerOne.join();
            customerOne.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Utils.printResultThreads(farmerOne, customerOne, restaurant);
        
    }
}