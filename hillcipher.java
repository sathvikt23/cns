import java.util.Scanner;

public class HillCipher {

    static int[][] key = {{1,2},{3,5}};

    static int mod26(int x) {
        return (x % 26 + 26) % 26;
    }

    public static String encrypt(String text) {
        int a = text.charAt(0) - 'A';
        int b = text.charAt(1) - 'A';

        char c1 = (char)(mod26(key[0][0]*a + key[0][1]*b) + 'A');
        char c2 = (char)(mod26(key[1][0]*a + key[1][1]*b) + 'A');

        return "" + c1 + c2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext (2 letters): ");
        String text = sc.next().toUpperCase();

        String enc = encrypt(text);
        System.out.println("Encrypted Text: " + enc);

        sc.close();
    }
}