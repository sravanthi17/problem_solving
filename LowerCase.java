
/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class LowerCase {

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
    }

    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i=0; i< chars.length; i++){
            int ascii = (int)chars[i];
            if(ascii >= 65 && ascii <= 90){
                chars[i] = (char) (ascii + 32);
            }
        }
        return String.valueOf(chars);
    }
}
