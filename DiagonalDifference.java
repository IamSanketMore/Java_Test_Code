/*

Diagonal Difference


Problem Statement :

Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix arr is shown below:

1 2 3
4 5 6
9 8 9  

The left-to-right diagonal = 1+ 5 + 9 = 15.
.The right to left diagonal =  3 +5 +9 = 17 . Their absolute difference is
|15-17| = 2 .
.

Function description

Complete the diagonal difference function in the editor below.

diagonalDifference takes the following parameter:

    int arr[n][m]: an array of integers

Return

    int: the absolute diagonal difference

Input Format

The first line contains a single integer, n, the number of rows and columns in the square matrix  arr .
Each of the next n lines describes a row, arr[i] , and consists of n space-separated integers arr[i][j]

.Constraints

-100 <= a[i][j]  <= 100

Output Format

Return the absolute difference between the sums of the matrix's two diagonals as a single integer.

*/
----------------------------------------------------------------------------------------------------------------------------------------------------------------

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
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> list) {
    // Write your code here

        List<Integer> first1 = new ArrayList<>();
        List<Integer> leftDiagonal = new ArrayList<>();
        List<Integer> rightDiagonal = new ArrayList<>();

        int plusCounter = 0;
        int minusCounter = list.size()-1;

        for(int i=0; i<list.size(); i++)
        {
            first1=list.get(i);
            for(int j=0; j<=first1.size()-1; j++)
            {
                leftDiagonal.add(first1.get(plusCounter));
                plusCounter++;
                break;
            }
        }
        
        for(int i=0; i<list.size(); i++)
        {
            first1=list.get(i);
            for(int j=0; j<=first1.size()-1; j++)
            {
                rightDiagonal.add(first1.get(minusCounter));
                minusCounter--;
                break;
            }
        }

        int result = sum(leftDiagonal) - sum(rightDiagonal);
        return Math.abs(result);
    }
    public static int sum(List<Integer> arr)
    {
        int sum =0;
        for (Integer a: arr)
        {
            sum+=a;
        }
        return sum;
    }
}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

