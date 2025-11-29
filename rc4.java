public class rc4 {
    byte [] S = new byte[256];
    int x =0 ;

    int y=0;

    rc4(String key ){
        init(key.getBytes());
    }
    public void init (byte[] key ){
        int keylength = key.length ;

        for (int i=0 ; i<256;i++){
            S[i]=(byte)i;

        }
        int j=0;
        for (int i=0 ; i<256 ;i++){
        //    j=(j+S[i]+key[i%keylength])&0xFF;
        //    swap(i,j);a
            j = (j + S[i] + key[i % keylength]) & 0xFF;  // FIXED
        swap(i, j);

        }

    }
    void swap (int i , int j){
        byte temp =S[i];
        S[i]=S[j];
        S[j]=temp;
    }
    public byte keyItem(){
        x=(x+1)&0xFF;
        y=(y+S[x])&0xFF;
        swap(x,y);
        return S[(S[x]+S[y])&0xFF];
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x ", b));
        }
        return sb.toString();
    }
    public byte [] encrypt (byte[] plaintext ){
        byte[] ciphertext = new byte[plaintext.length];
        for (int i=0 ; i<plaintext.length;i++){
            ciphertext[i]=(byte)(plaintext[i]^keyItem());
        }
        return ciphertext;
    }

    public static void main (String args []) throws Exception {
        rc4 obj = new rc4("Sandeep");
         String plaintext = "Hello World";
        System.out.println("Original Text: " + plaintext);

        // Encrypt RC4
        byte[] cipher = obj.encrypt(plaintext.getBytes());
        System.out.println("Encrypted (bytes): " + bytesToHex(cipher));
        obj = new rc4("Sandeep");
        // Decrypt using RC4 (same function)
        
        cipher = obj.encrypt(cipher);
        System.out.println("Decrypted Text: " + new String(cipher));

    }
}
