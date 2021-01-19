package IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class IOByteArrayOutputStream {
    public static void main(String[] args) {
        //1、创建源
        byte[] bytes = null;
        //2、选择流
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            //3、操作
            String string = "learn byteArrayOutputStream";
            byte[] bytes1 = string.getBytes();
            byteArrayOutputStream.write(bytes1,0,bytes1.length);
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null!=byteArrayOutputStream)
                    byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
