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

### FileFilter and FilenameFilter and Anonymous Class

Let's see two filters in Java.io.File. They are FileFilter and FilenameFilter and both are interfaces. 

Let's see FileFilter first, which has only one method named accept(), returning a boolean value. 

This  interface serves as a filter to filt the File(Object).

However, FilenameFilter's only method accept has two parameters, which are (File) directory and (String) filename.

Let's see how it works. 

Firstly, we note that FileFilter is an interface, then we should make a new Class named FileFilterImplement which implements the Filefilter. 

Let's see the code!!

    public class FileFilterImplement implements FileFilter {
        @Override
    
        /**
         * accept will get rid of all files that is not a txt
         */
        public boolean accept(File pathname) {
            return pathname.isDirectory() || (pathname.getAbsolutePath().endsWith(".txt"));
        }
    }
    
This filter only has one method accept. If it returns true then we can maintain the 
pathname or else we will get rid of it. 

But why we need to check whether it is a directory? This is because a directory never ends with ".txt" but it may have text files in it. 
Recall that we use recursion to search for the pathnames. If we filter a directory, we can never access
the text files in it. Just Image that cutting down a branch makes all leaves on it gone.

    class Recursion{
    
        public ArrayList<File> readFile(File fileInput){
            ArrayList<File> result = new ArrayList<>();
    
            if(!fileInput.isDirectory()){
                result.add(fileInput);
                return result;                              
            }else{
                for(File y: fileInput.listFiles(new FileFilterImplement())){ // Different 
                    result.addAll(readFile(y));            

                }
            }
            return result;
        }
    }

Now, let's go back to the Recursion class and add a new FileFilter into the listFiles. 
This should work. 

Yeah, pretty cool ehh!

Now, let's see how FilenameFilter works. This time, I will use the anonymous class.
A very nice approach. 

    class Recursioner{
    
        public ArrayList<File> readFile(File fileInput){
            ArrayList<File> result = new ArrayList<>();
    
            if(!fileInput.isDirectory()){
                result.add(fileInput);
                return result;
            }else{
                for(File y: fileInput.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".txt");
                    }
                })){
                    result.addAll(readFile(y));
                }
            }
            return result;
        }
    }

The class Recursioner works the same as the Recursion class. But, we use a more Zhuangbility way for it. 
That is, we create an inner class inside a Recursioner instead of create another big class for it. We call it anonymous class
and it can be only used once. 

Please read through the code again and again until you understand what happens. 

A more professional way is to use Lambda!!

    class RecursionLambda{
        public ArrayList<File> readFile(File fileInput){
            ArrayList<File> result = new ArrayList<>();
    
            if(!fileInput.isDirectory()){
                result.add(fileInput);
                return result;
            }else{
                for(File y: fileInput.listFiles(pathname -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".txt"))){
                    result.addAll(readFile(y));
                }
            }
            return result;
        }
    }
    
Let's look at the class RecursionLambda. We see that the input value is in front of the -> while the return value is after the ->. 
And we even do not have to declare the reference type of the input value. 

This is the most simplest way of Lambda. 

This is all I want to talk about File. Next, we would go to a brand new field called InputStream and OutputStream. 
This helps you store the data in your hardware. It really lighten your world.

#Input Stream Or Output Stream 

A hardware can store the data forever. But in an algorithm, all variables and objects will be gone after the code ends if you do not store the data specifically. 

Here, we see how to store or read the data.

Let's see a diagram.

HARDWARE --- Input Stream --> Random Access Memory \
Random Access Memory --- Output Stream --> HARDWARE

Then you should know that input stream helps you read the file from the HARDWARE while output stream
helps you store the file from the RAM. 

RAM is the place where you can store the data temporary in the Computer. 

Then, what does stream means? \
We should know that every data transmits in the form of bytes. That is called stream. 

Let's see the class OutputStream, which is a super class.

This class has many child classes. We will discuss the FileOutputStream here. 

### FileOutputStream
The function is to write the data from RAM into the hardware. 

There are two constructors for it \
FileOutputStream(File file)\
FileOutputStream(String pathname)

The parameter shows the destination of the data we output. 

There are three functions for the constructor. Firstly, create a FileOutputStream object. Secondly, create a file in the 
pathname position. Thirdly, point the object to the new created file. 

Suppose you are a suspicious person and you don't trust my words... Ok, please go to the FileOutputConstructor class and run the code.
You can see a new file csc.txt is created. 

    package FileOutputStream;
    
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    
    public class FileOutputConstructor {
        public static File file1 = new File("csc.txt");
    
        public static void main(String[] args) throws FileNotFoundException {
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
        }
    }
    
Next we should, of course, know how to write the data into this file. But, how it works?

To make this happens, java should firstly go to the JVM (Java Virtual Evnironment). Then, JVM can access the Operating System.
After that, OS can call its method that can write the data into the hardware. 
After that, we can have the authority to write the data. 

OK, we, as a programmer, do not have to go into the computer deeply and see what had happened. Instead, 
we should know how the input stream works with JAVA. 

You should, firstly, new a FileOutputStream then use the write method to write the data and finally we use the close to release the memory. 

If you don't use the close(), FileOutputStream will occupy lots of resources and it will decrease the efficiency of your program, 
Yeah, if you donot close then Java will not give you an Exception. But it's a bad program.

Similarly, you should handle the exception named FileNotFoundException (throws OR try catch) when you new a FileOutputStream. And an IOException when you call the write method. 

FileNotFoundException is the child exception of the IOException. 

When we write the integer, the integer will transfer from decimal representation to binary representation. 

An external fact is that when we open the Notepad/ docx ... It will first translate the bytes to character. 
0 ~ 127 goes to ASCII while Chinese characters goes to GBK. 








