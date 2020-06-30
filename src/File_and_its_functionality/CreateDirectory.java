package File_and_its_functionality;

import java.io.File;

public class CreateDirectory {
    public static File direc = new File("kkk");

    public static void main(String[] args) {
        boolean success = direc.mkdir();
        direc.mkdir();
        System.out.println(success);
    }
}
