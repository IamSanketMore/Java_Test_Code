/*
Problem Statement :

A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is a pangram in the English alphabet. Ignore case. Return either pangram or not pangram as appropriate.

Example

s =  "The quick brown fox jumps over a lazy dog"

The string contains all letters in the English alphabet, so return pangram.

Function Description

Complete the function pangrams in the editor below. It should return the string pangram if the input string is a pangram. Otherwise, it should return not pangram.

pangrams has the following parameter(s):

string s: a string to test


Returns

string: either pangram or not pangram
Input Format

A single line with string .

Constraints

0   <=  length of s  <=  10^3


Sample Input

Sample Input 0

We promptly judged antique ivory buckles for the next prize


Sample Output 0

pangram

*/
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here
     boolean[] isInside = new boolean[26];
        for (char c : s.toCharArray()) 
        {
            if (Character.isLetter(c)) 
            {
                isInside[Character.toLowerCase(c)-'a'] = true;
            }
        }
        for (boolean b : isInside) 
        {
            if (!b) 
            return "not pangram";
        }
        return "pangram";

    }

}

public class Pangrams{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

