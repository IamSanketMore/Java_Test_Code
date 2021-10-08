import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
    
        int len = arr.size();

        float positiveCount = 0;
        float negativeCount = 0;
        float zeroCount = 0;
        for (int i = 0; i <= arr.size() -1; i++) {
            if (arr.get(i) > 0) {
                positiveCount++;
            }
            else if (arr.get(i) < 0) {
                negativeCount++;
            }
            else if (arr.get(i) == 0) {
                zeroCount++;
            }
        }
        System.out.printf("%1.6f ", positiveCount / len);
        System.out.println();
        System.out.printf("%1.6f ", negativeCount / len);
        System.out.println();
        System.out.printf("%1.6f ", zeroCount / len);
        System.out.println();
    }
}

public class FractionToDecimalCalculations {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

