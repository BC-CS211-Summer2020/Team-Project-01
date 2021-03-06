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
 * Person Class represents a person and stores references
 * to this person's mother, father and any children this
 * person has. Person Class reads a file of names to
 * initialize the name and parent/child relationships of 
 * each Person object. An overall list of 'Persons' is
 * stored as an ArrayList. Person Class is called by
 * Client class.
 *
 * Final Submission:  07-15-20
*/

import java.util.*;
import java.io.*;

public class Person {  // skeleton code and explanations for methods -> Alex Filbert

   // Fields -> Alex Filbert
   private String name;
   private ArrayList<String> firstList;
   private ArrayList<String> secondList;
   private ArrayList<String> parents;
   private ArrayList<String> children;

   // Constructor
   public Person(String name) {  // Alex Filbert
      this.name = name;
      firstList = new ArrayList<>();
      secondList = new ArrayList<>();
      parents = new ArrayList<>();
      children = new ArrayList<>();
   }

   // returns correct capitalization
   public String getName() { // Angela Zou
      String name = "unknown";
      for (int i = 0; i < secondList.size(); i++) {
         if (secondList.get(i).equalsIgnoreCase(this.name)) {
            name = secondList.get(i);
         }
      }
      return name;
   }

   /*
    * Finds the first and second list values and append them to their respective
    * ArrayList fields
    */
   /*
    * Detailed explanation: This method adds all the String elements into firstList
    * and secondList. A Scanner will need to be used to grab the Strings from the
    * .dat file. The 2 lists are seperated by "END" in the .dat file.
    */
   public void separateLists() { // Diane Lansinger

      String line;
      boolean isEnd = false;
      try {
         Scanner file = new Scanner(new File("tudor.dat"));
         // add each name before first "END" to firstList
         // add each name before second "END" to secondList
         while (file.hasNextLine() && !isEnd) {
            line = file.nextLine();
            if (line.equals("END")) {
               isEnd = true;
            } else {
               firstList.add(line.toLowerCase());
            }
         }

         isEnd = false;

         while (file.hasNextLine() && !isEnd) {
            line = file.nextLine();
            if (line.equals("END")) {
               isEnd = true;
            } else {
               secondList.add(line);
            }
         }
         file.close();

      } catch (FileNotFoundException e) {
         System.out.println("File tudor.dat not found.");
         System.exit(0);
      }
   }

   /*
    * Finds the parents
    */
   /*
    * Detailed explanation: This method should check every ArrayList<String> object
    * in the familyList field and find the parents of the Person object using the
    * Person name field. Every familyList field will have exactly three Strings,
    * the child, mother, and father. The parents found should be added to the
    * parents ArrayList field.
    */
   public void parents() { // Angela Zou
      for (int i = 0; i < secondList.size(); i += 3) {
         if (secondList.get(i).equalsIgnoreCase(this.name)) {
            parents.add(secondList.get(i + 1));
         }
      }
      for (int i = 0; i < secondList.size(); i += 3) {
         if (secondList.get(i).equalsIgnoreCase(this.name)) {
            parents.add(secondList.get(i + 2));
         }
      }
      if (parents.isEmpty()) {
         parents.add("unknown");
         parents.add("unknown");
      }
   }

   /*
    * Finds the children
    */
   /*
    * Detailed explanation: This method should check every ArrayList<String> object
    * in the familyList field and find the children of the Person object using the
    * name field. Every familyList field will have exactly three Strings, the
    * child, mother, and father.The children found should be added to the children
    * ArrayList field.
    */
   public void children() { // Angela Zou
      for (int i = 1; i < secondList.size(); i += 3) {
         if (secondList.get(i).equalsIgnoreCase(this.name)) {
            children.add(secondList.get(i - 1));
         }
      }
      for (int i = 2; i < secondList.size(); i += 3) {
         if (secondList.get(i).equalsIgnoreCase(this.name)) {
            children.add(secondList.get(i - 2));
         }
      }
      if (children.isEmpty()) {
         children.add("No children");
      }
   }

   /*
    * Calls the methods that parses the data file and updates the Person fields
    */
   public void getFamily() { // Alex Filbert
      separateLists();
      parents();
      children();
   }

   /*
    * Prints out the family of the Person
    */
   /*
    * Detailed explanation: This method should return a String that shows the
    * Person object's family. This method will be envoked after the Person is
    * instantiated in the Client class. The String should look exactly like the
    * example in the project exercise in the book.
    */
   public String toString() { // Zhexiu Tan

      String output = "Maternal line: \n\t";
      output += getName() + "\n\t\t";
      output += parents.get(0) + "\n";

      output += "Paternal line: \n\t";
      output += getName() + "\n\t\t";
      output += parents.get(1) + "\n";

      output += "Children: \n";
      for (String child : children) {
         output += "\t" + child + "\n";
      }
      return output;
   }
}
