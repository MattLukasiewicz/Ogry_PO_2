package org.example;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

class Map {
    private char[][] mapArray;

    // Constructor that initializes the mapArray and loads the map from file
    public Map(String filename) {
        mapArray = new char[5][5];
        loadMapFromFile(filename);
    }
    public Map(){
        mapArray = new char[5][5];
        randomMap();
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

    public char[][] getMapArray() {
        return mapArray;
    }

    char[] symbols={'W','J','B','0'};

    public void randomMap(){
        Random random = new Random();
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++){
                int randomIndex = random.nextInt(symbols.length);
                mapArray[i][j] = symbols[randomIndex];
            }
    }
}
