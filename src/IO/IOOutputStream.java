package IO;

import java.io.*;

public class IOOutputStream {
    public static void main(String[] args) {
        //1、创建源
        File file = new File("abc.txt");
        //2、选择流
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file,true);
            //3、操作
            String string = "IO is so easy\r\n";
            byte[] bytes = string.getBytes();// 字符串-->字节数组(编码)
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
