package Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public enum EnumBasedSingleton {

    // Singleton by default
    INSTANCE;

    // always private
    EnumBasedSingleton() {
        value = 42;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class demo2 {

    static void save(EnumBasedSingleton singletionDemo, String fileName) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(singletionDemo);
        }
    }

    static EnumBasedSingleton readFromFile(String fileName) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
            return (EnumBasedSingleton) inputStream.readObject();
        }
    }

    public static void main(String[] args) throws Exception{
        EnumBasedSingleton enumBasedSingleton = EnumBasedSingleton.INSTANCE;
        enumBasedSingleton.setValue(100);
        String fileName = "satish1.txt";
        save(enumBasedSingleton, fileName);
        enumBasedSingleton.setValue(200);
        EnumBasedSingleton enumBasedSingleton1 = readFromFile(fileName);
        System.out.println(enumBasedSingleton.getValue());
        System.out.println(enumBasedSingleton1.getValue());
    }
}
