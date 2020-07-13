
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

            addParent(childName, motherName, false);
            addParent(childName, fatherName, true);
        }

        return true;
    }

    public boolean addPerson(Person person)
    {
        return people.add(person);
    }

    public boolean addParent(String childName, String parentName, boolean isFather)
    {
        if (isFather)
        {
            Person child = getPerson(childName);
            Person parent = getPerson(parentName);
            if (child != null && parent != null)
            {
                child.addFather(parent);
                parent.addChild(child);
                return true;
            }
        }
        else
        {
            Person child = getPerson(childName);
            Person parent = getPerson(parentName);
            if (child != null && parent != null)
            {
                child.addMother(parent);
                parent.addChild(child);
                return true;
            }
        }

        return false;
    }

    public Person getPerson(String name)
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
}