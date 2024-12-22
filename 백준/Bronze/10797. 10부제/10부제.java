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
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int a = sc.nextInt();
            if(a == N) {
                cnt++;
            }
            
        }
        System.out.println(cnt);

    }
}