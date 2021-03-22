import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class Backend implements BackendInterface{
  private RedBlackTree<Pokemon> typeRBT;
  private RedBlackTree<Pokemon> totalRBT;
  private RedBlackTree<Pokemon> nameRBT;
  private List<Pokemon> PokemonList;
  private List<String> types;
  private List<String> totals;
  private List<String> names;
  
  public Backend() throws DataFormatException, IOException {
    types = new ArrayList<String>();
    totals = new ArrayList<String>();
    names = new ArrayList<String>();

    PokemonDataReader pokemonReader = new PokemonDataReader();

    PokemonList = pokemonReader.readDataSet();
    typeRBT = new RedBlackTree<Pokemon>();
    totalRBT = new RedBlackTree<Pokemon>();
    nameRBT = new RedBlackTree<Pokemon>();
  }
  
  
  public List<Pokemon> getPokemon(){
    return PokemonList;
  }
  
  
  @Override
  public void addType(String Type) {
    if(!types.contains(Type)) {
      types.add(Type);
    }
    
  }

  @Override
  public void addTotal(String Total) {
    if(!totals.contains(Total)) {
      totals.add(Total);
    }
  }

  @Override
  public void addName(String Name) {
    if(!names.contains(Name)) {
      names.add(Name);
      for(int i=0;i<PokemonList.size();i++) {
        Pokemon pok = PokemonList.get(i);
        if(pok.getName().equals(Name)) {
          nameRBT.insert(pok);
        }
      }
    }
    return;
  }

  @Override
  public List<String> getTypes() {
    return types;
  }

  @Override
  public List<String> getAvgTotals() {
    return totals;
  }

  @Override
  public Pokemon getNames(String PokName) {
    Pokemon pok = null;
    for(int i=0;i<PokemonList.size();i++) {
      if(PokemonList.get(i).getName().equals(PokName)) {
        pok = PokemonList.get(i);
      }
    }
    return pok;
  }

  @Override
  public int getNumberOfPokemons() {
    return PokemonList.size();
  }

  @Override
  public List<String> getAllTypes() {
    List<String> tps = new ArrayList<String>();
    // loop through all Pokemon
    for (int i = 0; i < PokemonList.size(); i++) {
        // loop through all genres of the movie at i
        for (int j = 0; j < PokemonList.get(i).getType().size(); j++) {
            // if list doesn't contain the genre already, remove it
            if (!tps.contains(PokemonList.get(i).getType().get(j))) {
              tps.add(PokemonList.get(i).getType().get(j));
            }
        }
    }

    return tps;
  }

 
}
