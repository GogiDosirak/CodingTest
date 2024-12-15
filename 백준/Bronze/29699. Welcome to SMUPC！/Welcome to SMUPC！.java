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

        String s = "WelcomeToSMUPC";
        int N = sc.nextInt();

        if(N <= 14) {
            System.out.println(s.substring(N-1,N));
        } else {
            if(N%14 == 0) {
                System.out.println(s.substring(13, 14));
            } else {
                System.out.println(s.substring(N % 14 - 1, N % 14));
            }
        }

    }
}