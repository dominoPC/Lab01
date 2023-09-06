import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

public class ProductWriter {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(); //create an ArrayList to store records
        Scanner in = new Scanner(System.in); //Scanner used for SafeInput

        int id = 1;
        do { //runs once before checking for more records
            Product record = new Product(
                    String.format("%06d", id),
                    SafeInput.getNonZeroLenString(in, "Please enter a name"),
                    SafeInput.getNonZeroLenString(in, "Please enter a description"),
                    SafeInput.getDouble(in, "Please enter a cost")
                );
            products.add(record); //adds the record to the products ArrayList
            id++;
        } while(SafeInput.getYNConfirm(in, "Would you like to enter another record?")); //check to enter more records

        String filename = SafeInput.getNonZeroLenString(in, "Please enter a file name");

        try{
            File directory = new File(System.getProperty("user.dir")); //get the present working directory
            Path file = Paths.get(directory.getPath() + "\\src\\" + filename +".txt"); //use the specified filename
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(int i = 0; i < products.size(); i++){ //iterate through the ArrayList
                if(i!=0){ //enter a new line for each record that's not the first
                    writer.newLine();
                }
                writer.write(products.get(i).toCSVDataRecord());
            }
            writer.close(); //flush the stream
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}