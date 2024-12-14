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
        int cnt = 0;
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            
            int a = Integer.parseInt(s.substring(2));
            
            if(a <= 90) {
                cnt++;
            }

         
            
            
            
        }
        System.out.println(cnt);
        




    }
}