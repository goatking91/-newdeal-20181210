package basic;

import java.util.Scanner;

class Random {
  private int num;
  
  public Random() {
    resetNum();
  }
  
  public int getNum() {
    return num;
  }
  
  public void resetNum() {
    System.out.println("수를 결정했습니다. 맞춰보세요 (1~100)");
    num = (int) (Math.random() * 100) + 1;
  }
}
public class Quiz {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    int count = 0;
    
    while(true) {
      count++;
      System.out.printf("%d>> ", count);
      try {
        int num = Integer.parseInt(sc.nextLine());
        if (random.getNum() == num) {
          
          System.out.print("정답~~Restart?(Y, N) ");
          String restart = sc.nextLine();
          
          if (restart.toLowerCase().equals("n")) {
            System.out.println("종료");
            sc.close();
            break;
            
          } else if (restart.toLowerCase().equals("y")) {
            count = 0;
            random.resetNum();
          } 
          
        } else if (random.getNum() > num) {
          System.out.println("더 높게");
        } else {
          System.out.println("더 낮게");
        }
      } catch (Exception e) {
        System.out.println("숫자가 아닌 글자를 입력하셨습니다.");
        count--;
        
      }
     
    }
  }
}
