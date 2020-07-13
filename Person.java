import java.util.*;
import java.io.*;

public class Person{

   
   //Fields


	private String name;
	private ArrayList<String> firstList = new ArrayList<>();
	private ArrayList<String> secondList = new ArrayList<>();
	/*
	private ArrayList<ArrayList<String>> familyList = new ArrayList<>();
	private ArrayList<String> parents = new ArrayList<>();
	private ArrayList<String> children = new ArrayList<>();
	*/
   
   // Constructor
   public Person(String name) {
	   this.name = name.toLowerCase();
	   separateLists();
	   /*
	   createListOfFamilies();
	   parents();
	   children();
	   */
   }
   
   public String getName() {
	   String result = "none";
	   for (int i = 0; i < secondList.size(); i++) {
		   if (secondList.get(i).equalsIgnoreCase(this.name)) {
			   result = secondList.get(i);
		   }
	   }
	   return result;

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
      boolean end1 = false;
      boolean end2 = false;
      try{
         Scanner file = new Scanner(new File("tudor.dat"));
         //add each name before first "END" to firstList
         //add each name before second "END" to secondList
         while (file.hasNextLine() && !end1){
            line = file.nextLine();
            if (line.equals("END")){
               end1 = true;
            }
            else{
               firstList.add(line.toLowerCase());
            }
         }

         while (file.hasNextLine() && !end2){

         
         isEnd = false;
         
         while (file.hasNextLine() && !isEnd){

            line = file.nextLine();
            if (line.equals("END")){
               end2 = true;
            }
            else{
               secondList.add(line);
            }
         }          
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
   /*
   public void createListOfFamilies() { //Angela Zou
	   for (int i = 0; i < secondList.size(); i += 3) {
		   familyList.add(new ArrayList<String>(Arrays.asList(secondList.get(i), secondList.get(i+1), secondList.get(i+2))));
	   }
   }
   */
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
   /*
   public void parents() { // Angela Zou
	   for (int i = 1; i < secondList.size(); i += 3) {
		   if (!parents.contains(secondList.get(i))) {
			   parents.add(secondList.get(i));
		   }
	   }
	   for (int i = 2; i < secondList.size(); i += 3) {
		   if (!parents.contains(secondList.get(i))) {
			   parents.add(secondList.get(i));
		   }
	   }
   }
   */
   
   public String getMother() { //Angela Zou
	   String mother = "unknown";
	   for (int i = 0; i < secondList.size(); i += 3) {
		   if(secondList.get(i).equalsIgnoreCase(this.name)) {
			   mother = secondList.get(i+1);
		   }
	   }
	   return mother;
   }
   
   public String getFather() { //Angela Zou
	   String father = "unknown";
	   for (int i = 0; i < secondList.size(); i += 3) {
		   if(secondList.get(i).equalsIgnoreCase(this.name)) {
			   father =  secondList.get(i+2);
		   }
	   }
	   return father;
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
   /*
   public void children() { //Angela Zou
	   for (int i = 1; i < secondList.size(); i += 3) {
		   children.add(secondList.get(i));
	   }
   }
   */
   
   public List<String> getChildren() { //Angela Zou
	   List<String> imediateChildren = new ArrayList<>();
	   for (int i = 1; i < secondList.size(); i += 3) {
		   if (secondList.get(i).equalsIgnoreCase(this.name)) {
			   imediateChildren.add(secondList.get(i-1));
		   }
	   }
	   for (int i = 2; i < secondList.size(); i += 3) {
		   if (secondList.get(i).equalsIgnoreCase(this.name)) {
			   imediateChildren.add(secondList.get(i-2));
		   }
	   }
	   return imediateChildren;
   }
   
   /*
   * Calls the methods that parses the data file 
   * and updates the Person fields
   */
   /*
   public void getFamily() {  //Alex Filbert
      try{
         separateLists();
      } catch(Exception e) {
         e.printStackTrace();   
      }
      createListOfFamilies();
      parents();
      children();
   }
   */
   
   public void printFamily() { //Angela Zou
	   //print maternal line
	   System.out.println("Maternal line:");
	   System.out.println("\t" + getName());
	   System.out.println("\t\t" + getMother());
	   
	   //print paternal line
	   System.out.println("Paternal line:");
	   System.out.println("\t" + getName());
	   System.out.println("\t\t" + getFather());
	   
	   //print children
	   System.out.println("Children:");
	   for (String child : getChildren()) {
		   System.out.println("\t" + child);
	   }
   }
   
   public void evaluateName() {
	   if (firstList.contains(this.name)) {
		   printFamily();
	   } else if (!name.equals("stop")){
		   System.out.println("not found");
	   }
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
   /*
   public String toString() {
      // Filler code to allow program to compile

      String childrenString = "";
      return childrenString;

      // String  = "family line";
      // TODO: needs update to comply with output format (Maternal line/Parental line)
      return "Name: " + name + " Mother: " + getMother().getName() + " Father: " + getFather().getName();
   }

   public String getName()
   {
      return name;
   }

   public void setFather(Person father)
   {
      this.father = father;
   }

   public void setMother(Person mother)
   {
      this.mother = mother;
   }

   public void addChild(Person child)
   {
      this.childrenList.add(child);
   }

   public Person getFather()
   {
      return father;
   }

   public Person getMother()
   {
      return mother;
   }

   public ArrayList<Person> getChildren()
   {
      return childrenList;

   }
   */
}
