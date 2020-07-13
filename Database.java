
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public class Database {
    private ArrayList<Person> people;

    public Database() {
        people = new ArrayList<Person>();
    }

    public boolean loadDatFile(String datFilePath) throws FileNotFoundException 
    {
        Scanner tudorFamily = new Scanner(new File(datFilePath)); // Scanner that reads the tudor.dat file with valid names
        while (tudorFamily.hasNextLine()) { 
            String line = tudorFamily.nextLine();
            if (line.equals("END")) 
            {
                break;
            }

            Person person = new Person(line);
            addPerson(person);
        }

        while (tudorFamily.hasNextLine()) { 
            String childName = tudorFamily.nextLine();
            if (childName.equals("END")) 
            {
                break;
            }

            String motherName = tudorFamily.nextLine();
            String fatherName = tudorFamily.nextLine();

            addMother(childName, motherName);
            addFather(childName, fatherName);
        }

        return true;
    }

    public boolean addFather(String childName, String fatherName)
    {
        Person child = findPerson(childName);
        Person parent = findPerson(fatherName);
        if (child != null && parent != null)
        {
            child.setFather(parent);
            parent.addChild(child);
            return true;
        }

        return false;
    }

    public boolean addMother(String childName, String motherName)
    {
        Person child = findPerson(childName);
        Person parent = findPerson(motherName);
        if (child != null && parent != null)
        {
            child.setMother(parent);
            parent.addChild(child);
            return true;
        }

        return false;
    }

    public Person findPerson(String name)
    {
        for(Person p: people)
        {
            if (p.getName().equalsIgnoreCase(name))
            {
                return p;
            }
        }

        return null;
    }

    private boolean addPerson(Person person)
    {
        return people.add(person);
    }
}