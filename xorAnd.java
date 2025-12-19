public class xorAnd {
    public static void main (String args []){
        String text = "Hello world";

        for (int i=0 ; i<text.length();i++){
            char c = text.charAt(i);
            char andResult = (char)(c&127);
            System.out.print(andResult);
        }
        System.err.println("---");
         for (int i=0 ; i<text.length();i++){
            char c = text.charAt(i);
            char xorResult = (char)(c^127);
            System.out.print(xorResult);
        }
    }
}
