import java.util.*;
import java.lang.*;
import java.io.*;

public class wordLadderOne {
    public static void main(String[] args) throws IOException {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };
        
        Solution obj = new Solution();
        int ans = obj.wordLadderLength(startWord, targetWord, wordList);

        System.out.print(ans);

        System.out.println();
    }
}

class Pair {
    String first; 
    int second;
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {

        // creating a queue ds of type {word, steps}
        Queue<Pair> queue = new LinkedList<>();

        // BFS traversal with pushing valeus in queue
        // when after a transformation, a word is found in wordlist
        queue.add(new Pair(startWord, 1));

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity

        HashSet<String> myHashSet = new HashSet<String>();
        int len = wordList.length;
        for(int i = 0; i < len; i++) {
            myHashSet.add(wordList[i]);
        }

        myHashSet.remove(startWord);
        while(!queue.isEmpty()) {
            String word = queue.peek().first;
            int steps = queue.peek().second;
            queue.remove();

            // we return the steps as soon sa the first occurence 
            // of target word is found

            if(word.equals(targetWord) == true) return steps;

            // now, replace each character of 'word' with char
            // from a-z then check if 'word' exists in wordlist

            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // check if its exists in the set and push it in the queue
                    if(myHashSet.contains(replacedWord) == true) {
                        myHashSet.remove(replacedWord);
                        queue.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        // if there is no transformatino sequence possible
        return 0;
    }
}


// 3 
/* 
Time Complexity: O(N * M * 26)

Where N = size of wordList Array and M = word length of words present in the wordList..

Note that, hashing operations in an unordered set takes O(1) time, but if you want to use set here, then the time complexity would increase by a factor of log(N) as hashing operations in a set take O(log(N)) time.

Space Complexity:  O( N ) { for creating an unordered set and copying all values from wordList into it }

Where N = size of wordList Array.

*/