package Filter;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImplement implements FileFilter {
    @Override

    /**
     * accept will get rid of all files that is not a txt
     */
    public boolean accept(File pathname) {
        return pathname.isDirectory() || (pathname.getAbsolutePath().endsWith(".txt"));
    }
}
