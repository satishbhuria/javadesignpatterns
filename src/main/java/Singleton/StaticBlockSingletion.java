package Singleton;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingletion {

    private StaticBlockSingletion() throws IOException {
        System.out.println("Singleton is Intializing");
        File.createTempFile(".", ".");
    }

    private static StaticBlockSingletion INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockSingletion();
        } catch (Exception e) {
            System.err.println("failed to create object");
        }
    }

    public static StaticBlockSingletion getInstance() {
        return INSTANCE;
    }
}
