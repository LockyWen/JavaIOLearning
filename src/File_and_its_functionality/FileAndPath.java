package File_and_its_functionality;

import java.io.File;

public class FileAndPath {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath()); // Get the absolute path for file
        System.out.println(file.getPath());         // Get the relative path for file

        System.out.println(file.toString());        // toString method returns the relative path of file
        System.out.println(file.length());          // This method returns 0 since file DNE
    }
}
