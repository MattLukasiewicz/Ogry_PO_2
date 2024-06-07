package org.example;

public class Batman extends Harvester {
    public Batman(String name, char symbol, int height, double harvesting_accuracy) {
        super(name, symbol, height, harvesting_accuracy);
    }

    @Override
    public void Superpower(Tree tree) {
        System.out.println("Batman is calling for his Batcopter which helps him which helps him collect fruit if it is a tall tree");
        if(tree.heigh_of_the_fruits>230) {
            points+=tree.maxPoints();
        }
    }
}
