// --== CS400 File Header Information ==--
// Name: Sam Bingenheimer
// Email: sbingenheime@wisc.edu
// Team: Blue
// Role: Frontend Developer
// TA: hang
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.zip.DataFormatException;

/**
 * This class tests various aspects of the frontend interface for the pokedex app.
 * 
 * @author sambingenheimer
 *
 */
public class TestFrontend {

  /**
   * This tests to see whether the frontend still exists after the x key is pressed. Tests to make
   * sure the frontend is instantiated and that no exceptions are thrown. it is pressed in the main
   * menu
   */
  @Test
  public void testExit() {
    // input and output streams that will be used to run the app
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    try {
      // the key that will be inputed
      String input = "x";
      // setting the input stream to x
      InputStream inputStreamSimulator = new ByteArrayInputStream(input.getBytes());
      System.setIn(inputStreamSimulator);
      ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outputStreamCaptor));// to get the output
      // frontend and backend that will be tested on
      Frontend f = new Frontend();
      Backend b;
      try {
        b = new Backend();
        f.backend(b);
        // runs the program.
        f.run();

      } catch (DataFormatException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // settting in and out
      System.setOut(standardOut);
      System.setIn(standardIn);
      // boolean to see if the frontend exists or not.
      Boolean tester;
      // if it exists return true or false if its null
      if (f == null) {
        tester = false;
      } else {
        tester = true;
      }

      // if the front end is not null that means the app closed and test passes.
      assertEquals(tester, true);
    } catch (Exception e) {
      Boolean fail = false;
      assertEquals(fail, false);
    }
  }

  /**
   * This tests if when the user enters a valid pokemon that the program prints out a successful add
   * statement. that allows them to add a pokemon.
   */
  @Test
  public void testAddName() {
    // input and output streams that will be used to run the app
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    try {
      // the key that will be inputed
      String input = "a" + System.lineSeparator() + "Bulbasaur";
      // setting the input stream to x
      InputStream inputStreamSimulator = new ByteArrayInputStream(input.getBytes());
      System.setIn(inputStreamSimulator);
      ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outputStreamCaptor));// to get the output
      // frontend and backend that will be tested on
      Frontend f = new Frontend();
      Backend b;
      try {
        b = new Backend();
        f.backend(b);
        // runs the program.
        f.run();

      } catch (DataFormatException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // settting in and out
      System.setOut(standardOut);
      System.setIn(standardIn);
      // getting the output in string form
      String appOutput = outputStreamCaptor.toString();
      // boolean object for test.
      Boolean tester;

      // if the frontend still exists and the correct message is printed out tester is true.
      if (f != null && appOutput.contains("The pokemon Bulbasaur has been added to the pokedex")) {
        tester = true;
      } else {
        tester = false;
      }
      assertEquals(tester, true);

    } catch (Exception e) {
      Boolean fail = false;
      assertEquals(fail, false);
    }
  }

  /**
   * This tests to make sure that the pokemon is added when the user enters the name of a valid
   * pokemon. Will check the tree for the pokemon after it was added
   * 
   */
  @Test
  public void testAddMenu() {
    // input and output streams that will be used to run the app
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    try {
      // the key that will be inputed
      String input = "a";
      // setting the input stream to x
      InputStream inputStreamSimulator = new ByteArrayInputStream(input.getBytes());
      System.setIn(inputStreamSimulator);
      ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outputStreamCaptor));// to get the output
      // frontend and backend that will be tested on
      Frontend f = new Frontend();
      Backend b;
      try {
        b = new Backend();
        f.backend(b);
        // runs the program.
        f.run();

      } catch (DataFormatException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // settting in and out
      System.setOut(standardOut);
      System.setIn(standardIn);
      // getting the output in string form
      String appOutput = outputStreamCaptor.toString();
      // boolean object for test.
      Boolean tester;

      // if the frontend still exists and the correct message is printed out tester is true.
      if (f != null && appOutput.contains("Welcome to the add pokemon menu.")) {
        tester = true;
      } else {
        tester = false;
      }
      assertEquals(tester, true);

    } catch (Exception e) {
      Boolean fail = false;
      assertEquals(fail, false);
    }

  }

  /**
   * This tests to make sure when the key "l" is entered that the program goes to the correct menu.
   */
  @Test
  public void testLookupMenu() {
    // input and output streams that will be used to run the app
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    try {
      // the key that will be inputed
      String input = "l";
      // setting the input stream to x
      InputStream inputStreamSimulator = new ByteArrayInputStream(input.getBytes());
      System.setIn(inputStreamSimulator);
      ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outputStreamCaptor));// to get the output
      // frontend and backend that will be tested on
      Frontend f = new Frontend();
      Backend b;
      try {
        b = new Backend();
        f.backend(b);
        // runs the program.
        f.run();

      } catch (DataFormatException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // settting in and out
      System.setOut(standardOut);
      System.setIn(standardIn);
      // getting the output in string form
      String appOutput = outputStreamCaptor.toString();
      // boolean object for test.
      Boolean tester;

      // if the frontend still exists and the correct message is printed out tester is true.
      if (f != null && appOutput.contains("Welcome to the lookup menu.")) {
        tester = true;
      } else {
        tester = false;
      }
      assertEquals(tester, true);

    } catch (Exception e) {
      Boolean fail = false;
      assertEquals(fail, false);
    }

  }

  /**
   * This tests to make sure a pokemon is correctly retrieved when the user looks it up
   */
  @Test
  public void testLookupPokemon() {
    // input and output streams that will be used to run the app
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    try {
      // the key that will be inputed
      String input = "a" + System.lineSeparator() + "Bulbasaur" + System.lineSeparator() + "x"
          + System.lineSeparator() + "l" + System.lineSeparator() + "Bulbasaur";
      // setting the input stream to x
      InputStream inputStreamSimulator = new ByteArrayInputStream(input.getBytes());
      System.setIn(inputStreamSimulator);
      ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outputStreamCaptor));// to get the output
      // frontend and backend that will be tested on
      Frontend f = new Frontend();
      Backend b;
      try {
        b = new Backend();
        f.backend(b);
        // runs the program.
        f.run();

      } catch (DataFormatException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // settting in and out
      System.setOut(standardOut);
      System.setIn(standardIn);
      // getting the output in string form
      String appOutput = outputStreamCaptor.toString();
      // boolean object for test.
      Boolean tester;

      // if the frontend still exists and the correct message is printed out tester is true.
      if (f != null && appOutput.contains(
          "Name: Bulbasaur\nHP: 45\nTotal: 143\nAttack: 49\nDefense: 49\nSpeed: 45\nType: Grass, Poison\nGeneration: 1")) {
        tester = true;
      } else {
        tester = false;
      }
      assertEquals(tester, true);

    } catch (Exception e) {
      Boolean fail = false;
      assertEquals(fail, false);
    }
  }


}


