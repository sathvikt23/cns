import java.util.*;
import java.security.*;

public class messageDigest2 {
    public static void digest (String message, String method ) throws Exception {
        MessageDigest md = MessageDigest.getInstance(method);
        byte[] ciphertext = md.digest(message.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte i : ciphertext){
            sb.append(String.format("%02x",i));
        }
        System.out.println(sb.toString());

    }
    public static void main (String args []) throws Exception {
          digest("Hello", "SHA-1");
    }
}
