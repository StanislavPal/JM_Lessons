package Lesson5.FileSystem;

import java.nio.file.Paths;

public class CannonicalPath {
    public static void main(String[] args) {
        String canonical_path_string = "C:\\Windows\\System32\\";
        String absolute_path_string = "C:\\Windows\\System32\\drivers\\..\\";

        System.out.println(Paths.get(canonical_path_string).getParent());
        System.out.println(Paths.get(absolute_path_string).getParent());

        System.out.println();
        System.out.println(Paths.get(canonical_path_string));
        System.out.println(Paths.get(absolute_path_string));
    }
}
