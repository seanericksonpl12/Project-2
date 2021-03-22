//--== CS400 File Header Information ==--
//Author: Sean Erickson
//Email: smerickson4@wisc.edu
//Team: blue
//Role: Front end developer
//TA: hang
//Lecturer: Gary
//Notes: 
public interface Pokemon extends Comparable<Pokemon>{
    public String getName();
    public String getType();
    public int getHP();
    public int getTotal();
    public int getAttack();
    public int getDefense();
    public int getSpeed();
    public int getGen();
    public boolean isLegendary();
    public int compareTo(Pokemon otherPokemon);
    
}
