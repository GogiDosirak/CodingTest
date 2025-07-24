import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        
        Arrays.fill(arr, 1);
        
        for(int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1] = 0;
        }
        
        for(int i = 0; i < reserve.length; i++) {
            if(arr[reserve[i] - 1] == 0) {
                arr[reserve[i] - 1] = 1;
                continue;
            }
            arr[reserve[i] - 1] = 2;
        }
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                if(i == 0) {
                    if(arr[i+1] == 2) {
                        arr[i+1]--;
                        arr[i]++;
                    }
                } else if(i == n-1) {
                        if(arr[i-1] == 2) {
                            arr[i-1]--;
                            arr[i]++;
                        }
                } else {
                    if(arr[i-1] == 2) {
                        arr[i-1]--;
                        arr[i]++;
                    } else if(arr[i+1] == 2) {
                        arr[i+1]--;
                        arr[i]++;
                    }
                } 
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(arr[i] >= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}