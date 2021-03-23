import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.HashMap;
//--== CS400 File Header Information ==--
//Name: Erhan Wang
//Email: ewang43@wisc.edu
//Team: Blue
//Role: BackEndDeveloper
//TA: Hang
//Lecturer: Florian
//Notes to Grader: <optional extra notes>
/**
 * This is the Backend class that implements BackendInterface
 * It receives data from DataReader and provide method to the Frontend 
 * In this class we put Pokemon into a RBT and make use of the 
 * redblacktree
 * 
 * @author Erhan Wang
 * @version 1.0
 *
 */
public class Backend implements BackendInterface{
  private RedBlackTree<Pokemon> nameRBT;
  private List<Pokemon> PokemonList;
  private List<String> names;
  private HashMap<String,Pokemon> nameHash;
  /**
   * Constructor method to initialize a Backend class
   * 
   * @throws DataFormatException
   * @throws IOException
   */
  public Backend() throws DataFormatException, IOException {
    names = new ArrayList<String>();
    nameHash = new HashMap<String,Pokemon>();
    PokemonDataReader pokemonReader = new PokemonDataReader();
    PokemonList = pokemonReader.readDataSet();
    nameRBT = new RedBlackTree<Pokemon>();
  }
  
  /**
   * return a List that contains Pokemon
   * @return Pokemon List
   */
  public List<Pokemon> getPokemon(){
    return PokemonList;
  }
  
  
  /**
   * When given a String name, search that name and put the pokemon into a RBT and 
   * a HashTable
   * @param Name
   */
  @Override
  public void addName(String Name) {
    if(!names.contains(Name)) {
      names.add(Name);
      for(int i=0;i<PokemonList.size();i++) {
        Pokemon pok = PokemonList.get(i);
        if(pok.getName().equals(Name)) {
          nameRBT.insert(pok);
          nameHash.put(Name,pok);
        }
      }
    }
    
    return;
  }
  /**
   * Check if the provided pokemon is in the List
   * and then return the pokemon.
   * 
   * @param pokemon
   * @return the searched pokemon
   */
  public Pokemon checkNames(String pokemon) {
    for (int i = 0; i < PokemonList.size(); i++) {
      if (PokemonList.get(i).getName().equals(pokemon)) {
        return PokemonList.get(i);
      }
    }
    return null;
  }

  /**
   * Check if the provided pokemon is in the Hashtable
   * and then return the pokemon.
   * 
   * @param PokName
   * @return the searched Pokemon
   */
  @Override
  public Pokemon getNames(String PokName) {
    
    if(nameHash.containsKey(PokName)) {
      return nameHash.get(PokName);
    }
    else {
      return null;
    }
    
  }
  /**
   * Get the size of Pokemon List
   * @return the size of the Pokemon List
   */
  @Override
  public int getNumberOfPokemons() {
    return PokemonList.size();
  }
  /**
   * get all the name in the Pokemon List
   * 
   * @return all the names in the Pokemon List
   */
  @Override
  public String getAllNames() {
    List<String> nms = new ArrayList<String>();
    // loop through all Pokemon
    for (int i = 0; i < PokemonList.size(); i++) {
      if (!nms.contains(PokemonList.get(i).getName())) {
        nms.add(PokemonList.get(i).getName());
      }
    }
    return nms.toString();
  }
  /**
   * Get all the names in the Pokedex
   * @returnthe name of pokemon in the Pokedex
   */
  public String pokedexNames() {
    String toprint = new String();
    toprint = nameRBT.toString();
    return toprint;
  }
  
}