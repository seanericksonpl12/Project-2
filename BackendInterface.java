import java.util.List;
//--== CS400 File Header Information ==--
//Name: Erhan Wang
//Email: ewang43@wisc.edu
//Team: Blue
//Role: BackEndDeveloper
//TA: Hang
//Lecturer: Florian
//Notes to Grader: <optional extra notes>
public interface BackendInterface {
  public void addName(String Name);
  public Pokemon getNames(String n);
  public int getNumberOfPokemons();
  public List<String> getAllNames();
  public String printRBT();
}
