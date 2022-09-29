import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Crypt {
    //Läsa in fil
    public String readFile(String filename)
    {
        String Message = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = in.readLine()) != null) {
                Message += str;
            }
            in.close();
        } catch (IOException e) {
        }
        return Message;
    }

    public void crypt(String message, String Key) {
        String CryptMessage = "";
        int i = 0;
        for (char c : message.toCharArray()) {
            int cInt = (int) c;
            int keyInt = (int) Key.charAt(i);
            int cryptInt = cInt ^ keyInt;
            char cryptChar = (char) cryptInt;
            CryptMessage += cryptChar;
            i++;
            if (i == Key.length()) {
                i = 0;
            }
        }
        System.out.println(CryptMessage);
    }


    public String readKey(String KeyFilename) {
        String key = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(key));
            String str;
            while ((str = in.readLine()) != null) {
                key += str;
            }
            in.close();
        } catch (IOException e) {
        }
        return key;
    }

    public static void main(String[] args) {
        Crypt crypt = new Crypt();
        String message = crypt.readFile("message.txt");
        String key = crypt.readKey("key.txt");
        crypt.crypt(message, key);
    }
}

