package org.example;

public class Batman extends Harvester{
    public Batman(String name,char symbol,int height, double harvesting_accuracy){
        super(name,symbol,height,harvesting_accuracy);
    }
    @Override
    public void Superpower(){
        System.out.println("Batman has used his superpower");
        char[][] mapArray = Map.getMapArray();
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                if (mapArray[i][j] != '0') {
                    Tree tree = Map.getTreeAtPosition(i, j);
                    if (tree != null) {
                        height+=100;

                        height-=100;
                    }
                }
            }
        }
    }
}