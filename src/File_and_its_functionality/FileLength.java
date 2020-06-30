package File_and_its_functionality;

import java.io.File;

public class FileLength {
    public static void main(String[] args) {
        File file2 = new File("locky.txt");
        System.out.println(file2.exists());   // Check if the file2 exists.

        System.out.println(file2.length());

        // We can never get the length of the directory (return 0 only)

        File file3 = new File("test1");
        System.out.println(file3.exists());
        System.out.println(file3.length());


    }
}
