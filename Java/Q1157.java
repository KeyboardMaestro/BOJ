//Baekjoon Question1157
//Resource : https://www.acmicpc.net/problem/1157
import java.util.Arrays;
import java.util.Scanner;
public class Q1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inString = scanner.nextLine();
        scanner.close();
        inString = inString.toUpperCase();
        int key = 0;

        int signNum = 'A';
        int tempmax = 0;
        int[] counters = new int[26];

        for (int i = 0; i < inString.length(); i++){
            counters[inString.charAt(i)-signNum]++;
        } // count the number of existence in the string

        for (int counter : counters)
            if (counter == Arrays.stream(counters).max().getAsInt())
                key++;
        if (key > 1) System.out.println("?");
        else {
            for (int i = 0;i < counters.length; i++) {
                if (Arrays.stream(counters).max().getAsInt() == counters[i]) {
                    tempmax = i;
                    break;
                }
            }
            System.out.println((char)(signNum+tempmax));
        }
    }
}
