import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Crypt {
    public static void main(String[] args) {
        String data = null;
        String key = null;
        try {
            File myObj = new File("src/message.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("src/key.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                key = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String m = data;
        String k = key;
        Crypt cryptModel = new Crypt();
        System.out.println(cryptModel.cryptString(m,k));
        String x = (cryptModel.cryptString(m,k));
        System.out.println(cryptModel.cryptString(x,k));
    }

    public String cryptString(String message, String key) {
        String result = "";
        while (key.length() < message.length()) {
            key = expandKey(key);
        }

        for (int i = 0 ; i < message.length() ; i++) {
            result += (char)crypt(message.charAt(i), key.charAt(i));
        }
        return result;
    }

    private String expandKey(String key) {
        return  key+key;
    }

    public int crypt(int m, int k) {
        return m ^ k;
    }

}