package net.salesianos.exercise.utils;

import java.util.ArrayList;

import net.salesianos.exercise.customer.Customer;
import net.salesianos.exercise.farmer.Farmer;
import net.salesianos.exercise.restaurant.Restaurant;

public class Utils {
    public static void printResultThreads(ArrayList<Farmer> farmerCollation, ArrayList<Customer> customerCollation, Restaurant restaurant){
        int totalProduced = 0;
        int totalConsumed = 0;
        System.out.println("---------------------RESULTADOS---------------------");
        for (Farmer farmer : farmerCollation) {
            System.out.println("\t-> Vegetales producidos por " + farmer.getNameFarmer() + " son: " + farmer.getVegetablesProduced());
            totalProduced += farmer.getVegetablesProduced();
        }
        System.out.println("-> Los vegetales producidos en total son : " + totalProduced);
        for (Customer customer : customerCollation) {
            System.out.println("\t->Vegetales consumidos por " + customer.getNameCustomer() + " son: " + customer.getVegetablesConsumed());
            totalConsumed += customer.getVegetablesConsumed();
        }
        System.out.println("-> Los vegetales consumidos en total son: " + totalConsumed);
        System.out.println("-> Estado del almacen: " + restaurant.getVegetableCollectionSize());
    }
}
