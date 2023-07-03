import java.util.Scanner;

public class Q1152 {
    public static void main(String[] args){
        int words = 1;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        if(str.equals(" ")){
            System.out.println(0);
            return;
        }
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                words++;
        }
        System.out.println(words);
    }
}