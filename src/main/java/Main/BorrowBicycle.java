package Main;

import java.io.*;

public class BorrowBicycle {
    public static void fileReader(){
        File file = new File("bicycles data.txt");
        try {
            BufferedReader obj = new BufferedReader(new FileReader(file));
            String read;
            while ((read = obj.readLine()) != null ){
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
