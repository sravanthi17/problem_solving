/*
Top K frequent words : https://leetcode.com/problems/top-k-frequent-words/
 */
import java.util.*;
import java.util.stream.*;

/*
 Top K frequent words - https://leetcode.com/problems/top-k-frequent-words/
 Given a non-empty list of words, return the k most frequent elements.

 Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

 Example 1:
 Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 Output: ["i", "love"]
 Explanation: "i" and "love" are the two most frequent words.
 Note that "i" comes before "love" due to a lower alphabetical order.*/
class TopKfrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap();
        for (String word : words) {
            int count = countMap.getOrDefault(word, 0) + 1;
            countMap.put(word, count);
        }
        //sort the countMap in order of frequency
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        Comparator<Map.Entry<String, Integer>> keyComparator = Map.Entry.comparingByKey();
        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue(Comparator.reverseOrder());
        countMap.entrySet().stream().sorted(comparator.thenComparing(keyComparator))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        List<String> values = reverseSortedMap.entrySet().stream().map(x -> x.getKey()).collect(Collectors.toList());
        return values.subList(0, k);
    }

    public static void main(String[] args) {
        String[] input = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(input, 2));
    }
}
