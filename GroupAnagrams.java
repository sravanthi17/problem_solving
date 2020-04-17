import java.util.*;
import java.util.stream.Collectors;
/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = new String[]{"ate", "eat", "tea", "tan", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int[] count = new int[26];
        Map<String, List<String>> ans = new HashMap<>();
        Arrays.stream(strs).forEach(value -> {
            char[] chars = value.toCharArray();
            Arrays.fill(count, 0);
            for (char ch : chars) {
                count[ch - 'a'] = count[ch - 'a'] + 1; //count frequency of each character
            }
            StringBuilder sb = new StringBuilder();
            for (int c : count) {
                sb.append("#" + c + count[c]);
            }
            List<String> orDefault = ans.getOrDefault(sb.toString(), new ArrayList<>());
            orDefault.add(value);
            ans.put(sb.toString(), orDefault);
        });
        return ans.entrySet().parallelStream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
