import org.junit.Test;
import static org.junit.Assert.*;
import java.io.StringReader;
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
 * This class is the test class for Backend class. There are five test to test individually
 * for every method in the backend class. 
 * @author Erhan Wang
 * @version 2.0
 */
public class BackendTest {
  /**
   * This test instantiates the back end with 432 Pokemons and tests whether the
   * initial selection is righty (getNumberOfPokemons() returns 432). It passes when
   * 432 is returned and fails in all other cases, including when an exception is
   * thrown.
   * @return true if the test passed, false if it failed
   */
  @Test
  public void TestInitialNumberOfPokemons() {
    
    BackendInterface backendToTest = new Backend();
                
    boolean out = false;
    
    if(432 == backendToTest.getNumberOfPokemons()) {
      out = true;
    }
    else {
      out = false;
    }
    
    assertEquals(true, out);
    
  }
  /**
   * This test instantiates the back end and tests whether the
   * addName method successfully add the pokemon into the Pokedex
   * 
   * @return true if the test passed, false if it failed
   */
  @Test
  public void TestaddName() {
    
    BackendInterface backendToTest = new Backend();
                
    boolean out = false;    
    backendToTest.addName("Bulbasaur");
    if(backendToTest.getNames("Bulbasaur") == backendToTest.getPokemon().get(0)) {
      out = true;
    }
    else {
      out = false;
    }
    
    assertEquals(true, out);
  }
  
  
  /**
   * This test instantiates the back end and tests whether the
   * checkNames method successfully check if the given name is in the List and return 
   * the Pokemon
   * 
   * @return true if the test passed, false if it failed
   */
  @Test
  public void TestcheckNames(){
    
    BackendInterface backendToTest = new Backend();
                
    
    boolean out = false;    
    
    if(backendToTest.checkNames("Bulbasaur") == backendToTest.getPokemon().get(0)) {
      out = true;
    }
    else {
      out = false;
    }
    
    assertEquals(true, out);
  }
  
  /**
   * This test instantiates the back end and tests whether the
   * getNames method successfully return the Pokemon with the given name
   * in the Pokedex
   * 
   * @return true if the test passed, false if it failed
   */
  @Test
  public void TestgetNames(){
    
    BackendInterface backendToTest = new Backend();
    
    boolean out = false;    
    backendToTest.addName("Bulbasaur");
    if(backendToTest.getNames("Bulbasaur") == backendToTest.getPokemon().get(0)) {
      out = true;
    }
    else {
      out = false;
    }
    assertEquals(true, out);
  }
  
  /**
   * This test instantiates the back end and tests whether the
   * pokedexNames method successfully return the names in the RBT of the Pokedex
   * 
   * @return true if the test passed, false if it failed
   */
  @Test
  public void TestpokedexNames(){
BackendInterface backendToTest = new Backend();
    
    boolean out = false;    
    backendToTest.addName("Bulbasaur");
    if(backendToTest.pokedexNames().equals("Bulbasaur")) {
      out = true;
    }
    else {
      out = false;
    }
    assertEquals(true, out);
  }
}
