/*CSS 211 Summer 2020
 * Team #2
 * Alex Filbert
 * Diane Lansinger (lead)
 * Melina Perraut
 * Zhexiu Tan
 * Arash Yazdidoost
 * Angie Zou
 * 
 * Team Project #1
 * Building Java Programs (Reges & Step, 5th edition)
 * Ch. 10, p. 721, Programming Exercise #3
 * Family Database Program
 * 
 * Client class asks for a name and prints out the
 * maternal, paternal, and children family line for that person
 * according to the formatting in the textbook. Client class
 * calls Person Class.
 *
 * Final Submission:  07-14-20
*/
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

// Written by Melina Perraut
public class Client { 
   private static boolean foundName; 
	
   public static void main(String[] args) throws FileNotFoundException { 

      // Create scanner objects 
      Scanner tudorFamily = new Scanner(new File("tudor.dat")); // Scanner that reads the tudor.dat file with valid names
      Scanner console = new Scanner(System.in); // Scanner that reads user's input
      run(console, tudorFamily);
 
   }
   
   public static void run(Scanner console, Scanner tudorFamily) throws FileNotFoundException {
      // Written by Melina Perraut
      // Ask for user input
      System.out.print("Person's name? (Type STOP to quit): ");
      String name = console.nextLine();
      	  
      if (name.equalsIgnoreCase("STOP")) {
         System.exit(0);
      } 
      else {
	      tudorFamily = new Scanner(new File("tudor.dat")); // Re-initialize Scanner for tudor.dat
	      // Search through tudor.dat file for inputted name and create instance of Person object if found
	      while (tudorFamily.hasNextLine()) { 
		 String line = tudorFamily.nextLine();
		 Scanner lineScan = new Scanner(line);

		 while (lineScan.hasNext() && !(line.equals("END"))) { // For all person names (stopping at first "END" - excludes family names & duplicates)
		    String nameInList = lineScan.nextLine();
		    if (nameInList.equalsIgnoreCase(name)) {
		       foundName = true;
		    }           
		 }	
	      }  
   	}
      //Written by Arash Yazdidoost
      if (foundName) {
	 name = name.toLowerCase();
    	 name = name.substring(0, 1).toUpperCase() + name.substring(1);
         Person result = new Person(name);
         result.getFamily();
         System.out.println(result.toString());    
	 foundName = false;
      }
      else { // If user input is invalid (name entered is not in tudor.dat)
         System.out.println("Sorry, that name was not found.");	
      }
      askSearchAgain(console, tudorFamily);
   }
   // Written by Melina Perraut
   // Checks whether the user wants to search for another name, and runs the program again if yes
   public static void askSearchAgain(Scanner console, Scanner tudorFamily) throws FileNotFoundException { 
      System.out.println();
      System.out.println("Would you like to search another name? (Type YES to continue and STOP to quit)");
      String answer = console.nextLine();
		 
      if (answer.equalsIgnoreCase("YES")) {
         run(console, tudorFamily); //Run the program again 
      } else if (answer.equalsIgnoreCase("STOP")) {
	 System.exit(0);
      }
   }
}
