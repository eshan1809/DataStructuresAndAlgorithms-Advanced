/*
1. A Professor conducts a Computer Science paper for N students. He had strictly instructed all students to sit according to their roll numbers. However when he started checking the papers, he found out that all the papers were randomly ordered because the students had sat randomly during the exam instead of sitting according to their roll numbers. The order is given in list of integers roll[ ]. The professor became very angry and he wanted to teach the students a lesson.
2. He decided to sort the papers according to roll numbers by Bubble Sort and count the number of swaps required for each and every student and deduct as many marks of a student as were the number of swaps required for that student. The marks of every student is given in list of integers marks[ ] in the order in which they were sitting. However he also has to maintain the class average greater than or equal to a set minimum avg, else he may lose his job. 
3. The Professor wants to know whether he should punish the students or save his job.
*/

import java.util.*;

public class punishTheStudents {

    public static boolean shouldPunish(int[] roll, int[] marks, double avg) {
        // write your code here
        int n = roll.length;
        int[] swaps = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (roll[j] < roll[i]) {
                    swaps[roll[i] - 1]++;
                    swaps[roll[j] - 1]++;
                    int temp = roll[i];
                    roll[i] = roll[j];
                    roll[j] = temp;
                    temp = marks[i];
                    marks[i] = marks[j];
                    marks[j] = temp;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += marks[i] - swaps[i];
        return ((double) sum / n) >= avg;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] roll = new int[n];

        for (int i = 0; i < n; i++) {
            roll[i] = scn.nextInt();
        }

        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            marks[i] = scn.nextInt();
        }

        double avg = scn.nextDouble();
        scn.close();
        System.out.println(shouldPunish(roll, marks, avg));
    }
}