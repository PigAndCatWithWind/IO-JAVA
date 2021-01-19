package IO;

import java.io.*;

public class IOInputStream {
    public static void main(String[] args) throws IOException {
        //1、创建源
        File file = new File("abc.txt");
        file.createNewFile();
        //2、选择流
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            //3、操作

//            int temp ;
//            while ((temp=inputStream.read())!=-1)
//                System.out.println((char) temp);

            //分段读取
            byte[] bytes = new byte[5];
            int len = -1;
            while ((len=inputStream.read(bytes))!=-1){
                String string = new String(bytes,0,len);
                System.out.println(string);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            //4、释放资源
           try {
               if (null!=inputStream)
                   inputStream.close();
           }catch (IOException e){
               e.printStackTrace();
           }
        }

    }
}
