package Lesson5.SerializationTest;

import java.io.*;

public class Solution extends Test implements Serializable {
    private String task;
    private String description;

    public Solution(String task, String description) {
        System.out.println("=== Solution constructor");
        this.task = task;
        this.description = description;
    }

//   public void writeObject(ObjectOutputStream out) throws IOException { // - it isn't work
    private void writeObject(ObjectOutputStream out) throws IOException { // - it's work
        out.defaultWriteObject();
        out.writeInt(15);
        System.out.println("Our writeObject");
    }

//   public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException { // - it isn't work
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException { // - it's work
        in.defaultReadObject();
        System.out.println("Our readObject: " + in.readInt());
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
        Solution partizanka = new Solution("1409", "Serializable task");
        System.out.println("Before: \n" + partizanka);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Solution.out"));
        out.writeObject(partizanka);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Solution.out"));
        Solution newPartizanka = (Solution) in.readObject();

        System.out.println("After: \n" + newPartizanka);
    }
}

class Test {
//    Test(){
//        System.out.println("=== Test constructor");
//    }
}