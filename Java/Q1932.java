import java.util.Arrays;
import java.util.Scanner;

public class Q1932 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        int[][] triangle = new int[lines][];
        for(int i = 0; i < lines; i++){
            int[] row = new int[i+1];
            for (int j = 0; j <= i; j++){
                row[j] = scanner.nextInt();
            }
            triangle[i] = row;
        }
        System.out.println(solution(triangle));
    }
    public static int solution(int[][] triangle) {
        int step = 0;
        int[] temp = new int[(triangle.length*(triangle.length+1))/2]; // 각 케이스의 합을 저장.
        temp[0] = triangle[0][0]; // 꼭짓점은 하나
        int current = 1;
        for (int i = 1; i < triangle.length; i++){
            step += (i-1);
            for (int j = 0; j < triangle[i].length; j++){
                if (j == 0){
                    temp[current] = temp[step] + triangle[i][j]; // 좌측 정보
                    current++;
                } else if (j == triangle[i].length-1){
                    temp[current] = temp[current-triangle[i].length] + triangle[i][j];
                    current++;
                }else{
                    temp[current] = Math.max(temp[current-triangle[i].length],temp[current-triangle[i].length+1]) + triangle[i][j];
                    current++;
                }
            }
        }
        return Arrays.stream(temp).max().getAsInt();
    }
}