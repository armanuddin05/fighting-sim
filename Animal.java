
import java.util.Random;
public abstract class Animal{


   
    private int age;
    private double health;
    private double strength;
    private static final String NAME = "Animal";


    protected Animal(){
        age = 0;
        health = 0;
        strength = 0;
    }

    protected Animal(int age, double health, double strength){
        this.age = age;
        this.health = health;
        this.strength = strength;
    }

    public int getAge(){
        return age;
    }
    public double getHealth(){
        return health;
    }
    public double getStrength(){
        return strength;
    }
    public String getName(){
        return NAME; 
    }
    public void setHealth(double health){
        this.health = health;
    }
    public void setStrength(double strength){
        this.strength = strength;
    }


    public double attack(Animal animal){
        Random r = new Random();
        double randNum = 1 + (r.nextDouble() * strength);

        double newHealth = animal.getHealth() - randNum;
        animal.setHealth(newHealth);

        return randNum;
    }

    public abstract boolean sameSpecies(Animal animal);

    public abstract void sleep();

    public abstract boolean isPoisonous();

    public boolean poisonAnimal(){
        return false;
    }

    @Override
    public String toString(){
        return "(Animal)" + " age: " + getAge() + "; health: " + 
        getHealth() + "; strength: " + getStrength();
    }











}