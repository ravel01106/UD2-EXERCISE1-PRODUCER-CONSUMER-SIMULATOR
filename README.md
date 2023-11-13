# Unit 2 - Exercise 1 - Producer consumer simulator

## Description

In this project, we have created one or more producers or farmers, who will put vegetables, which were planted in their garden, in a restaurant. At the same time, one or more costumer will eat the vegetables that are in the restaurant.

## Objects

The object classes we will need for this project are as follows:

### Vegetable class

This class creates an object that contains a name and a growth time. Each time we create an object vegetable we have a random name and a random growth time.
To get it in a random way, we have the methods:

- **selectName()**.
- **calculateGrowingTime()**.

### Restaurant class

This class creates an object that has the following attributes:

- **vegetableCollection:** A vegetable collection.
- **maximumCapacity:** the maximum capacity of the collection.

The methods contained in this object are:

- **storeVegetable():** in this method we store the new vegetables harvested by the farmers until they reach the restaurant's capacity. If farmers want to bring in vegetables when the restaurant is full, they have to wait for a customer to eat a vegetable.
- **eatVegetable():** in this method the customers eat the restaurant's vegetables. If the restaurant is empty, they have to wait for a farmer to bring in one.

## Threads

The threads that are to used in this project are:

### Farmer thread

This thread has the following attributes:

- **nameFarmer:** the famer's name.
- **maximumPlanting:** maximum number of times the farmer may plant.
- **vegetablesProduced:** vegetables produced during the thread.
- **restaurant:** the restaurant where vegetables are stored.

This thread has a run method which, when we execute the program, will be what the thread will do.
The thread will pick up a vegetable which will wait for it to grow and store it inside the restaurant. This will be repeated until the farmer reaches his maximum vegetable harvest time.

### Customer thread

This thread has the following attributes:

- **nameCustomer:** the customer's name.
- **quantityVegetablesConsumed:** maximum number of times the client may eat.
- **vegetablesConsumed:** vegetables consumed during the thread.
- **restaurant:** the restaurant where vegetables are stored.

This thread has a run method which, when we execute the program, will be what the thread will do.
The thread will pick up vegetables from restaurant which will be consumed at a random time. This action will be repeated until the maximum number of times they can eat is reached.
