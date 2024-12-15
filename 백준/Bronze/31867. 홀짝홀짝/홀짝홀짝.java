import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new InputStreamReader(System.in));

        int N = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        int odd = 0; // 홀수
        int even = 0; // 짝수

        for (int i = 0; i < N; i++) {
                if (Integer.parseInt((s.substring(i, i + 1))) % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
        }

        if(even > odd) {
            System.out.println(0);
        } else if(even < odd) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }

    }
}