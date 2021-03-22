import java.util.Scanner;

public class Frontend {
  static Scanner sc = new Scanner(System.in);
  static Backend b = new Backend();

  public static void main(String[] args) {
    Frontend F = new Frontend();
    
    
    F.run();
     
  }
  
  public static void run() {
    System.out.println("Welcome to your pokedex.");
    System.out.println("From this menu you can choose to view pokemon in your pokedex or add new pokemon.");
    System.out.print("Please select l to lookup pokemon, a to add a new pokemon or x to exit.");
    
    String input = sc.nextLine();
    
    while (!input.equals("x")) {
      if (input.equals("l")) {
        lookupPokemon();
      }
      else if (input.equals("a")){
        addPokemon();
      }else {
        System.out.println("Not a valid input. Please enter a valid command.");
      }
    }
    
    System.out.println("Thank you for visiting your pokedex. Come back soon!");
    
    
    
  }
  
  
  
  public static void addPokemon() {
    System.out.println("Welcome to the add pokemon menu.");
    System.out.println("Please enter the name of the pokemon you would like to insert then click enter.");
    System.out.println("If you would like to exit enter x.");
    
    String name = sc.nextLine();
    
    if (name.equals("x")) {
      run();
    }
   
    Pokemon p = b.getName(name);
    
    
    while (p == null) {
      System.out.println("Please enter a valid name.");
      String nameRetry = sc.nextLine();
      p = b.getName(nameRetry);
      
    }
    
    b.Insert(p);
    
    System.out.println("The pokemon " + p.getName() + "has been added to the pokedex");
    
    
    
    
  }
  
  public static void lookupPokemon() {
    System.out.println("Welcome to the lookup menu.");
    System.out.println("Please enter the name of the pokemon you would like to add then click enter.");
    System.out.println("If you would like to exit enter x.");
    String name = sc.nextLine();
    Pokemon p = b.getName(name);
  
       while (p == null) {
         System.out.println("Please enter a valid name.");
         String nameRetry = sc.nextLine();
         p = b.getName(nameRetry);
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

}
