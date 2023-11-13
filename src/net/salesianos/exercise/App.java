package net.salesianos.exercise;

import java.util.ArrayList;

import net.salesianos.exercise.objects.restaurant.Restaurant;
import net.salesianos.exercise.threads.customer.Customer;
import net.salesianos.exercise.threads.farmer.Farmer;
import net.salesianos.exercise.utils.Utils;

public class App {

    public static void main(String[] args){
        Restaurant restaurant = new Restaurant(6);
        ArrayList<Farmer> farmerCollection = new ArrayList<>();
        ArrayList<Customer> customerCollection = new ArrayList<>();

        Farmer farmerOne = new Farmer("Adrian", 10, restaurant);
        Farmer farmerTwo = new Farmer("Saul", 10, restaurant);
        farmerCollection.add(farmerOne);
        farmerCollection.add(farmerTwo);

        Customer customerOne = new Customer("Oliver", 5, restaurant);
        Customer customerTwo = new Customer("David", 10, restaurant);
        Customer customerThree = new Customer("Marco", 5, restaurant);
        customerCollection.add(customerOne);
        customerCollection.add(customerTwo);
        customerCollection.add(customerThree);

        System.out.println("\t-> Initial warehouse status: " + restaurant.getVegetableCollectionSize());

        for (Farmer farmer : farmerCollection) {
            farmer.start();
        }
        for (Customer customer : customerCollection) {
            customer.start();
        }
        try {
            for (Farmer farmer : farmerCollection) {
                farmer.join();
            }
            for (Customer customer : customerCollection) {
                customer.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Utils.printResultThreads(farmerCollection, customerCollection, restaurant);
        
    }
}
