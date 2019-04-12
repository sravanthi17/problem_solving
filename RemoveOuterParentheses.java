import java.util.*;

/*
 Remove the outermost parentheses of every
 primitive string in the primitive decomposition of S
 Example: 
 Input: "(()())(())"
 Output: "()()()"
 Explanation: 
    The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
     After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        System.out.println(findAndremoveOuterParenthesesFrom("(()())(())"));
    }

    public static String findAndremoveOuterParenthesesFrom(String inputString){
        ArrayList<Integer> openBraces = new ArrayList<>();
        char[] chars = inputString.toCharArray();
        String result = "";
        for(int i=0; i< chars.length; i++){
            if(chars[i] == '('){
                openBraces.add(i);
            }else {
                int endIndex = openBraces.size() - 1;
                if (openBraces.size() == 1) {
                    result = result + inputString.substring(openBraces.get(endIndex)+1, i);
                }
                openBraces.remove(endIndex);
            }
        }
        return result;
    }
}
