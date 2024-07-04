import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N = 64;
        int X = sc.nextInt();
        String two = Integer.toBinaryString(X);
        int answer = 0;

        for (int i = 0; i < two.length(); i++) {
            char c = two.charAt(i);
            if(c == '1') {
                answer++;
            }
        }
        System.out.println(answer);

    }
}