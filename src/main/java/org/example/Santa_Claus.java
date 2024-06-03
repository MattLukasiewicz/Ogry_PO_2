package org.example;

public class Santa_Claus  extends Harvester{
    public Santa_Claus(String name,char symbol,int height, double harvesting_accuracy){
        super(name,symbol,height,harvesting_accuracy);
    }
    @Override
    public void Superpower(){
        System.out.println("Santa Claus's superpower is not discovered yet");
    }


}