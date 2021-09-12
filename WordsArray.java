package homeWorkFour;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WordsArray {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "bird", "snake", "wolf", "fox", "cat", "pig", "human", "mouse"};
        System.out.println(Arrays.toString(words));

        HashSet<String> uniqWords = new HashSet<>(Arrays.asList(words));
        System.out.println(uniqWords);

        HashMap<String, Integer> count = new HashMap<>();
        for(String word : words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        System.out.println(count);
    }

}
