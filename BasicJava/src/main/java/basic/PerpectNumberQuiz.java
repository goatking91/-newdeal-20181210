package basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class PerpectNumber {
  
  Set<Integer> set;
  
  public void number(int num) {
    for(int i = 2; i <= num; i++) {
      set = new HashSet<>();
      for(int j = 1; j < i; j++) {
        if(i % j == 0) {
          set.add(j);
        }
      }
      Iterator<Integer> iterator = set.iterator();
      int total = 0;
      while(iterator.hasNext()) {
        total += iterator.next();
      }
      if(total == i) {
        System.out.println(i);
      }
    }
   
  }
  
}

public class PerpectNumberQuiz {

  public static void main(String[] args) {
    PerpectNumber p = new PerpectNumber();
    
    Scanner sc = new Scanner(System.in);
    System.out.print("자연수를 입력하세요. ");
    int num = Integer.parseInt(sc.nextLine());
    p.number(num);
    sc.close();
  }
}
