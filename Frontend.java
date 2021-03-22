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

public class Frontend {
  static Scanner sc = new Scanner(System.in);
  public static Backend b;
  
  public void backend(Backend b) {
    this.b = b;
  }

  public static void main(String[] args) {
    Frontend F = new Frontend();
    try {
      b  = new Backend();
    } catch (DataFormatException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    F.run();
     
  }
  
  public static void run() {
    System.out.println("Welcome to your pokedex.");
    System.out.println("From this menu you can choose to view pokemon in your pokedex or add new pokemon.");
    System.out.print("Please select: \nl - to lookup pokemon\na - to add a new pokemon\no - to list out all pokemon to add\np - to print out all pokemon in the pokedex\nx - to exit.");
    
    String input = sc.nextLine();
    
    while (!input.equals("x")) {
      if (input.equals("l")) {
        lookupPokemon();
      }
      else if (input.equals("a")){
        addPokemon();
      }
      else if (input.equals("o")) {
        listPokemon();
      }
      else if (input.equals("p")) {
        pokedexList();
      }
      else {
        System.out.println("Not a valid input. Please enter a valid command.");
        run();
        break;
      }
    }
    
    System.out.println("Thank you for visiting your pokedex. Come back soon!");
    
    sc.close();
    
  }
  
  
  
  public static void addPokemon() {
    System.out.println("Welcome to the add pokemon menu.");
    System.out.println("Please enter the name of the pokemon you would like to insert then click enter.");
    System.out.println("If you would like to exit enter x.");
    
    String name = sc.nextLine();
    
    if (name.equals("x")) {
      run();
    }
   
    Pokemon p = b.checkNames(name);
    
    
    while (p == null) {
      System.out.println("Please enter a valid name.");
      String nameRetry = sc.nextLine();
      p = b.checkNames(nameRetry);
      
    }
    
    b.addName(name);
    
    System.out.println("The pokemon " + p.getName() + " has been added to the pokedex");
    
    
    
    
  }
  
  public static void lookupPokemon() {
    System.out.println("Welcome to the lookup menu.");
    System.out.println("Please enter the name of the pokemon you would like to add then click enter.");
    System.out.println("If you would like to exit enter x.");
    String name = sc.nextLine();
    Pokemon p = b.getNames(name);
    
    if (name.equals("x")) {
      run();
    }
  
       while (p == null) {
         System.out.println("Please enter a valid name.");
         String nameRetry = sc.nextLine();
         p = b.getNames(nameRetry);
         if (name.equals("x")) {
           run();
         }
       }
       
       
       
       
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
  
  public static void listPokemon() {
    System.out.println("To print a full list of pokemon to add input l and click enter. Otherwise enter x to exit.");
    
    String command = sc.nextLine();
    
    if (command.equals("x")) {
      run();
    }else if (command.equals("l")) {
     System.out.println(b.getAllNames());
    }
    
        
  }
  
  public static void pokedexList() {
System.out.println("To print a full list of pokemon to add input l and click enter. Otherwise enter x to exit.");
    
    String command = sc.nextLine();
    
    if (command.equals("x")) {
      run();
    }else if (command.equals("l")) {
     System.out.println(b.pokedexNames());
    }
    
        
  }

}
