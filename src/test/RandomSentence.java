package test;

import java.util.Random;

public class RandomSentence {
    public static void main(String args[]){
        String[] word = {"I", "We", "They"};
        String[] word1 = {"like", "hate", "think"};
        String[] word2 = {"Coffee", "Cake", "Burger"};


        int oneLength = word.length;
        int twoLength = word1.length;
        int threeLength = word2.length;

        Random randomGenerator = new Random();


        int rand1 = randomGenerator.nextInt(oneLength);
        int rand2 = randomGenerator.nextInt(twoLength);
        int rand3 = randomGenerator.nextInt(threeLength);
 
        String sentence = word[rand1]+ " "+ word1[rand2] + " "+word2[rand3];
        
        System.out.println(sentence);

    }
}
