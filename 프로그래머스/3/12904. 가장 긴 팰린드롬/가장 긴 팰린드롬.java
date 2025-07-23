class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            // 홀수
            answer = Math.max(answer, palindrome(s, i, i));
            // 짝수
            answer = Math.max(answer, palindrome(s, i, i + 1));
        }
        return answer;
    }
    
    private int palindrome(String s, int lt, int rt) {
        int n = s.length();
        int length = 0;
        
        while(lt >= 0 && rt < n) {
            if(s.charAt(lt) == s.charAt(rt)) {
                length = rt - lt + 1;
                lt--;
                rt++;
            } else {
                break;
            }
        }
        return length;
    }
}