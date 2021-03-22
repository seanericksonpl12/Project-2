import java.util.List;

public interface BackendInterface {
  public void addType(String Type);
  public void addTotal(String Total);
  public void addName(String Name);
  public List<String> getTypes();
  public List<String> getAvgTotals();
  public List<String> getNames();
  public int getNumberOfPokemons();
  public List<String> getAllTypes();
}
