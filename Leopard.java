public class Leopard extends Animal implements Carnivore{

    private static final String NAME = "Leopard";

    public Leopard(){
        super();
    };

    public Leopard(int age, double health, double strength){
        super(age, health, strength);
    }

    @Override
    public String getName(){
        return NAME;
    }

    @Override
    public boolean sameSpecies(Animal animal){
        if (animal instanceof Leopard){
            return NAME.equals(animal.getName());
        }
        return false;
    }

    @Override
    public void sleep(){
        setStrength(getStrength() * 1.5);
    }

    @Override
    public boolean isPoisonous(){
        return false;
    }

    
    public void eatAnimal(Animal animal){
        setStrength(getStrength() + (animal.getStrength() * .55));
    }

    @Override
    public String toString(){
        return super.toString() + "; species: Leopard";
    }


}