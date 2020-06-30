package File_and_its_functionality;

import java.io.File;

public class IsFileOrIsDirectory {
    public static File directory = new File("test1");
    public static File txt = new File("locky.txt");
    public static File DNE = new File("adhsjasdhdjsadj.txt"); // This file DNE

    public static void main(String[] args) {
        System.out.println(directory.isDirectory());
        System.out.println(directory.isFile());

        System.out.println(txt.isDirectory());
        System.out.println(txt.isFile());

        System.out.println(DNE.isFile());
        System.out.println(DNE.isDirectory());
    }
}
