import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            int ocnt = 0;
            int xcnt = 0;
            for (int j = 0; j < M; j++) {
                if(s.charAt(j) == 'O') {
                    ocnt++;

                } else {
                    xcnt++;
                }

            }
            if(ocnt > xcnt) {
                cnt++;
            }


        }
        System.out.println(cnt);


    }
}