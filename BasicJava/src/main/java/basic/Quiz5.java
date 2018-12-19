package basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Quiz5 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("문자 입력 >> ");
    String str = sc.nextLine().toUpperCase();
    int count = 0;
    char best = ' ';
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if(!map.containsKey(str.charAt(i))) {
        map.put(str.charAt(i),1);
      } else {
        int number = map.get(str.charAt(i)) + 1;
        map.replace(str.charAt(i), number);
      }
    }
    
    for(char c : map.keySet()) {
      if(map.get(c) > count) {
        count = map.get(c);
        best = c;
      }else if(map.get(c) == count) {
        best = '?';
      }
    }
    System.out.println(best);
    sc.close();
  }
}
