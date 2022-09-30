import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

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

        String str1 = data;
        char[] ch1 = str1.toCharArray();
        for (char c : ch1) {
            System.out.println(c);
            char d = c;
            String s=String.valueOf(d);
            int z = Integer.parseInt(s,2);
            int teck = c;
            int key2 = '¤';
            String binarykey = Integer.toBinaryString(key2);
            String binaryteck = Integer.toBinaryString(teck);
            int Intinaryteck = Integer.parseInt(binaryteck, 2);
            int intbinarykey = Integer.parseInt(binarykey, 2);
            int xorteck = Intinaryteck ^ intbinarykey;
            int decoder = xorteck ^ intbinarykey;
            int yourInt = decoder;
            char ch = (char) yourInt;
            System.out.println(yourInt);
            System.out.println(ch);
        }
    }
}