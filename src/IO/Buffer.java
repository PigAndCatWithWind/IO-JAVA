package IO;

import java.io.*;

public class Buffer {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))){
            String string = "";
            while (!string.equals("exit")){
                string = bufferedReader.readLine();
                bufferedWriter.write(string);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch (IOException e){
            System.out.println("操作异常");
        }
    }
}
