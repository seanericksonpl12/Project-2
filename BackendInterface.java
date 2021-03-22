
import java.util.List;

public interface BackendInterface {
  public void addName(String Name);
  public Pokemon getNames(String n);
  public int getNumberOfPokemons();
  public List<String> getAllNames();
}