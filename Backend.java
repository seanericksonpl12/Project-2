import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.HashMap;

public class Backend implements BackendInterface{
  private RedBlackTree<Pokemon> nameRBT;
  private List<Pokemon> PokemonList;
  private List<String> names;
  private HashMap<String,Pokemon> nameHash;
  
  public Backend() throws DataFormatException, IOException {
    names = new ArrayList<String>();
    nameHash = new HashMap<String,Pokemon>();
    PokemonDataReader pokemonReader = new PokemonDataReader();

    PokemonList = pokemonReader.readDataSet();
    nameRBT = new RedBlackTree<Pokemon>();
  }
  
  
  public List<Pokemon> getPokemon(){
    return PokemonList;
  }
  
  

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


  @Override
  public Pokemon getNames(String PokName) {
    
    if(nameHash.containsKey(PokName)) {
      return nameHash.get(PokName);
    }
    else {
      return null;
    }
    
  }

  @Override
  public int getNumberOfPokemons() {
    return PokemonList.size();
  }

  @Override
  public List<String> getAllNames() {
    List<String> nms = new ArrayList<String>();
    // loop through all Pokemon
    for (int i = 0; i < PokemonList.size(); i++) {
      if (!nms.contains(PokemonList.get(i).getName())) {
        nms.add(PokemonList.get(i).getName());
      }
    }
    return nms;
  }

 
}
