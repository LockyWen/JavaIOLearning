package File_and_its_functionality;

import java.io.File;

public class DeleteFileOrDirectory {
    public static File file = new File("helloWorld.txt");
    public static File direc = new File("kkk");
    public static File direcs = new File("lockyWen\\207A+\\236Get90+");

    public static void main(String[] args) {
        file.delete();
        direc.delete();
        direcs.delete(); // This does not work, showing that delete can only work on leave.
    }
}
