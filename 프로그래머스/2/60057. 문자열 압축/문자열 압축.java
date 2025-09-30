class Solution {
    public int solution(String s) {
        // 연속된 문자열이라면 숫자로 축약 aaa -> 3a / a -> a (한개인 경우 1은 생략)
        // 1개 이상의 단위로 잘라서 압축 가능 abcabc -> 2abc 
        // n개의 단위로 잘라서 압축했을 때, 가장 짧은 것의 길이를 return
        // 1 <= s <= 1000 -> 완탐, n^2 충분히 가능
        // 1부터 문자열을 잘라가면서서 문자열의 길이인 n까지 압축된 길이를 비교
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length(); i++) {
            String str = "";
            for(int j = 0; j < s.length();) {
                // i 단위로 자르기
                // 같을때까지 계속 잘라야함
                // 자르고 while문 반복한 횟수 + 반복 문자열
                
                // 마지막에 자를 수 없다면 나오기
                if(j + i > s.length()) {
                    str += s.substring(j); //j부터 끝까지 자르기
                    break;
                }
                String cut = s.substring(j, j+i);
                int count = 0;
                // 자를 수 없으면 나와야함
                while(j + (count * i) + i <= s.length() && s.substring(j + (count*i), j + (count*i) + i).equals(cut)) {
                    count++;
                }
                if(count == 1) {
                    str += cut;
                } else {
                    str += count + cut;
                }
                // 다음 인덱스로 이동
                j = j + (count * i);
            }
            answer = Math.min(answer, str.length());
        }
        
        return answer;
    }
}