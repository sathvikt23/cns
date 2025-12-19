public class ceaser {
    public static String encrypt (String message , int shift ){
        StringBuilder result = new StringBuilder();
          for (int i =0 ; i<message.length();i++){

            char c = message.charAt(i);
           
            if (Character.isUpperCase(c)){
                  char ch = (char)(((int)c+shift-65)%26+65);
                  result.append(ch);
            }
            if(Character.isLowerCase(c)){
                char ch =(char)(((int)c+shift-97)%26+97);
                result.append(ch);
            }

          }
          return result.toString() ;
    }
    public static String decrypt (String message , int shift  ){
        return encrypt(message, 26-shift);
    }
    public static void main (String args []){
        String text = "Hello";
        System.out.println(decrypt(encrypt(text, 1), 1));
    }
}
