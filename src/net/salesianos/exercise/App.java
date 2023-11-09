package net.salesianos.exercise;

import net.salesianos.exercise.costumer.Customer;
import net.salesianos.exercise.farmer.Farmer;
import net.salesianos.exercise.restaurant.Restaurant;

public class App {
    public static void main(String[] args){
        Restaurant restaurant = new Restaurant(20);

        Farmer farmerOne = new Farmer("Adrian", 10, restaurant);
        Farmer farmerTwo = new Farmer("Saul", 10, restaurant);

        Customer customerOne = new Customer("Adan", 5, restaurant);
        Customer customerTwo = new Customer("Marco", 10, restaurant);
        Customer customerThree = new Customer("Pepe", 5, restaurant);

        farmerOne.start();
        farmerTwo.start();
        customerOne.start();
        customerTwo.start();
        customerThree.start();
        try {
            farmerOne.join();
            farmerTwo.join();
            customerOne.join();
            customerTwo.join();
            customerThree.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Vegetales producidos por " + farmerOne.getName() + " son: " + farmerOne.getVegetablesProduced());
        System.out.println("Vegetales producidos por " + farmerTwo.getName() + " son: " + farmerTwo.getVegetablesProduced());
        System.out.println("Vegetales consumidos por " + customerOne.getName() + " son: " + customerOne.getVegetablesConsumed());
        System.out.println("Vegetales consumidos por " + customerTwo.getName() + " son: " + customerTwo.getVegetablesConsumed());
        System.out.println("Vegetales consumidos por " + customerThree.getName() + " son: " + customerThree.getVegetablesConsumed());
        System.out.println("Los vegetales producidos en total son : " + (farmerOne.getVegetablesProduced() + farmerTwo.getVegetablesProduced()));
        System.out.println(" Los vegetales consumidos en total son: " + (customerOne.getVegetablesConsumed() + customerTwo.getVegetablesConsumed() + customerThree.getVegetablesConsumed()));
        
    }
}
