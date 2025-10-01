class Solution {
    public String solution(String new_id) {
        // 아이디 생성 업무
        // 규칙에 맞지 않는 아이디 입력되면 -> 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천
        // 3 <= id <= 15
        // 소문자, 숫자, -,_,. 만 사용 가능
        // .는 처음과 끝에 사용 불가능, 연속으로도 사용 불가능
        // 7단계에 거쳐 규칙에 맞는지 검사 -> 규칙에 맞지 않는다면 해당 규칙에 맞는 새로운 아이디 추천
        
        // id는 1이상 1000 이하 -> n^2 가능
        
        // 1단계 - 모든 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();
        
        // 2단계 - 적합하지 않은 모든 문자 제거
        for(char c : new_id.toCharArray()) {
            if(c != '-' && c != '_' && c != '.' && !Character.isLowerCase(c) && !Character.isDigit(c)) {
                new_id = new_id.replace(String.valueOf(c), "");
            }
        }
        
        // 3단계 - .가 2번 이상 연속이면 .로 치환
        while(new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        
        
        // 4단계 - .이 처음이나 끝에 위치하면 제거
        if(new_id.length() != 0 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1,new_id.length());
        }
        if(new_id.length() != 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // 5단계 - 빈 문자열이라면 "a" 대입
        if(new_id.length() == 0) {
            new_id = "a";
        }
        
        // 6단계 - 16자 이상이면 첫 15개 제외 나머지 다 제거, 제거 후 마침표가 .의 끝에 위치하면 .도 제거
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0,15);
        }
        while(new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // 7단계 - 2자 이하라면, 마지막 문자를 길이가 3이 될 떄까지 끝에 반복
        if(new_id.length() <= 2) {
            char addStr = new_id.charAt(new_id.length() - 1);
            while(new_id.length() < 3) {
                new_id += addStr;
            }
        }
        
        return new_id;
    }
}