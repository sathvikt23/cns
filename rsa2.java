
import java.util.*;
import java.security.*;
import javax.crypto.*;
import java.security.spec.*;
public class rsa2 {
    PrivateKey privKey ;
    PublicKey pubKey ;
    KeyPair keypair  ;
    KeyPairGenerator keypairgen ;
    Cipher cipher ;
    rsa2(int size ) throws  Exception {
        this.keypairgen=KeyPairGenerator.getInstance("RSA");
        this.keypair=keypairgen.generateKeyPair();
        this.pubKey=this.keypair.getPublic();
        this.privKey=this.keypair.getPrivate();
        this.cipher = cipher.getInstance("RSA");

    }
    public String encrypt (String message )throws Exception{
        cipher.init(Cipher.ENCRYPT_MODE,this.pubKey);
        byte [] cipherbytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(cipherbytes );
    }
    public String decrypt (String message )throws Exception {
         cipher.init(Cipher.DECRYPT_MODE,this.privKey);
         byte [] plaintext = cipher.doFinal(Base64.getDecoder().decode(message));
         return new String (plaintext);
    }
    public void printkeys ()throws Exception {
       KeyFactory keyFactory= KeyFactory.getInstance("RSA");
       RSAPublicKeySpec key1 = keyFactory.getKeySpec(this.pubKey,RSAPublicKeySpec.class);
       RSAPrivateKeySpec key2= keyFactory.getKeySpec(this.privKey,RSAPrivateKeySpec.class);
       System.out.println(key1.getModulus()+"\n---------\n"+key2.getModulus());
        System.out.println(key1.getPublicExponent()+"\n---------\n"+key2.getPrivateExponent());

    }
   public static void main (String args [])throws Exception {
    rsa2 obj = new rsa2(512);
    String en = obj.encrypt("Hello");
    en =obj.decrypt(en);
    obj.printkeys();
   }

}
