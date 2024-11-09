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
        int month = sc.nextInt();
        int day = sc.nextInt();
        
        if(month == 2) {
            if(day == 18) {
                System.out.println("Special");
            } else if(day < 18) {
                System.out.println("Before");
                
            } else {
                System.out.println("After");
            }
        } else if(month < 2) {
            System.out.println("Before");
        } else {
            System.out.println("After");
        }










    }
}