package org.example;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.Math.abs;

class Map {
    private static char[][] mapArray;

    //Creating trees
    static Tree[] trees = new Tree[3];

    Tree apple_tree = new Tree("apple tree", 'J', 20, 240, 5);
    Tree banana_tree = new Tree("banana tree", 'B', 10, 330, 10);
    Tree wild_strawberry_tree = new Tree("wild strawberry tree", 'W', 1000, 100, 1);


    // Constructor that initializes the mapArray and loads the map from file
    public Map(String filename) {
        mapArray = new char[5][5];
        loadMapFromFile(filename);
    }

    // Method to load the map from a file into the mapArray
    private void loadMapFromFile(String filename) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            System.out.println("File not found: " + filename);
            System.exit(1);
        }

        Scanner scanner = new Scanner(inputStream);
        for (int i = 0; i < 5; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(" ");
                for (int j = 0; j < 5; j++) {
                    mapArray[i][j] = elements[j].charAt(0);
                }
            }
        }
        scanner.close();
    }

    // Method to display the mapArray on the screen
    public void displayMap() {
        System.out.println("Map:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(mapArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Method to get map
    public static char[][] getMapArray() {
        return mapArray;
    }

    //Method to get a position of tree
    public static Tree getTreeAtPosition(int i, int j) {
        for (Tree tree : trees) {
            if (mapArray[i][j] == tree.symbol) {
                return tree;
            }
        }
        return null;
    }

    public void Move(){
        //Creating a hero
        Harvester Hero1 = new Shrek("Shrek", '%', 280, 1.0);
        System.out.println("Name: " + Hero1.name + " Height: " + Hero1.height + " Accuracy: " + Hero1.harvesting_accuracy+ " Points: "+ Hero1.points);

        trees[0] = apple_tree;
        trees[1] = banana_tree;
        trees[2] = wild_strawberry_tree;

        //Counting some data
        int how_many_apple_trees = 0;
        int how_many_banana_trees = 0;
        int how_many_wild_strawberry_tree = 0;
        int how_many_did_hero_already_harvest=0;

        //Moving and Harvesting
        for (int i = 0; i <mapArray.length; i++) {
            for (int j = 0; j <mapArray[i].length; j++) {
                if (mapArray[i][j] == apple_tree.symbol) how_many_apple_trees++;
                if (mapArray[i][j] == banana_tree.symbol) how_many_banana_trees++;
                if (mapArray[i][j] == wild_strawberry_tree.symbol) how_many_wild_strawberry_tree++;

                if(mapArray[i][j]!='0'){
                    how_many_did_hero_already_harvest++;
                    for(Tree tree : trees){

                        //Hero is using his superpower every 5th tree
                        if(how_many_did_hero_already_harvest==6){
                            Hero1.Superpower();
                            how_many_did_hero_already_harvest=0;
                        }
                        else{

                        //Harvesting based on the height difference between hero and a tree
                        if (mapArray[i][j] == tree.symbol) {
                            double heightDifference = abs(Hero1.height - tree.heigh_of_the_fruits);
                            if (heightDifference <= 40) {
                                Hero1.points += tree.maxPoints();

                            }
                            if (heightDifference > 40 && heightDifference < 100) {
                                Hero1.points += tree.maxPoints() * heightDifference * 0.01;

                            }
                            if (heightDifference >= 100) {
                                Hero1.points += tree.maxPoints() * heightDifference * 0.001;

                            }
                        }
                        }
                        // Mark the tree as harvested
                        mapArray[i][j] = '0';
                    }
                }
            }
        }

        //Printing data
        System.out.println("How many apple trees: " + how_many_apple_trees + " Max points: " +how_many_apple_trees*apple_tree.maxPoints());
        System.out.println("How many banana trees: " + how_many_banana_trees+ " Max points: " +how_many_banana_trees*banana_tree.maxPoints());
        System.out.println("How many wild strawberry tree: " + how_many_wild_strawberry_tree + " Max points: " +how_many_wild_strawberry_tree*wild_strawberry_tree.maxPoints());
        System.out.println("How many points does hero have: " + Hero1.points);
        System.out.println();
    }
}


