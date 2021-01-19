package IO;

import java.io.*;

public class Copy {
    public static void main(String[] args) {
        copy("src/IO/Copy.java","Copy_main.java");
    }
   public static void copy(String srcPath,String destPath){
       File src = new File(srcPath);
       File dest = new File(destPath);
       try (InputStream inputStream = new FileInputStream(src);
            OutputStream outputStream = new FileOutputStream(dest)){
           byte[] bytes = new byte[1024];
           int len = -1;
           while ((len = inputStream.read(bytes))!=-1)
               outputStream.write(bytes,0,len);
           outputStream.flush();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
