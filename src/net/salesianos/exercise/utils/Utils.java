package net.salesianos.exercise.utils;

import java.util.ArrayList;

import net.salesianos.exercise.objects.restaurant.Restaurant;
import net.salesianos.exercise.threads.customer.Customer;
import net.salesianos.exercise.threads.farmer.Farmer;

public class Utils {
    public static void printResultThreads(ArrayList<Farmer> farmerCollection, ArrayList<Customer> customerCollection, Restaurant restaurant){
        int totalProduced = 0;
        int totalConsumed = 0;
        System.out.println("--------------------------RESULT--------------------------\n");
        System.out.println("\n--------------------------FARMER--------------------------\n");
        for (Farmer farmer : farmerCollection) {
            System.out.println("-> The quantity of vegetables produced by " + farmer.getNameFarmer() + " are: " + farmer.getVegetablesProduced());
            totalProduced += farmer.getVegetablesProduced();
        }
        System.out.println("-> Total quantity of vegetables produced: " + totalProduced);
        System.out.println("\n\n-------------------------CUSTOMER-------------------------\n");
        for (Customer customer : customerCollection) {
            System.out.println("-> The quantity of vegetables consumed by " + customer.getNameCustomer() + " are: " + customer.getVegetablesConsumed());
            totalConsumed += customer.getVegetablesConsumed();
        }
        System.out.println("-> Total quantity of vegetables consumed: " + totalConsumed);
        System.out.println("-> Warehouse status: " + restaurant.getVegetableCollectionSize());
        System.out.println("\n\n--------------------------RESULT--------------------------");
    }
}
