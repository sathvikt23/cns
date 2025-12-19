import java.util.*;

public class substitution {
    static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String encrypt (String message,String key ){
         StringBuilder sb = new StringBuilder();
         for (char i : message.toCharArray()){
            if (Character.isLetter(i)){
                int position = ALPHABET.indexOf(i);
                char letter = key.charAt(position);
                sb.append(letter);
            }else {
                 sb.append(i);
            }
         }
         return sb.toString();
    }
     public static String decrypt (String message,String key ){
         StringBuilder sb = new StringBuilder();
         for (char i : message.toCharArray()){
            if (Character.isLetter(i)){
                int position = key.indexOf(i);
                char letter = ALPHABET.charAt(position);
                sb.append(letter);
            }else {
                sb.append(i);
            }
         }
         return sb.toString();
    }
    public static void main (String args[] ){
        String key ="QWERTYUIOPASDFGHJKLZXCVBNM";
        System.out.println(decrypt(encrypt("HELLO", key), key));
    }
}
