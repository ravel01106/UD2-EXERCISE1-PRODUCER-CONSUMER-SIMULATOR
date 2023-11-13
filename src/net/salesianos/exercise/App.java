package net.salesianos.exercise;

import java.util.ArrayList;

import net.salesianos.exercise.customer.Customer;
import net.salesianos.exercise.farmer.Farmer;
import net.salesianos.exercise.restaurant.Restaurant;
import net.salesianos.exercise.utils.Utils;

public class App {

    public static void main(String[] args){
        Restaurant restaurant = new Restaurant(6);
        ArrayList<Farmer> farmerCollaction = new ArrayList<>();
        ArrayList<Customer> customerCollaction = new ArrayList<>();


        Farmer farmerOne = new Farmer("Adrian", 10, restaurant);
        Farmer farmerTwo = new Farmer("Saul", 10, restaurant);
        farmerCollaction.add(farmerOne);
        farmerCollaction.add(farmerTwo);

        Customer customerOne = new Customer("Oliver", 5, restaurant);
        Customer customerTwo = new Customer("David", 10, restaurant);
        Customer customerThree = new Customer("Marco", 5, restaurant);
        customerCollaction.add(customerOne);
        customerCollaction.add(customerTwo);
        customerCollaction.add(customerThree);

        System.out.println("\t-> Initial warehouse status: " + restaurant.getVegetableCollectionSize());

        for (Farmer farmer : farmerCollaction) {
            farmer.start();
        }
        for (Customer customer : customerCollaction) {
            customer.start();
        }
        try {
            for (Farmer farmer : farmerCollaction) {
                farmer.join();
            }
            for (Customer customer : customerCollaction) {
                customer.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Utils.printResultThreads(farmerCollaction, customerCollaction, restaurant);
        
    }
}
