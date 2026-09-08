import java.io.*;
public class tryEx {

    public static void main(String[] args){
        try {
            FileReader fr = new FileReader("data.txt");
            int ch = fr.read();
            System.out.println((char) ch);
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

