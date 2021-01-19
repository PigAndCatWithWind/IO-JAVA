package IO;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        byteArrayToFile(fileToByteArray("src/p.png"),"copy_p.png");
    }

    public static byte[] fileToByteArray(String path){
        File file = new File(path);
        InputStream inputStream = null ;
        ByteArrayOutputStream byteArrayOutputStream = null ;
        try {
            inputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(bytes))!=-1)
                byteArrayOutputStream.write(bytes,0,bytes.length);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != inputStream)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void byteArrayToFile(byte[] bytes,String path){
        File file = new File(path);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new ByteArrayInputStream(bytes);
            outputStream = new FileOutputStream(file);
            byte[] temp = new byte[10];
            int len = -1;
            while ((len = inputStream.read(temp))!=-1)
                outputStream.write(temp,0,len);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null!=outputStream)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
