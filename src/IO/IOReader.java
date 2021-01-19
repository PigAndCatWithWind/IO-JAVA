package IO;

import java.io.*;

public class IOReader {
    public static void main(String[] args) {
        //1、创建源
        File file = new File("abc.txt");
        //2、选择流
        Reader reader = null;
        try {
            reader = new FileReader(file);
            //3、操作
//            int temp;
//            while ((temp=reader.read())!=-1)
//                System.out.println((char)temp);

            //分段读取
            char[] chars = new char[15];
            int len = -1;
            while ((len = reader.read(chars))!=-1)
                System.out.println(new String(chars,0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            if (null!=reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
