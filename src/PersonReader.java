import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;
import javax.swing.JFileChooser;

public class PersonReader {
    public static void main(String[] args) {
        try{
            JFileChooser chooser = new JFileChooser();
            File directory = new File(System.getProperty("user.dir")); //get the current working directory
            chooser.setCurrentDirectory(directory); //sets the default directory
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){ //prompt to select a file
                //create a buffered input stream from the chosen file
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                List<Person> persons = new ArrayList<>();
                while(reader.ready()){
                    String line = reader.readLine(); //read each line in the file
                    String[] data = line.split(","); //create a String array from the line delineated by commas
                    Person record = new Person(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]));
                    persons.add(record);
                }
                System.out.println("ID#    | First Name | Last Name | Title | YOB");
                System.out.println("-------+------------+-----------+-------+------");
                for(Person record:persons){
                    System.out.print(record.getID() + " |"); //print ID
                    System.out.print(String.format(" %-11s", record.getFirstName()) + "|"); //first name
                    System.out.print(String.format(" %-10s", record.getLastName()) + "|"); //last name
                    System.out.print(String.format(" %-6s", record.getTitle()) + "|"); //title
                    System.out.println(" " + record.getYOB()); //YOB
                }
                reader.close();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}