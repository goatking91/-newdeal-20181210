package basic;

import java.util.Scanner;

public class Program2 {
  public static void main(String[] args) {
      System.out.printf("별 갯수를 입력하세요");
      Scanner keyboard = new Scanner(System.in);
      int num = Integer.parseInt(keyboard.nextLine());
      new StarCreate().getStar(num);
      
      keyboard.close();
  }
}