package File_and_its_functionality;

import java.io.File;

public class FileLength {
    public static void main(String[] args) {
        File file2 = new File("locky.txt");
        System.out.println(file2.exists());   // Check if the file2 exists.

        System.out.println(file2.length());


    }
}
