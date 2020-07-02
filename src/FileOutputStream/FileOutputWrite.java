package FileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputWrite {
    public static File file2 = new File("cscd.txt");
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(199);
        fileOutputStream.close();
    }
}
