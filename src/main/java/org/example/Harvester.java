package org.example;

public class Harvester {
    String name;
    char symbol;
    int height;
    double harvesting_accuracy;
    double points = 0.0;

    public Harvester(String name, char symbol, int height, double harvesting_accuracy) {
        this.name = name;
        this.symbol = symbol;
        this.height = height;
        this.harvesting_accuracy = harvesting_accuracy;
    }

    public void Superpower(Tree tree) {
        // Domyślna implementacja, która może zostać nadpisana przez podklasy
    }
}
