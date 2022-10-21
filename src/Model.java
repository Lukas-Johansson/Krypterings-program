import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Model {
    private String message;
    private String key;
    private String crypt;

    public String getCrypt() {
        return crypt;
    }

    public void cryptString() {
        String result = "";
        while (key.length() < message.length()) {
            key = expandKey(key);
        }
        for (int i = 0 ; i < message.length() ; i++) {
            result += (char)crypt(message.charAt(i), key.charAt(i));
        }
        crypt = result;
    }

    private String expandKey(String key) {
        return key+key;
    }

    private int crypt(int m, int k) {
        return m^k;
    }

    public void FileReader() {
        try {
            File myObj = new File("src/message.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                message = myReader.nextLine();
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
    }

    public static void main(String[] args) {
        Model cryptModel = new Model();
        cryptModel.FileReader();
        cryptModel.cryptString();
        System.out.println(cryptModel.getCrypt());

        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(cryptModel.getCrypt());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}