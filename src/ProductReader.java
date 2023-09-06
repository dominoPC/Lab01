import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;
import javax.swing.JFileChooser;

public class ProductReader {
    public static void main(String[] args) {
        try{
            JFileChooser chooser = new JFileChooser();
            File directory = new File(System.getProperty("user.dir")); //get the present working directory
            chooser.setCurrentDirectory(directory); //sets the default directory
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){ //prompt to select a file
                //create a buffered input stream from the chosen file
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                List<Product> products = new ArrayList<>();
                while(reader.ready()){
                    String line = reader.readLine(); //read each line in the file
                    String[] data = line.split(","); //create a String array from the line delineated by commas
                    Product record = new Product(data[0],data[1],data[2],Double.parseDouble(data[3]));
                    products.add(record);
                }
                System.out.println("ID#    | Name      | Description             | Cost");
                System.out.println("-------+-----------+-------------------------+--------");
                for(Product record:products) {
                    System.out.print(record.getID() + " |"); //print ID
                    System.out.print(String.format(" %-10s", record.getName()) + "|"); // name
                    System.out.print(String.format(" %-24s", record.getDescription()) + "|"); //description
                    System.out.println(" " + Double.toString(record.getCost())); //cost
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