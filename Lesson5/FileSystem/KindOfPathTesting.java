package Lesson5.FileSystem;

import java.io.File;
public class KindOfPathTesting {
    public static void main(String [] args) {
        File f = new File("test/.././file.txt");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        try {
            System.out.println(f.getCanonicalPath());
        }
        catch(Exception e) {}
    }
}