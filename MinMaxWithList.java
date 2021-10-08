import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    
        int max =0;
        int min = 0;
        
        Collections.sort(arr);
        for (int i = 1; i <arr.size() ; i++) {
            max = max + arr.get(i);
        }
        for(int j= 0; j <arr.size() -1 ; j++)
        {
            min = min + arr.get(j);
        }

        System.out.print(min+" ");
        System.out.print(max);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    
        int max =0;
        int min = 0;
        
        Collections.sort(arr);
        for (int i = 1; i <arr.size() ; i++) {
            max = max + arr.get(i);
        }
        for(int j= 0; j <arr.size() -1 ; j++)
        {
            min = min + arr.get(j);
        }

        System.out.print(min+" ");
        System.out.print(max);
    }
}

public class MinMaxWithList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

//----------------------------  Output  ---------------------------------------//
/*
Inside Max ---[Index-1, Value-7, Max-7]
Inside Max ---[Index-2, Value-69, Max-76]
Inside Max ---[Index-3, Value-221, Max-297]
Inside Max ---[Index-4, Value-8974, Max-9271]

Inside min ---[Index-0, Value-2, Min-2]
Inside min ---[Index-1, Value-7, Min-9]
Inside min ---[Index-2, Value-69, Min-78]
Inside min ---[Index-3, Value-221, Min-299]
299 9271

*/
//-----------------------------------=---------------------------------------//
