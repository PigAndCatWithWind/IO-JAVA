package Commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonsIO {
    public static void main(String[] args) throws IOException {
        long len = 0 ;
        len = FileUtils.sizeOf(
                new File("src/Commons/CommonsIO.java")
        );
        System.out.println("文件CommonsIO.java大小: "+len);

        len = FileUtils.sizeOf(
                new File("src")
        );
        System.out.println("目录src大小: "+len);


        //read file
        String string;
        string = FileUtils.readFileToString(new File("baidu.html"),"UTF-8");
        System.out.println("读取文件baidu.html: "+string);

        //逐行读取
        List<String> stringList = FileUtils.readLines(new File("abc.txt"),"UTF-8");
        System.out.println("--------one way ------");
        for (String s : stringList)
            System.out.println(s);

        System.out.println("--------two way ------");
        LineIterator lineIterator = FileUtils.lineIterator(new File("abc.txt"),"UTF-8");
        while (lineIterator.hasNext())
            System.out.println(lineIterator.nextLine());

        //write file
        FileUtils.write(new File("abc.txt"),"学习是一件伟大的事业\r\n","UTF-8");
        FileUtils.writeStringToFile(new File("abc.txt"), "学习是一件辛苦的事业\r\n","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("abc.txt"), "学习是一件幸福的事业\r\n".getBytes("UTF-8"),true);

        //写出列表
        List<String> datas =new ArrayList<String>();
        datas.add("马云");
        datas.add("马化腾");
        datas.add("弼马温");

        FileUtils.writeLines(new File("abc.txt"), datas,"。。。。。",true);
    }
}
