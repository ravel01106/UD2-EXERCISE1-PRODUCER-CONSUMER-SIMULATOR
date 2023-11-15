package net.salesianos.exercise.objects.vegetable;

public class Vegetable {
    final private static String[] VEGETABLE_NAMES = {
        "lettuce",
        "cabbage",
        "onion",
        "spinach",
        "potato",
        "celery",
        "asparagus",
        "radish",
        "broccoli",
        "artichoke",
        "tomato",
        "cucumber",
        "eggplant",
        "carrot",
        "green bean"
    };

    private String name;
    private int growingTime;

    public Vegetable(){
        this.name = selectName();
        this.growingTime = calculateGrowingTime();
    }

    private String selectName(){
        int indexRandom = (int)(Math.floor(Math.random()*VEGETABLE_NAMES.length));
        return VEGETABLE_NAMES[indexRandom];
    }

    private int calculateGrowingTime(){
        return (int)(Math.floor(Math.random()*5+1));
    }

    public String getName() {
        return name;
    }

    public int getGrowingTime() {
        return growingTime;
    }

}