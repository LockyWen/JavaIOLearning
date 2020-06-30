package File_and_its_functionality;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static File newFile = new File("helloWorld.txt");

    public static void main(String[] args) {
        try {
            newFile.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
