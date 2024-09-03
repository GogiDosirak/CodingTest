import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static String a, b;
    static char[] str1, str2; //문자 배열
    static int[][] dp; //dp배열
    static int answer = 0;
    public void LCS() {
        for (int i = 1; i <= str1.length; i++) { // 한칸씩 밀어서 표현, 안그러면 0번 인덱스를 전부 초기화해줘야함.
            for (int j = 1; j <= str2.length; j++) {
                if(str1[i-1] == str2[j-1]) { // 한칸씩 밀었으므로 -1
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        str1 = a.toCharArray();
        str2 = b.toCharArray();
        dp = new int[str1.length+1][str2.length+1];
        T.LCS();
        System.out.println(dp[str1.length][str2.length]); // 어차피 마지막인덱스가 최대값임

    }
}


