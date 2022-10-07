import java.util.Scanner;

public class Crypt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Message");
        String word  = sc.nextLine();
        System.out.println("Enter Key");
        String key = sc.nextLine();
        String m = word;
        String k = key;
        Crypt2 cryptModel = new Crypt2();
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