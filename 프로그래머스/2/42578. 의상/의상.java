import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // 경우의 수 - 모든 의상의 개수를 곱해주면 됨 (안입기도 포함이므로 + 1 / 모두 안입는 경우는 제외)
        for(int n : map.values()) {
            answer *= n+1;
        }
        
        return answer-1;
    }
}