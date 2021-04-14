import java.util.*;
class Solution {
    public boolean isValid(String str) {
        
        //열린괄호이면 닫힌괄호를 스택에 추가
        //스택이 비어있으면 열린괄호로 열지 않고 닫힌괄호가 바로등장한 경우이므로 유효하지 않음
        //현재 포인터의 괄호와 스택의 최상단 괄호가 다르면 정상적으로 닫히지 않는 경우이므로 유효하지 않음
        //문자열을 끝까지 돌았는데 스택이 비어있지 않으면 유효하지 않은 괄호가 포함되어 있는 경우이므로 유효하지 않음
        //(이면 )으로 닫혀야 유효한 괄호
        //[이면 ]으로 닫혀야 유효한 괄호
        //{이면 }으로 닫혀야 유효한 괄호
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') s.push(')');
            else if(c == '{') s.push('}');
            else if(c == '[') s.push(']');
            else if(s.isEmpty()) return false;
            else if( s.pop() != c) return false;
        }
            
        return s.isEmpty();
    }
}

