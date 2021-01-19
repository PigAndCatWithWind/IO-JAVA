package IO;

import java.io.File;

public class DirDemo {
    public static void main(String[] args) {
        File dir = new File("src/IO");

        //son fire name
        String[] son = dir.list();
        for (String name : son)
            System.out.println(name);

        //parent fire name
        File[] parent = dir.listFiles();
        for (File file : parent)
            System.out.println(file.getAbsolutePath());

    }
}
