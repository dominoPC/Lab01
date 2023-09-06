import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

public class PersonGenerator {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(); //create an ArrayList to store records
        Scanner in = new Scanner(System.in); //Scanner used for SafeInput

        int id = 1;
        do { //runs once before checking for more records
            Person record = new Person( //instantiation with SafeInput calls
                    String.format("%06d", id),
                    SafeInput.getNonZeroLenString(in, "Please enter a first name"),
                    SafeInput.getNonZeroLenString(in, "Please enter a last name"),
                    SafeInput.getNonZeroLenString(in, "Please enter a title"),
                    SafeInput.getRangedInt(in, "Please enter a year of birth", 1940, 2000)
                    );

            persons.add(record); //adds the record to the persons ArrayList
            id++;
        } while(SafeInput.getYNConfirm(in, "Would you like to enter another record?")); //check to enter more records

        String filename = SafeInput.getNonZeroLenString(in, "Please enter a file name");

        try{
            File directory = new File(System.getProperty("user.dir")); //get the present working directory
            Path file = Paths.get(directory.getPath() + "\\src\\" + filename +".txt"); //use the specified filename
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(int i = 0; i < persons.size(); i++){ //iterate through the ArrayList
                if(i!=0){ //enter a new line for each record that's not the first
                    writer.newLine();
                }
                writer.write(persons.get(i).toCSVDataRecord());
            }
            writer.close(); //flush the stream
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}