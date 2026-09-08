import java.io.*;
public class throwsEx {

    public static void main(String[] args) throws IOException{
    FileReader fr = new FileReader("data.txt");
    int ch = fr.read();
    System.out.println((char) ch);
    fr.close();
    }
}

