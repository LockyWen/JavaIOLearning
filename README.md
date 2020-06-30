# JavaIOLearning
Java IO Practice

## Now Let's go to Java IO Stream. Yeaaaaaaah!!!!(Lindsey.wav)

`Four different separaters for paths`

File.separator \
File.pathSeparator \ 
..

###``File and its functionality``

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

Yes, I believe you know the answers. The file2.length() gives you the number of characters in the file.\
But please remember that length() can never get the size of a directory (return 0 only).
--> Please also refer to the class FileLength.

Next Next, let's see two judge methods (return boolean values). They are File.isFile()
and File.isDirectory(). 

    public class IsFileOrIsDirectory {
        public static File directory = new File("test1");
        public static File txt = new File("locky.txt");
        public static File DNE = new File("adhsjasdhdjsadj.txt"); // This file DNE
    
        public static void main(String[] args) {
            System.out.println(directory.isDirectory()); // true 
            System.out.println(directory.isFile());      // false
    
            System.out.println(txt.isDirectory());      //false
            System.out.println(txt.isFile());           // true
    
            System.out.println(DNE.isFile());           //false
            System.out.println(DNE.isDirectory());      //false
        }
    }

This makes sense and so I don't need to say what happens, right?\
Note that in computer hardware, a text container can either be directory or file. (like roots and leaves in a tree). OKOK, so \
if a path exists then 
file.isDirectory() or file.isFile(). \
If a path DNE then !file.isFile() and !file.isDirectory().

### Create a File or Directory
Let's assume that you know how the functionality of File works. Emmm, are you feeling boring of creating a file by 
pressing a right button and new a file?
 
 A more Zhuangbility way for you is to create a file 
by Code. But How can you do that?

Well, let's create the file from an unexist path. 

OKOK, maybe you know a method File.createNewFile(). Buttt, if you run this method directly, java will definitely gives you a Compile Error. 
How comes?

This is because when you create a file from a DNE path. Java may not find this path (Maybe you get a path with a long long directories but none
of them exist)... Java may get confused for it. So no matter whether the file path is valid, java would expect you to 
throw an exception, which is IOException. 

We know lots of methods to handle the exception. One is throw an exception in the method head. This is too easy and we will 
not cover here. Another way is to try the code and catch the exception. 

    package File_and_its_functionality;
    
    import java.io.File;
    import java.io.IOException;
    
    public class CreateFile {
        public static File newFile = new File("helloWorld.txt");
    
        public static void main(String[] args) {
            try {
                newFile.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

Let's see how this class goes. Please make sure that there is not a file named 
"helloWorld.txt" under your file. 

#### But, what if I want to create a directory ... 

There are two types of methods to be introduced. \
mkdir() : You can only make a single directory\
mkdirs(): You can either make a single directory or a multiple directories.

Both methods may return true when filepath DNE and can create OR false when filepath exists. 

Remember this will NEVER EVER throw an exception. 

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

You can see a directory named "kkk" is created. 

Now if you know that, I would introduce a more general way of creating directories. 

    package File_and_its_functionality;
    
    import java.io.File;
    
    public class CreateDirectories {
        public static File directories = new File("lockyWen\\207A+\\236Get90+");
    
        public static void main(String[] args) {
            boolean success = directories.mkdirs();
            System.out.println(success);
        }
    }

Run this method, pretty cool, HUH!!

Suppose you are so naughty and you create lots of files or directories on your laptop. Ok, your boss may be annoyed when he sees this piles of bullshit. 
You need a quick method to delete specific files or directories. What can you do?

Here, I will introduce a method: File.delete().

Assume that you have run the main method in CreateFile, CreateDirectory and CreateDirectories. 
We now delete them all by using the method in a single class DeleteFileOrDirectory. 

Let's see the code. Yeaaaaaaah! (Lindsey's_voice.wav)

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

Well now you know how to create or delete a file or a directory. Next,\
####Let's iterate through a directory and see what it is. 

Create a directory in this path, named as ListMethod with a directory aaa and a text file bbb.txt in it. 

We intruduce a new method File.list(); to check the contents in ListMethod, which returns 
a String[] with all file/directory names. 

Another more amazing method is File.listFile(); which will return a list of File Objects.

Look at the code and you should see how it works. 

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

Please note that list() or listFile() never works for file and will return a NullPointerException. 
If a pathname DNE, then also gets a NullPointerException. 

#### Use Recursion to search all the file in a directory

I hope that you know recursion, if you don't know. Please go to my GitHub https://github.com/LockyWen/introcutionToAlgorithms_PracticeCodeJava
. Check Chapter 2.3 and then you should know. 

Then, it is very simple to use recursion to check all files in a directory. 

Now let's reuse the file ListMethod again. We see that there are many levels of 
files/directories and it makes no sense for you to use the listFile() to search for all files in it. 
So What should you do? Recursion works!!!

    package Iteration_and_reading;
    
    import java.io.File;
    import java.util.ArrayList;
    
    public class Recursion_read_files {
        public static File file = new File("ListMethod");
        
        //main method 
        public static void main(String[] args) {
            Recursion re = new Recursion();
            System.out.println(re.readFile(file));
        }
    }
    
    class Recursion{
    
        public ArrayList<File> readFile(File fileInput){
            ArrayList<File> result = new ArrayList<>();  
    
            if(!fileInput.isDirectory()){
                result.add(fileInput);
                return result;                              // Base Case: if it is a file, then add to the list
            }else{
                for(File y: fileInput.listFiles()){
                    result.addAll(readFile(y));             // Inductive Step: readFile returns the files of the directory y, 
                                                            // add it to the result ArrayList<>
                }
            }
    
            return result;
        }
    }

Then you should go over all files in the directory ListMethod. Pretty Cool Huh!!

### FileFilter and FilenameFilter

Let's see two filters in Java.io.File. They are FileFilter and FilenameFilter and both are interfaces. 

Let's see FileFilter first, which has only one method named accept(), returning a boolean value. 

This  interface serves as a filter to filt the File(Object).

However, FilenameFilter's only method accept has two parameters, which are (File) directory and (String) filename.

Let's see how it works. 

Firstly, we note that FileFilter is an interface, then we should make a new Class named FileFilterImplement which implements the Filefilter. 

Let's see the code!!






