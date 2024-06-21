import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int square = 1;
        int answer = 0;

        for (int i = 0; i < L; i++) {
            char c = s.charAt(i);
            int a = c - 96;
            answer = answer +  (a * square);
            square *= 31;
        }
        System.out.println(answer);
        
        }
    }

