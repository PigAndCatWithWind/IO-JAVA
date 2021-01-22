package IO;

import java.io.*;

public class IOData {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream =
                new ByteArrayOutputStream();
        DataOutputStream dataOutputStream =
                new DataOutputStream(
                        new BufferedOutputStream(byteArrayOutputStream)
                );

        dataOutputStream.writeUTF("learn data stream");
        dataOutputStream.writeInt(20210122);
        dataOutputStream.writeChar('a');
        dataOutputStream.flush();

        byte[] bytes = byteArrayOutputStream.toByteArray();

        DataInputStream dataInputStream =
                new DataInputStream(
                        new BufferedInputStream(
                                new ByteArrayInputStream(bytes)
                        )
                );
        String string = dataInputStream.readUTF();
        System.out.println(string);
        int i = dataInputStream.readInt();
        System.out.println(i);
        char c = dataInputStream.readChar();
        System.out.println(c);
    }
}
