/*
There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings.
For example, given input strings = [‘ab’, ‘ab’, ‘abc’] and queries = [‘ab’, ‘abc’, ‘bc’], we find 2 instances of ‘ab’, 1 of ‘abc’ and of 0 of ‘bc’. For each query, we add an element to our return array, results = [2, 1, 0].
Input Format
The first line contains an integer n, the size of strings.
Each of the next n lines contains a string strings[i].
The next line contains q, the size of queries.
Each of the next q lines contains a string q[i].

---------------------------------------------------------------------------------------
Constraints
1<= n <= 1000
1 <= 1 <= 1000
1 <= |strings[i]|, |queries[i]| <=20 
---------------------------------------------------------------------------------------
Output Format
Return an integer array of the results of all queries in order.
---------------------------------------------------------------------------------------
Input
4 aba baba aba xzxb 
3 aba xzxb ab
---------------------------------------------------------------------------------------
Output
2
1
0
---------------------------------------------------------------------------------------
*/

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
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    // Write your code here

       List<Integer> output = new ArrayList<>();

        Map<Integer, List<String>> map = new HashMap<>();

        for(int i=0; i<strings.size(); i++){
            List<String> str = map.get(strings.get(i).length());
        
            if (str == null){
                str = new ArrayList<>();
            }
            str.add(strings.get(i));
            map.put(strings.get(i).length(), str);
        }

        int[] count = new int[queries.size()];

        for(int j=0; j<queries.size(); j++){
            List<String> s = map.get(queries.get(j).length());
            count[j] = s != null ?
                    Collections.frequency(s, queries.get(j)) : 0;
        }
        Arrays.stream(count).forEach(part -> output.add(part));
        return output;
    }

}

public class SparseArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.matchingStrings(strings, queries);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

