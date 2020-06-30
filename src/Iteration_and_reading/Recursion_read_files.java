package Iteration_and_reading;

import java.io.File;
import java.util.ArrayList;

public class Recursion_read_files {
    public static File file = new File("ListMethod");

    //main method
    public static void main(String[] args) {
        Recursion re = new Recursion();
        System.out.println(re.readFile(file));
    }
}

class Recursion{

    public ArrayList<File> readFile(File fileInput){
        ArrayList<File> result = new ArrayList<>();

        if(!fileInput.isDirectory()){
            result.add(fileInput);
            return result;                              // Base Case: if it is a file, then add to the list
        }else{
            for(File y: fileInput.listFiles()){
                result.addAll(readFile(y));             // Inductive Step: readFile returns the files of the directory y,
                                                        // add it to the result ArrayList<>
            }
        }

        return result;
    }
}
