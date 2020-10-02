package Lesson5;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Lesson_5_4_7 {
    public static void main(String[] args) {
        try (ByteArrayOutputStream baos  = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {

            byte[] arr = baos.toByteArray();
            System.out.println(Arrays.toString(arr));
            oos.writeInt(256);
            oos.writeInt(65536);
//            oos.write(255);
            oos.flush();
            arr = baos.toByteArray();
            deserializeAnimalArray(arr);
            for (byte b: arr) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals;
//        System.out.println(Arrays.toString(data));
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try(ObjectInputStream ois = new ObjectInputStream(bais)) {
            int size = ois.readInt();
//            System.out.println("size: " + size);
            animals = new Animal[size];
            for (int i = 0; i < size; i++) {
                animals[i] = (Animal) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
        return animals;
    }
}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}
