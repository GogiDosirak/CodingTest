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

        String s = sc.nextLine();
        
        int N = sc.nextInt();
        sc.nextLine();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String a = sc.nextLine();
            if(s.equals(a)) {
                cnt++;
            }
        }

        System.out.println(cnt);




        }








    
}