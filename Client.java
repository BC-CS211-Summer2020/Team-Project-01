import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

// Written by Melina Perraut
public class Client { 

	private static boolean foundName; // (Should be inside of a method)
	 
	public static void main(String[] args) throws FileNotFoundException { // TO-DO: create different methods to separate different groups of code in main method
	   // Create scanner objects 
	   //Scanner tudorFamily = new Scanner(new File("tudor.dat")); // Scanner that reads the tudor.dat file with valid names
	   Scanner console = new Scanner(System.in); // Scanner that reads user's input
      
	   String name = "none";
	   System.out.println("Enter \"stop\" to end your search");
	   
	   //new version
	   while (!name.equalsIgnoreCase("STOP")) {
		   System.out.print("Person's name: ");
		   name = console.nextLine();
		   Person input = new Person(name);
		   input.evaluateName();
		   /*for (int i = 0; i < input.firstList.size(); i++) {
			   if (input.firstList.get(i).equalsIgnoreCase(name)) {
				   input.printFamily();
			   }
		   }
		   if (input.firstList.contains(name)) {
			   input.printFamily();
		   } else {
			   System.out.println("could not find name");
		   }
		   */
		   System.out.println();
	   }
	   
	   /*old version
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
					   Person input = new Person(nameInList);
					   input.printFamily();
					   
					   
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
     */
   }
   
	 // Checks whether the user wants to search for another name, and runs the program again if yes
	/* 
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
	 */
   
}

   private static boolean foundName; 
	
   public static void main(String[] args) throws FileNotFoundException { 
      Database db = new Database();
      db.loadDatFile("tudor.dat");
      Scanner console = new Scanner(System.in); // Scanner that reads user's input
      while (true) {
         String name = console.nextLine();
         if (name.equals("STOP")) break;

         System.out.println(db.findPerson(name));
      }

      console.close();


      /*
	// Create scanner objects 
	Scanner tudorFamily = new Scanner(new File("tudor.dat")); // Scanner that reads the tudor.dat file with valid names
	Scanner console = new Scanner(System.in); // Scanner that reads user's input
        run(console, tudorFamily);
        */
   }
   
   public static void run(Scanner console, Scanner tudorFamily) throws FileNotFoundException {
       // Written by Melina Perraut
       // Ask for user input
       System.out.println("Enter person's name (type STOP to quit): ");
       String name = console.next();
      	  
       if (name.equalsIgnoreCase("STOP")) {
      	System.exit(0);
       } 
       else {
         // Search through tudor.dat file for inputted name and create instance of Person object if found
      	 while (tudorFamily.hasNextLine()) { 
      	  String line = tudorFamily.nextLine();
      	  Scanner lineScan = new Scanner(line);
      			   
      		while (lineScan.hasNext() && !(line.equals("END"))) { // For all person names (stopping at first "END" - excludes family names & duplicates)
      		String nameInList = lineScan.next();
      			if (nameInList.equalsIgnoreCase(name)) {
      			   foundName = true;
      		   }           
      		}	
      	 }  
       }
       //Written by Arash Yazdidoost
       if (foundName) {
            Person result = new Person(name);
            System.out.println(result.toString());       	
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
	String answer = console.next();
		 
	if (answer.equalsIgnoreCase("YES")) {
          	run(console, tudorFamily); //Run the program again 
	} else if (answer.equalsIgnoreCase("STOP")) {
		 System.exit(0);
	}
  }
}

