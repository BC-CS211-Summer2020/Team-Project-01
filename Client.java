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
	private static boolean foundName; // (Should be inside of a method)
	 
	public static void main(String[] args) throws FileNotFoundException { // TO-DO: create different methods to separate different groups of code in main method
	   // Create scanner objects 
	   Scanner tudorFamily = new Scanner(new File("tudor.dat")); // Scanner that reads the tudor.dat file with valid names
	   Scanner console = new Scanner(System.in); // Scanner that reads user's input
      
	   // Ask for user input
	   System.out.println("Enter person's name (type STOP to quit): ");
	   String name = console.next();
	   
	   if (name.equals("STOP")) {
		   System.exit(0);
	   } else {
		// Search through tudor.dat file for inputted name and create instance of Person object if found
		   while (tudorFamily.hasNextLine()) { 
			   String line = tudorFamily.nextLine();
			   Scanner lineScan = new Scanner(line);
			   
			   while (lineScan.hasNext() && !(line.equals("END"))) { // For all person names (stopping at first "END" - excludes family names & duplicates)
				   String nameInList = lineScan.next();
				   if (nameInList.equalsIgnoreCase(name)) {
					   foundName = true;
					   System.out.println("Found name!"); // Test print statement
					   // TO-DO: Create instance of Person object - CANNOT DO UNTIL PERSON CLASS IS WRITTEN
					   // TO-DO: Print Person object's fields in accordance to project specs - CANNOT DO UNTIL PERSON CLASS IS WRITTEN
					   // REMEMBER to call askSearchAgain 
				   } 
			   }			
		   	}
	   }

		if (foundName == false) { // If user input is invalid (name entered is not in tudor.dat)
			System.out.println("Sorry, that name was not found.");
			askSearchAgain(console, tudorFamily);
		}
     
   }
   
	 // Checks whether the user wants to search for another name, and runs the program again if yes
	 public static void askSearchAgain(Scanner console, Scanner tuodrFamily) throws FileNotFoundException {
		 System.out.println();
		 System.out.println("Would you like to search another name? (Type YES to continue and STOP to quit)");
		 String answer = console.next();
		 
		 if (answer.equalsIgnoreCase("YES")) {
			 // TO-DO: Run the program again 
		 } else if (answer.equalsIgnoreCase("STOP")) {
			 System.exit(0);
		 }
	 }
   
}
