package Singleton;

import java.io.*;

public class ReflectionSingletionDemo implements Serializable{

    private ReflectionSingletionDemo() {

    }

    private static ReflectionSingletionDemo INSTANCE = new ReflectionSingletionDemo();

    public static ReflectionSingletionDemo getInstance() {
        return INSTANCE;
    }

    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    /**
     * This is used to solve serialization problem issue
     * @return
     */
    protected Object readResolve() {
        return INSTANCE;
    }
}

class Refdemo {

    static void save(ReflectionSingletionDemo singletionDemo, String fileName) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(singletionDemo);
        }
    }

    static ReflectionSingletionDemo readFromFile(String fileName) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
                return (ReflectionSingletionDemo) inputStream.readObject();
        }
    }

    public static void main(String[] args) throws Exception{
        ReflectionSingletionDemo reflectionSingletionDemo = ReflectionSingletionDemo.getInstance();
        reflectionSingletionDemo.setVal(100);
        String fileName = "satish.txt";
        save(reflectionSingletionDemo, fileName);
        reflectionSingletionDemo.setVal(200);
        ReflectionSingletionDemo reflectionSingletionDemo1 = readFromFile(fileName);
        System.out.println(reflectionSingletionDemo.getVal());
        System.out.println(reflectionSingletionDemo1.getVal());
    }
}
