import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.

Example:
Input: [1,2,3,3]
Output: 3
 */
public class NRepeatedElement {
    public static void main(String[] args){
        int[] elements = new int[] {1,2,5,6,2,2};
        System.out.println(nRepeatedElements(elements));
    }

    private static int nRepeatedElements(int[] elements) {
        List<Integer> existingElements = new ArrayList<>();
        for (int element : elements) {
            if(existingElements.contains(element)){
                return element;
            }else {
                existingElements.add(element);
            }
        }
        return -1;
    }

}
