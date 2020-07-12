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

public class Client{ //MP (Melina will write the Client class code)
   
   public static void main(String[] args) throws FileNotFoundException {
   
      // System.out.println("What's up world?");
      
      // Create scanner objects - remember to address invalid input (error message)
	   Scanner tudorFamily = new Scanner(new File("tudor.dat")); // Scanner that reads the tudor.dat file with valid names
      Scanner console = new Scanner(System.in); // Scanner that reads user's input
      
      System.out.println("Person's name?");
      String name = console.next();
          
      // Create instance of Person object
      
      // Print Person object's fields in accordance to project specs
      
   }
}
