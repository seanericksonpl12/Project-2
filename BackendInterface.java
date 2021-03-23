import java.util.List;

//--== CS400 File Header Information ==--
//Name: Erhan Wang
//Email: ewang43@wisc.edu
//Team: Blue
//Role: BackEndDeveloper
//TA: Hang
//Lecturer: Florian
//Notes to Grader: <optional extra notes>
/**
 * This is the interface for Backend class
 * 
 * @author Erhan Wang
 * @version 1.0
 *
 */
public interface BackendInterface {
  public void addName(String Name);
  public Pokemon getNames(String n);
  public int getNumberOfPokemons();
  public String getAllNames();
  public List<Pokemon> getPokemon();
  public Pokemon checkNames(String string);
  public String pokedexNames();
}