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

        String s = sc.nextLine();
        
        switch(s) {
            case "M" :
                System.out.println("MatKor");
                break;
            case "W" :
                System.out.println("WiCys");
                break;
            case "C":
                System.out.println("CyKor");
                break;
            case "A" :
                System.out.println("AlKor");
                break;
            case "$" :
                System.out.println("$clear");
        } 
    
    }
}