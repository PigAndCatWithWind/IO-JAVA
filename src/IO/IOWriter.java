package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class IOWriter {
    public static void main(String[] args) {
        //1、创建源
        File file = new File("abc.txt");
        //2、选择流
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            //3、操作
            //way one
//            String string = "learn writer is way one ";
//            char[] chars = string.toCharArray();
//            writer.write(chars,0,chars.length);
//            writer.write(chars,0,chars.length);

            //way two
//            String string = "learn writer is way two ";
//            writer.write(string);
//            writer.write("add");
//            writer.flush();

            //way three
            writer.append("learn writer is way three").append(" ok");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            if (null!=writer){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
