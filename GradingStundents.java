/*
									Grading Students

Problem Statement :

HackerLand University has the following grading policy:

   1. Every student receives a grade in the inclusive range from 1 to 100.
   2. Any grade less than 30 is a failing grade. 

     

Sam is a professor at the university and likes to round each student's grade according to these rules:

  1.If the difference between the grade and the next multiple of 5 is less than 3 , round up to the next multiple of 5.
  2.If the value of grade  is less than 38 , no rounding occurs as the result will still be a failing grade.

Examples

  1. grade = 84 round to85 (85 - 84 is less than 3)
  2. grade = 29 do not round (result is less than 40)
  3. grade = do not round (60 - 57 is 3 or higher)

Given the initial value of  grade for each of Sam's n students, write code to automate the rounding 
process. 

Function Description

Complete the function gradingStudents in the editor below.

gradingStudents has the following parameter(s):

    int grades[n]: the grades before rounding

Returns

    int[n]: the grades after rounding as appropriate

Input Format

The first line contains a single integer,n , the number of students.
Each line i of the n subsequent lines contains a single integer, grades[i].

Constraints
  
  1<= n < =60
  0 <= grades[i] <= 100

--------------------------------------------------------------------------------------------------------------------------------
									Solution
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
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
        
        List<Integer> finalGrades = new ArrayList<>();
        int sum=0;
        for(int i=0; i<grades.size();i++)
        {
            if(grades.get(i)>=38)
            {
                if((grades.get(i)%5)>=3)
                {
                    sum=(grades.get(i)+5-(grades.get(i)%5));
                    finalGrades.add(sum);
                }
                 else
                {
                    finalGrades.add(grades.get(i));
                }
            }
            else
            {
                finalGrades.add(grades.get(i));
            }
        }
        return finalGrades;
    }

}

public class GradingStundents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


