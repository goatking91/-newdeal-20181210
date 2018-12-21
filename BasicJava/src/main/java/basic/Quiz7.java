package basic;

import java.util.Scanner;

class Gcd {
  public int calc(int x, int y) {
    int tempx = x;
    int tempy = y;
    
    if (x < y) {
      x = tempy;
      y = tempx;
    }
    int r = 1;
    while (r>0) {
      r = x % y;
      x = y;
      y = r;
    }
    // 최소 공배수
    // int lcm = tempx * tempy / x;
    return x;
  }
}

public class Quiz7 {
  public static void main(String[] args) {
    // 입력한 두 정수의 최대공약수를 구하세요.
    Gcd gcd = new Gcd();
    Scanner sc = new Scanner(System.in);
 
    System.out.print("첫번째 정수를 입력하세요 : ");
    int x = sc.nextInt();
    System.out.print("두번째 정수를 입력하세요 : ");
    int y = sc.nextInt();
 
    System.out.println("최대공약수는 " + gcd.calc(x, y) + "입니다.");
    sc.close();
    /*
     * Console 예시 
     * 첫번째 정수를 입력하세요 : 48 
     * 두번째 정수를 입력하세요 : 36 
     * 최대공약수는 12입니다.
     */
  }
}
