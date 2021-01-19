package IO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOByteArrayInputStream {
    public static void main(String[] args) {
        //1、创建源
        byte[] bytes = "learn IO ByteArrayInputStream".getBytes();
        //2、选择流
        InputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(bytes);
            //3、操作
            byte[] temp = new byte[10];
            int len = -1;
            while ((len = inputStream.read(temp))!=-1)
                System.out.println(new String(temp,0,temp.length));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            try {
                if (null!=inputStream)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
