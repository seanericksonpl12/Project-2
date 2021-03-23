
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

//--== CS400 File Header Information ==--
//Author: Sean Erickson
//Email: smerickson4@wisc.edu
//Team: blue
//Role: Front end developer
//TA: hang
//Lecturer: Gary
//Notes: 
public class PokemonDataReader {

    /**
     * This method slices up teh csv file and builds a pokemon object for each row,
     * adding it to an arraylist after
     * 
     * @return The arraylist of all the pokemon
     * @throws FileNotFoundException if the path specified is wrong
     */
    public List<Pokemon> readDataSet() throws FileNotFoundException {
        // class path meant for running on eclipse, change when running from command
        // line!!
        Scanner sc = new Scanner(new File("src/pokemonGen3.csv"));
        // Scan in the csv file and create new arraylist to hold the pokemon
        List<Pokemon> pokemon = new ArrayList<Pokemon>();
        sc.nextLine();
        // Loop through the file making new pokemon using the pokemon interface
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] splitted = line.split(",");

            pokemon.add(new Pokemon() {

                @Override
                public String getName() {
                    return splitted[1];
                }

                @Override
                public String getType() {
                    if (splitted[3].equals(""))
                        return splitted[2];
                    return splitted[2] + ", " + splitted[3];
                }

                @Override
                public int getHP() {
                    return Integer.parseInt(splitted[5]);
                }

                @Override
                public int getTotal() {
                    return this.getAttack() + this.getDefense() + this.getHP();
                }

                @Override
                public int getAttack() {
                    return Integer.parseInt(splitted[6]);
                }

                @Override
                public int getDefense() {
                    return Integer.parseInt(splitted[7]);
                }

                @Override
                public int getSpeed() {
                    return Integer.parseInt(splitted[10]);
                }

                @Override
                public int getGen() {
                    return Integer.parseInt(splitted[11]);
                }

                @Override
                public boolean isLegendary() {
                    return splitted[12].equalsIgnoreCase("True");
                }
                
                @Override
                public String toString() {
                    return splitted[1];
                }

                @Override
                public int compareTo(Pokemon otherPokemon) {
                    // TODO Auto-generated method stub
                    if (this.getName().equals(otherPokemon.getName()))
                        return 0;
                    if (this.getTotal() == otherPokemon.getTotal())
                        return 0;
                    else if (this.getTotal() < otherPokemon.getTotal())
                        return 1;
                    else
                        return -1;
                }

            });

        }
        sc.close();
        return pokemon;
    }
}
