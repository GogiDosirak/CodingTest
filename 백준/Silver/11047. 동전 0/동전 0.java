import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }
        
        int answer = 0;

        for (int i = coin.length-1; i >= 0 ; i--) {
                answer += K / coin[i];
                K = K % coin[i];

        }

        System.out.println(answer);





        }




    }
