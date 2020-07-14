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
 * Final Submission:  07-14-20
*/

import java.util.*;
import java.io.*;

public class Person{

   
   //Fields
   private String name;
   private ArrayList<String> firstList;
   private ArrayList<String> secondList;
   private ArrayList<ArrayList<String>> familyList;
   private ArrayList<String> parents;
   private ArrayList<String> children;

   // update by Zhexiu, to distingush father and mother
   private Person father;
   private Person mother;
   private ArrayList<Person> childrenList;
   
   // Constructor
   public Person(String name) {
      this.name = name;
      firstList = new ArrayList<>();
      secondList = new ArrayList<>();
      familyList = new ArrayList<>();
      parents = new ArrayList<>();
      children = new ArrayList<>();

      childrenList = new ArrayList<Person>();
   }
   
   /*
   * Finds the first and second list values and append them to their 
   * respective ArrayList fields
   */
   /*
   * Detailed explanation:
   * This method adds all the String elements into firstList and secondList.
   * A Scanner will need to be used to grab the Strings from the .dat file.
   * The 2 lists are seperated by "END" in the .dat file.
   */
   public void separateLists() {  //Diane Lansinger
          
      String line;
      boolean isEnd = false;
      try{
         Scanner file = new Scanner(new File("tudor.dat"));
         //add each name before first "END" to firstList
         //add each name before second "END" to secondList
         while (file.hasNextLine() && !isEnd){
            line = file.nextLine();
            if (line.equals("END")){
               isEnd = true;
            }
            else{
               firstList.add(line.toLowerCase);
            }
         }
         
         isEnd = false;
         
         while (file.hasNextLine() && !isEnd){
            line = file.nextLine();
            if (line.equals("END")){
               isEnd = true;
            }
            else{
               secondList.add(line.toLowerCase);
            }
         }
	 file.close();     
      }
      catch (FileNotFoundException e){
         System.out.println("File tudor.dat not found.");
         System.exit(0);
      }
   }
   
   /*
   * Splits up the second list into lists of three values each and then 
   * append those to another ArrayList
   */
   /*
   * Detailed explanation:
   * This method adds all the String elements into the familyList field.
   * In secondList, every three values represents the child, mother, and 
   * father, repectively. You can only add ArrayList<String> objects to 
   * the familyList field. Each of which should have only three elements.
   */
   public void createListOfFamilies() { //Angela Zou
	   for (int i = 0; i < secondList.size(); i += 3) {
		   familyList.add(new ArrayList<String>(Arrays.asList(secondList.get(i), secondList.get(i+1), secondList.get(i+2))));
	   }
   } 
   
   /*
   * Finds the parents 
   */
   /*
   * Detailed explanation:
   * This method should check every ArrayList<String> object in the 
   * familyList field and find the parents of the Person object using
   * the Person name field. Every familyList field will have exactly 
   * three Strings, the child, mother, and father. The parents found 
   * should be added to the parents ArrayList field.
   */
   public void parents() { // Angela Zou
	   for (int i = 0; i < secondList.size(); i += 3) {
		   if(secondList.get(i).equalsIgnoreCase(this.name)) {
			   parents.add(secondList.get(i+1));
		   }
	   }
	   for (int i = 0; i < secondList.size(); i += 3) {
		   if(secondList.get(i).equalsIgnoreCase(this.name)) {
			   parents.add(secondList.get(i+2));
		   }
	   }
   }
   
   /*
   * Finds the children
   */   
   /*
   * Detailed explanation:
   * This method should check every ArrayList<String> object in the 
   * familyList field and find the children of the Person object using
   * the name field. Every familyList field will have exactly three 
   * Strings, the child, mother, and father.The children found 
   * should be added to the children ArrayList field.
   */
   public void children() { //Angela Zou
	   for (int i = 1; i < secondList.size(); i += 3) {
		   if (secondList.get(i).equalsIgnoreCase(this.name)) {
			   children.add(secondList.get(i-1));
		   }
	   }
	   for (int i = 2; i < secondList.size(); i += 3) {
		   if (secondList.get(i).equalsIgnoreCase(this.name)) {
			   children.add(secondList.get(i-2));
		   }
	   }
   }
   
   /*
   * Calls the methods that parses the data file 
   * and updates the Person fields
   */
   public void getFamily() {  //Alex Filbert
      separateLists();
      createListOfFamilies();
      parents();
      children();
   }
   
   /*
   * Prints out the family of the Person 
   */
   /*
   * Detailed explanation: 
   * This method should return a String that shows the Person 
   * object's family. This method will be envoked after the Person 
   * is instantiated in the Client class. The String should look 
   * exactly like the example in the project exercise in the book.
   */
   public String toString() {
      // Filler code to allow program to compile
      // String  = "family line";
      // TODO: needs update to comply with output format (Maternal line/Parental line)
	/* //print maternal line
	   System.out.println("Maternal line:");
	   System.out.println("\t" + getName());
	   System.out.println("\t\t" + getMother()); //change to parents.get(0)
	   
	   //print paternal line
	   System.out.println("Paternal line:");
	   System.out.println("\t" + getName());
	   System.out.println("\t\t" + getFather()); //change to parents.get(1)
	   
	   //print children
	   System.out.println("Children:");
	   for (String child : getChildren()) { //change to children
	   System.out.println("\t" + child);
	  */
	   
     // Zhexiu Tan
     getFamily();
      ArrayList<String> family = null;
      for(int i = 0; i < familyList.size(); ++i)
      {
         if (name.equals(familyList.get(i).get(0)))
         {
            family = familyList.get(i);
         }
      }
      
      // Zhexiu Tan
      String output = "Person's name? " + name + "\n";
      if (family != null)
      {
         output += "Maternal line: \n\t";
         output += name + "\n\t\t";
         output += family.get(1) + "\n";
         
         output += "Paternal line: \n\t";
         output += name + "\n\t\t";
         output += family.get(2) + "\n";
         
         output += "Children: \n";
         for (String child : children)
         {
            output += "\t" + child + "\n";
         }
      }
      
      return output;
   }
}
