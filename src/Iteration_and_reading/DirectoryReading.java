package Iteration_and_reading;

import java.io.File;

public class DirectoryReading {
    public static File directs = new File("ListMethod");

    public static void main(String[] args) {
        String[] arr = directs.list();
        for(String x: arr){
            System.out.println(x);
        }

        File[] arr2 = directs.listFiles();
        for(File y: arr2){
            System.out.println(y);
        }
    }
}
