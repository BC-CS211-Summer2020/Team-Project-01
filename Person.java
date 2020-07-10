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

import java.util.ArrayList;

public class Person{

   /*
   * Fields
   */
   
   // Constructor
   public Person() {
      ;
   }
   
   /*
   * Finds the first and second list values and append them to their 
   * respective ArrayList fields
   */
   public void seperateLists() {
      ;
   }
   
   /*
   * Splits up the second list into lists of three values each and then 
   * append those to another ArrayList
   */
   public void createListOfFamilies() {
      ;
   } 
   
   /*
   * Finds the parents 
   */
   public void parents() {
      ;
   }
   
   /*
   * Finds the children
   */   
   public void children() {
      ;
   }
   
   /*
   * Calls the methods that parses the data file 
   * and updates the Person fields
   */
   public void getFamily() {
      seperateLists();
      createListOfFamilies();
      parents();
      children();
   }
   
   /*
   * Prints out the family of the Person 
   */
   public String toString() {
      // Filler code to allow program to compile
      String childrenString = "";
      return childrenString;
   }
}
