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

        long N = sc.nextLong();

        if(N < 100000 && N% 2024 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }



    }
}