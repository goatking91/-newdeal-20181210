package basic;

import java.util.Scanner;

public class Quiz9 {

  public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    System.out.println("로봇이 걸어갈 거리를 입력해주세요.>>");
    int n = Integer.parseInt(sc.nextLine());
    System.out.println("경우의 수 " + walk(n)+" 개"); 
    sc.close();
  }
  
  public static int walk(int n) {
    final int m1 = 1; 
    final int m2 = 2;
    
    return 0;
  }
}
