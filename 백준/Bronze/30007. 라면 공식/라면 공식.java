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

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(A*(M-1) + B);
            
        }




    }
}