class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String[] array = new String[my_string.length()];
		String remember = "";
		
		for (int i = 0; i < array.length; i++) {
			array[i] = my_string.substring(i,i+1);
		}
		
		remember = array[num1];
		array[num1] = array[num2];
		array[num2] = remember;
		
		for (int i = 0; i < array.length; i++) {
			answer = answer + array[i];
		}
		
        return answer;
    }
}