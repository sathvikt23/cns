import java.util.*;
import javax.crypto.*;

public class template1 {
    String method ;
    SecretKey key ;
    Cipher cipher ;
    KeyGenerator keygen;
    public template1(String method , int size ) throws Exception{
        this.method=method ;
        this.keygen=KeyGenerator.getInstance(method);
        this.cipher=Cipher.getInstance(method);
        this.keygen.init(size);
        this.key=keygen.generateKey();
        
    }

    public String encrypt(String plaintext) throws Exception{
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encrypted_bits = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encrypted_bits);
    }
    public String decrpyt(String ciphertext) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrpyted_bits = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String (decrpyted_bits);
    }

    public static void main (String args []) throws Exception{
        template1 example = new template1("AES", 128);
        String text = "Hello, World!";
        String en =example.encrypt(text);
        System.out.println(en);
        System.out.println(example.decrpyt(en));
    }


}