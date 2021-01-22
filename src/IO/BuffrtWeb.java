package IO;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BuffrtWeb {
    public static void main(String[] args) {

        try (BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new URL("http://www.baidu.com").openStream(),"UTF-8"
                        )
                );
             BufferedWriter writer =
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("baidu.html"),"UTF-8")
                        )
                ) {
            String string ;
            while ((string = reader.readLine())!=null){
                writer.write(string);
                writer.newLine();
            }
            writer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
