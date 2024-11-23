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
        int M = sc.nextInt();
        
        if(M <= 2) {
            System.out.println("NEWBIE!");
        } else if (2 < M && M <= N){
            System.out.println("OLDBIE!");
             
        } else {
            System.out.println("TLE!");
        }



    }
}