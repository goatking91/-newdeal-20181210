package basic;

import java.util.Scanner;

class FibonacciSequence {
  
  public void calc(int number) {
    int number0 = 0;
    int number1 = 1;
    int numberNext = 0;
    if(number==0) {
      numberNext = number0;
    } else if (number == 1) {
      numberNext = number1;
    } else {
      for(int i = 0; i < number - 1; i++) {
        numberNext = number0 + number1;
        number0 = number1;
        number1 = numberNext;
      }
    }
    
   
    System.out.printf("피보나치 %d번째 수는 %d입니다.", number, numberNext);
  }
 
  
}

public class Quiz6 {
  /*
  피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
      예를들어
      F(2) = F(0) + F(1) = 0 + 1 = 1
      F(3) = F(1) + F(2) = 1 + 1 = 2
      F(4) = F(2) + F(3) = 1 + 2 = 3
      F(5) = F(3) + F(4) = 2 + 3 = 5
      와 같이 이어집니다.
      
      
      피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
  */
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = Integer.parseInt(sc.nextLine());
    FibonacciSequence sequence = new FibonacciSequence();
    
    sequence.calc(number);
    
    sc.close();


  }
}
