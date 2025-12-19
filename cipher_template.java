import java.util.*;
import javax.crypto.*;
class allCipher{
    String method ;
    SecretKey key;
    KeyGenerator keyGen ;
    Cipher cipher ;
    allCipher(String method ,int size) throws Exception{
        this.method = method ;
        this.keyGen=KeyGenerator.getInstance(method);
        this.cipher=Cipher.getInstance(method);
        keyGen.init(size);
        this.key=keyGen.generateKey();


    }
    public String encrypt (String message)throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE,this.key);
        byte[] cipherbytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(cipherbytes);

    }
    public String decrypt (String message ) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE,this.key);
        byte[] plainbytes = cipher.doFinal(Base64.getDecoder().decode(message));
        return new String(plainbytes);
    }
}
public class cipher_template {
     public static void main (String args [])throws Exception {
        String msg ="Hello";
        allCipher obj = new allCipher("AES",128 );
        String enc=obj.encrypt(msg);
        enc =obj.decrypt(enc);
        System.out.println(enc);



     }
}