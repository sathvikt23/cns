import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.*;
import java.util.*;
import javax.crypto.*;

public class RSA {
    Cipher cipher ;
    KeyPairGenerator keygen ;
    KeyPair keyPair ;
    PrivateKey privateKey ;
    PublicKey publicKey ;


    RSA(int size ) throws Exception {
        this.keygen= KeyPairGenerator.getInstance("RSA");
        keygen.initialize(size);
        this.keyPair=keygen.generateKeyPair();
        this.privateKey=keyPair.getPrivate();
        this.publicKey=keyPair.getPublic();
        this.cipher = Cipher.getInstance("RSA");

    }
    public String encrypt (String plaintext ) throws Exception{
        cipher.init(Cipher.ENCRYPT_MODE,this.publicKey);
        byte[] encrypted_bytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encrypted_bytes);
    }
    public String decrypt (String ciphertext ) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decrpyted_bytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String (decrpyted_bytes);

    }

    public static void main (String args [])throws Exception {
        RSA obj = new RSA (2048);

        String temp = obj.encrypt("TEST 1 ");
        System.out.println(temp);
        System.out.println(obj.decrypt(temp));

    }
}
