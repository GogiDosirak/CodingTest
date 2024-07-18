import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer =  0;
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            if(N%i == 0) {
                answer++;
            }
            if(answer == K) {
                answer = i;
                break;
            }

        }
        if(answer < K) {
            answer = 0;
        }
        System.out.println(answer);






    }
}