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

        long N = sc.nextLong();

        if(N % 3 == 0) {
            System.out.println("S");
        } else if(N % 3 == 1) {
            System.out.println("U");
        } else {
            System.out.println("O");
        }



    }
}