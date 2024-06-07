package org.example;

import static java.lang.Math.abs;

public class Move {
    private Map map;
    private Harvester hero;
    private Tree[] trees;

    public Move(Map map, Harvester hero) {
        this.map = map;
        this.hero = hero;
        this.trees = new Tree[]{
                new Tree("apple_tree", 'J', 20, 200, 5),
                new Tree("banana_tree", 'B', 10, 330, 10),
                new Tree("wild_strawberry_tree", 'W', 1000, 100, 1)
        };
    }

    public void execute() {
        char[][] mapArray = map.getMapArray();

        int howManyAppleTrees = 0;
        int howManyBananaTrees = 0;
        int howManyWildStrawberryTrees = 0;

        int treesVisited = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char currentSymbol = mapArray[i][j];


                if(currentSymbol!='0'){
                    if (currentSymbol == trees[0].symbol) howManyAppleTrees++;
                    if (currentSymbol == trees[1].symbol) howManyBananaTrees++;
                    if (currentSymbol == trees[2].symbol) howManyWildStrawberryTrees++;
                    for (Tree tree : trees) {
                        if (currentSymbol == tree.symbol) {
                            treesVisited++;
                            if (treesVisited % 5 == 0) {
                                hero.Superpower(tree);
                            }else{
                                double heightDifference = abs(hero.height - tree.heigh_of_the_fruits);

                                if (heightDifference <= 40) {
                                    hero.points += tree.maxPoints();
                                } else if (heightDifference > 40 && heightDifference < 100) {
                                    hero.points += tree.maxPoints() * heightDifference * 0.01;
                                } else if (heightDifference >= 100) {
                                    hero.points += tree.maxPoints() * heightDifference * 0.001;
                                }

                            }
                        }

                    }
                }
            }
        }

        System.out.println("How many apple trees: " + howManyAppleTrees + " Max points: " + howManyAppleTrees * trees[0].maxPoints());
        System.out.println("How many banana trees: " + howManyBananaTrees + " Max points: " + howManyBananaTrees * trees[1].maxPoints());
        System.out.println("How many wild strawberry trees: " + howManyWildStrawberryTrees + " Max points: " + howManyWildStrawberryTrees * trees[2].maxPoints());
        System.out.println("How many points does the hero have: " + hero.points);
        System.out.println();
    }
}