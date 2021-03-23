// --== CS400 File Header Information ==--
// Name: Sam Bingenheimer
// Email: sbingenheime@wisc.edu
// Team: Blue
// Role: Frontend Developer
// TA: hang
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * This class runs the frontend interface for our pokedex project. Contains various methods that
 * create menus for the user while also implementing the backend developers work.
 * 
 * @author sambingenheimer
 *
 */
public class Frontend {
  // scanner and backend objects used throughout the class.
  static Scanner sc = new Scanner(System.in);
  public static Backend b;

  /**
   * This initializes the backend which allows the frontend code to implement its methods.
   * 
   * @param b
   */
  public void backend(Backend b) {
    this.b = b;
  }

  /**
   * This initializes the backend and checks for its exceptions before moving on. It then runs the
   * program.
   * 
   * @param args
   */
  public static void main(String[] args) {
    Frontend F = new Frontend();
    try {
      b = new Backend();
    } catch (DataFormatException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    F.run();

  }

  /**
   * This method is where the main menu has been written. It prompts the user to enter an input that
   * will take them to one of the other various methods.
   */
  public static void run() {
    System.out.println("Welcome to your pokedex.");
    System.out.println(
        "From this menu you can choose to view pokemon in your pokedex or add new pokemon.");
    System.out.print(
        "Please select: \nl - to lookup pokemon\na - to add a new pokemon\no - to list out all pokemon to add\np - to print out all pokemon in the pokedex\nx - to exit.");

    // string that takes input from the scanner.
    String input = sc.nextLine();

    // while the input is not x, there are various cases based on input that will take the user to
    // other menus.
    while (!input.equals("x")) {
      if (input.equals("l")) {
        lookupPokemon();
      } else if (input.equals("a")) {
        addPokemon();
      } else if (input.equals("o")) {
        listPokemon();
      } else if (input.equals("p")) {
        pokedexList();
      } else {
        System.out.println("Not a valid input. Please enter a valid command.");
        run();

      }
    }

    // when input finally equals x, program closes.
    System.out.println("Thank you for visiting your pokedex. Come back soon!");

    sc.close();

  }


  /**
   * This is where the user can add pokemon to the pokedex. They do this by entering the name of the
   * pokemon. They can also enter x to go back to the main menu.
   */
  public static void addPokemon() {
    System.out.println("Welcome to the add pokemon menu.");
    System.out
        .println("Please enter the name of the pokemon you would like to insert then click enter.");
    System.out.println("If you would like to exit enter x.");

    // This string gets the name the user inputs from the scanner
    String name = sc.nextLine();

    // if the input is x, it goes back to the main menu
    if (name.equals("x")) {
      run();
    }

    // a pokemon object that is made if the name entered is valid.
    Pokemon p = b.checkNames(name);

    // if p is null, that means the name was invalid and they will be prompted to enter another
    // name.
    while (p == null) {
      System.out.println("Please enter a valid name.");
      String nameRetry = sc.nextLine();
      p = b.checkNames(nameRetry);

    }

    // adds the new pokemon and prints out a message saying it was successful.
    b.addName(name);

    System.out.println("The pokemon " + p.getName() + " has been added to the pokedex");



  }

  /**
   * This is the method that contains the menu to lookup a pokemon based on name. They can lookup by
   * entering the name of the pokemon. They can go back to the main menu by selecting x.
   */
  public static void lookupPokemon() {
    System.out.println("Welcome to the lookup menu.");
    System.out
        .println("Please enter the name of the pokemon you would like to add then click enter.");
    System.out.println("If you would like to exit enter x.");
    // this string is the name the user inputed.
    String name = sc.nextLine();
    // makes a new pokemon checking if name is valid.
    Pokemon p = b.checkNames(name);
    // if x is entered returns to main menu.
    if (name.equals("x")) {
      run();
    }
    // if p is null, it means there was an invalid input and the user will be asked to enter a new
    // name.
    while (p == null) {
      System.out.println("Please enter a valid name.");
      String nameRetry = sc.nextLine();
      p = b.checkNames(nameRetry);

    }


    // prints out all the stats of the pokemon that was looked up.

    System.out.println("Name: " + p.getName());
    System.out.println("HP: " + p.getHP());
    System.out.println("Total: " + p.getTotal());
    System.out.println("Attack: " + p.getAttack());
    System.out.println("Defense: " + p.getDefense());
    System.out.println("Speed: " + p.getSpeed());
    System.out.println("Type: " + p.getType());
    System.out.println("Generation: " + p.getGen());
    if (p.isLegendary() == true) {
      System.out.println("Legendary pokemon");

    }


  }

  /**
   * This method prints out a complete list of pokemon that can be added.
   */
  public static void listPokemon() {
    System.out.println(
        "To print a full list of pokemon to add input l and click enter. Otherwise enter x to exit.");

    // the command the user inputs.
    String command = sc.nextLine();
    // if the input is x, it returns to the main menu.
    if (command.equals("x")) {
      run();
    } else if (command.equals("l")) {
      System.out.println(b.getAllNames());// prints out the full list.
    }


  }

  /**
   * This method prints out the names of all the pokemon in the pokedex.
   */
  public static void pokedexList() {
    System.out.println(
        "To print a full list of pokemon in the pokedex input l and click enter. Otherwise enter x to exit.");
    // the command the user inputs.
    String command = sc.nextLine();
    // if the command is x, returns to the main menu.
    if (command.equals("x")) {
      run();
    } else if (command.equals("l")) {
      System.out.println(b.pokedexNames());// prints out the full list of names in pokedex
    }


  }

}
