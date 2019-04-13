import java.util.HashSet;

/*Now, given a list of words, each word can be written as a concatenation of
the Morse code of each letter.
For example, "cba" can be written as "-.-..--...",
(which is the concatenation "-.-." + "-..." + ".-").
We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.


Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation:
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

*/
public class MorseRepresentation {
    public static void main(String[] args){
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int uniqueMorseRepresentations(String[] words){
        String[] morseRepresentations = new String[] {".-","-...","-.-.","-..",".",
                "..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> uniqueMorseTransformations = new HashSet<>();
        for (String word: words) {
            char[] chars = word.toCharArray();
            String transformedWord = "";
            for(char ch : chars){
                String morseRepresentation = "";
                morseRepresentation = morseRepresentations[ch - 'a'];
                transformedWord = transformedWord + morseRepresentation;
            }
            if(!transformedWord.isEmpty())
                uniqueMorseTransformations.add(transformedWord);
        }
        return uniqueMorseTransformations.size();
    }
}
