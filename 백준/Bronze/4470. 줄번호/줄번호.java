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


        for (int i = 1; i <= N; i++) {
            StringBuilder a = new StringBuilder();
            String b = sc.nextLine();
            a.append(i).append(".").append(" ").append(b);
            System.out.println(a);

        }

    }


}