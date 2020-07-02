package Filter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Objects;

public class FileNameFilter_and_Anonymous {
    public static File file = new File("ListMethod");

    //main method
    public static void main(String[] args) {
//        Recursioner re = new Recursioner();
//        System.out.println(re.readFile(file));
        RecursionLambda relam = new RecursionLambda();
        System.out.println(relam.readFile(file));
    }
}

class Recursioner{

    public ArrayList<File> readFile(File fileInput){
        ArrayList<File> result = new ArrayList<>();

        if(!fileInput.isDirectory()){
            result.add(fileInput);
            return result;
        }else{
            for(File y: fileInput.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".txt");
                }
            })){
                result.addAll(readFile(y));
            }
        }
        return result;
    }
}

class RecursionLambda{
    public ArrayList<File> readFile(File fileInput){
        ArrayList<File> result = new ArrayList<>();

        if(!fileInput.isDirectory()){
            result.add(fileInput);
            return result;
        }else{
            for(File y: fileInput.listFiles(pathname -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".txt"))){
                result.addAll(readFile(y));
            }
        }
        return result;
    }
}
