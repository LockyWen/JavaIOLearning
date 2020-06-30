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



