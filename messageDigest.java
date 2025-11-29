import java.util.* ;
import java.security.*;

public class messageDigest {
    public static String digest(String text , String method ) throws Exception {
        MessageDigest md = MessageDigest.getInstance(method);
        byte[] encrypted_bytes=md.digest(text.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte i : encrypted_bytes){
            sb.append(String.format("%02x",i));
        }
        return sb.toString();
    }
    public static void main (String args [])throws Exception {
        String text = "Test1";
        
        //System.out.println(digest(text, "SHA-1"));
        System.out.println(digest(text, "MD5"));

    }
}
