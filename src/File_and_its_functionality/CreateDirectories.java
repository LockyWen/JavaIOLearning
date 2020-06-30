package File_and_its_functionality;

import java.io.File;

public class CreateDirectories {
    public static File directories = new File("lockyWen\\207A+\\236Get90+");

    public static void main(String[] args) {
        boolean success = directories.mkdirs();
        System.out.println(success);
    }
}
