package IO;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //build file object way one
        String path = "IO/file.txt";
        File file = new File(path);

        //build file object way two
        file = new File("IO","file.txt");
        file = new File("IO/file.txt");

        //build file object way three
        file = new File(new File("src/IO"),"file.txt");

        //print a path that is this project
        System.out.println(System.getProperty("user.dir"));

        //relative path
        System.out.println(file.getAbsolutePath());

        //create file
        boolean flag = file.createNewFile();
        System.out.println(false);

        //print some information
        System.out.println("名称:"+file.getName());
        System.out.println("路径:"+file.getPath());
        System.out.println("绝对路径:"+file.getAbsolutePath());
        System.out.println("父路径:"+file.getParent());
        System.out.println("父对象:"+file.getParentFile().getName());
        System.out.println("长度:"+ file.length());
        System.out.println("是否存在:"+file.exists());
        System.out.println("是否文件:"+file.isFile());
        System.out.println("是否文件夹:"+file.isDirectory());

        flag = file.delete();
    }
}