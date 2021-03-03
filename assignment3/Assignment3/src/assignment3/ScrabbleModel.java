/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-03-01
 * Purpose: MVC architecture (Model used to handles all logic & back-end processing)
 */
package assignment3;

import java.util.*;

public class ScrabbleModel {
    //Constant variables (Hard code)
    private final char[] VOWELS_ARR = {'A', 'E', 'I', 'O', 'U', 'Y'};
    private final char[] ALPHABET_ARR = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final int[] POINT_ARR = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private final int[] INBAG_ARR = {9, 2, 2, 4, 12, 2, 3, 2, 8, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 2, 4, 2, 1, 2, 1};
    //Test in bag example: jaw with others (Test game over condition)
    //private final int[] INBAG_ARR = {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};


    //Instant variables
    private HashMap<Character, Alphabet> alphabetHashMap;
    private List<String> words;
    private int totalPoints;

    //Constructor: initial all variables
    public ScrabbleModel() {
        totalPoints = 0;
        words = new ArrayList<String>();
        alphabetHashMap = new HashMap<Character, Alphabet>();

        //Create 26 alphabet objs
        for (int i = 0; i < ALPHABET_ARR.length; i++) {
            alphabetHashMap.put(ALPHABET_ARR[i], new Alphabet(ALPHABET_ARR[i], POINT_ARR[i], INBAG_ARR[i]));
        }
    }

    /**
     * Judge the word is exists in the previous word list.
     * @param word
     * @return
     */
    private boolean existWord(String word) {
        if (words.contains(word))
            return true;
        return false;
    }

    /**
     * Get number of occurrence for each alphabet.
     * @param word
     * @return
     */
    private HashMap<Character, Integer> getAlphabetOccurrences(String word) {
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();

        //statistic appear the number of alphabets
        for (char c : word.toCharArray()) {
            if (result.get(c) == null) {
                result.put(c, 1);
            } else {
                result.replace(c, result.get(c)+1);
            }
        }

        return result;
    }

    /**
     * Get point for a character
     * @param c
     * @return
     */
    private int getPoint(char c) {
        int result = 0;

        //the number of the alphabet is 1
        Alphabet alphabet = alphabetHashMap.get(c);
        alphabet.setInBag(alphabet.getInBag() - 1);
        result = alphabet.getPoint() * 1;
        alphabetHashMap.replace(c, alphabet);

        totalPoints += result;
        return result;
    }

    /**
     * Get point for a word (use HashMap(k-v) to get the point)
     * @param map
     * @return
     */
    private int getPoint(HashMap<Character, Integer> map) {
        int result = 0;

        //the number of the alphabet depends on the map value
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Alphabet alphabet = alphabetHashMap.get(entry.getKey());
            alphabet.setInBag(alphabet.getInBag() - entry.getValue());
            result += alphabet.getPoint() * entry.getValue();

            alphabetHashMap.replace(entry.getKey(), alphabet);
        }

        totalPoints += result;
        return result;
    }

    /**
     * Judge the word is valid or invalid.
     * Return point that greater than 0; invalid: point that less than 0.
     * @param word
     * @return
     */
    public int isWordValid(String word){
        String upperWord = word.toUpperCase();

        if (!existWord(upperWord)) { //not exist in previous word
            if (word.length() == 1) { //word length equal 1
                for (char vowel : VOWELS_ARR) { // word is vowel (a-e-i-o-u-y)
                    if (vowel == upperWord.charAt(0) && alphabetHashMap.get(vowel).getInBag() > 0) {
                        words.add(upperWord);
                        return getPoint(vowel);
                    }
                }
            } else if (word.length() >= 2 && word.length() <= 8) { //word length between 2-8
                HashMap<Character, Integer> alphaMap = getAlphabetOccurrences(upperWord);
                boolean hasVowel = false;

                // word must include vowel (a-e-i-o-u-y)
                for (char vowel : VOWELS_ARR) {
                    if (alphaMap.get(vowel) != null) {
                        hasVowel = true;
                        break;
                    }
                }

                //judge all of the numbers of in bag are enough
                for (Map.Entry<Character, Integer> entry : alphaMap.entrySet()) {
                    if(entry.getValue() > alphabetHashMap.get(entry.getKey()).getInBag())
                        return -1;
                }

                //if the word includes the vowel
                if(hasVowel) {
                    words.add(upperWord);
                    return getPoint(alphaMap);
                }
            }
        }

        return -1;
    }

    /**
     * Get the remaining number of alphabet
     * @return
     */
    public int getTotalNumberInBag() {
        int result = 0;
        for (char alphabet : ALPHABET_ARR) { // all alphabets
            result += alphabetHashMap.get(alphabet).getInBag();
        }
        return result;
    }

    /**
     * Get the remaining number of vowels
     * @return
     */
    public int getTotalNumberVowel() {
        int result = 0;
        for (char vowel : VOWELS_ARR) { // vowel (a-e-i-o-u-y)
            result += alphabetHashMap.get(vowel).getInBag();
        }
        return result;
    }

    //Getters
    public int getTotalPoints() {
        return this.totalPoints;
    }
    public String getPreviousWords() {
        return String.join(", ", words);
    }
    public HashMap<Character, Alphabet> getAlphabetHashMap() {
        return this.alphabetHashMap;
    }
}
