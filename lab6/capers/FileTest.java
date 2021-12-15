package capers;

import java.io.File;

public class FileTest {

    public static void main(String args[]) {
        File file = new File("some story happened");
        File dir = new File(System.getProperty("user.dir") + "/.capers/story");
        System.out.println("----------------");
        System.out.println(System.getProperty("user.dir"));
    }
}
