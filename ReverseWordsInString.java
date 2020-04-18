/*
Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

 https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        if (s.trim().isEmpty()) {
            return s.trim();
        }
        String value = s.trim().replaceAll("\\s+", " ");
        int i = 0;
        char[] chars = value.toCharArray();
        while (i < value.length()) {
            int j = i;
            while (j < value.length() && (chars[j] != ' ')) {
                j++;
            }
            reverseString(chars, j - 1, i);
            i = j + 1;
        }
        reverseString(chars, chars.length - 1, 0);
        return String.valueOf(chars);
    }

    private void reverseString(char[] chars, int k, int j) {
        while (j < k) {
            char temp;
            temp = chars[j];
            chars[j] = chars[k];
            chars[k] = temp;
            k--;
            j++;
        }
    }
}
