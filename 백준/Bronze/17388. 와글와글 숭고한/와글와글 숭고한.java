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

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int sum = a+b+c;
        
        if(sum >= 100) {
            System.out.println("OK");
        } else {
            if(Math.min(c,Math.min(a,b)) == c) {
                System.out.println("Hanyang");
                
            } else if(Math.min(c,Math.min(a,b)) == b) {
                System.out.println("Korea");
            } else {
                System.out.println("Soongsil");
            }
        }

       




    }
}