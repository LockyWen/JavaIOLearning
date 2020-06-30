# JavaIOLearning
Java IO Practice

`Four different separaters for paths`

File.separator \
File.pathSeparator \ 
..

``File and its functionality``\

Now, look at the code in FileAndPath
    
    package File_and_its_functionality;
    
    import java.io.File;
    
    public class FileAndPath {
        public static void main(String[] args) {
            File file = new File("hello.txt");
            System.out.println(file.getAbsolutePath()); // Get the absolute path for file
            System.out.println(file.getPath());         // Get the relative path for file
    
            System.out.println(file.toString());        // toString is the same as getPath
            System.out.println(file.length());  // This method returns 0 since file DNE
        }
    }
    
From the class FileAndPath (you can get this code from src/File_and_its_functionality), we notice that a File is actually an encapsulation of a String (filePath), meaning nothing else.\
The methods return the relative or absolute path of the file.  

You can try to run the main methods and see what happens. 

Emmmmm, it is also kind of confused. What would happen if the file exists and has some contents???

Explicitly, let's create a file by hand named "locky.txt" in this path.

The content is 

    Long Live LockyWen. Long Live UofT CSer.
    
Its has 49 characters, inclusing the space and ".". Next, let's run the code in FileLength class and see what happens. 

    package File_and_its_functionality;
         
         import java.io.File;
         
         public class FileLength {
             public static void main(String[] args) {
                 File file2 = new File("locky.txt");
                 System.out.println(file2.exists());   // Check if the file2 exists.
         
                 System.out.println(file2.length());
         
         
             }
         }

Yes, I believe you know the answers. The file2.length() gives you the number of characters in the file. 