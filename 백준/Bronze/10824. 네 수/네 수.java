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


        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long d = sc.nextInt();

        long A = Long.parseLong(String.valueOf(a) + String.valueOf(b));
        long B = Long.parseLong(String.valueOf(c) + String.valueOf(d));

        System.out.println(A+B);
    }
}