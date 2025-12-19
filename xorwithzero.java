public class xorwithzero {
    public static void main (String args []){
        String text = "Hello text ";
        for (int i=0 ; i<text.length();i++){
            char temp = text.charAt(i);
            char xor = (char)(temp^0);
            System.out.print(xor);
        }
    }
}

