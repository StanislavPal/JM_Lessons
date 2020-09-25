package Lesson5.SerializationTest;

import java.io.*;

public class Solution2 extends Test2 implements Serializable {
    private String task;
    private String description;

    public Solution2(String task, String description) {
        System.out.println("=== Solution constructor");
        this.task = task;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "task='" + task + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Main start");
        Solution2 partizanka = new Solution2("1409", "Serializable task");
        System.out.println(partizanka);
    }
}

class Test2 {
    Test2(){
        System.out.println("=== Test2 constructor");
    }
}