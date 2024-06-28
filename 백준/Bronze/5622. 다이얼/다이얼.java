import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        String[] arr = {"","","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String a = String.valueOf(s.charAt(i));
            for (int j = 0; j < arr.length; j++) {
                if(arr[j].contains(a)) {
                    answer += j;
                }

            }

        }
        System.out.println(answer);


    }


}