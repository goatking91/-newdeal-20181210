package basic;

import java.util.Scanner;

public class Test {
  private Scanner keyboard;

  public Test() {
    keyboard = new Scanner(System.in);
  }

  public void input() {
    int size;

    try {
      size = Integer.parseInt(keyboard.nextLine());
      if (size > 10 || size < 1) {
        System.out.println("해당 숫자는 1에서 10사이의 숫자가 아닙니다.");
        return;
      }
    } catch (Exception e) {
      System.out.println("해당 값은 숫자가 아닙니다.");
      return;
    }

    int[] arr = new int[size];

    for(int i = 0; i < size; i++) {
      int number;

      outer:
        try {
          number = Integer.parseInt(keyboard.nextLine());
          if (Math.abs(number) > 10) {
            i--;
            System.out.println("절대값이 10보다 작거나 같은 수가 아닙니다.");
            break outer; 
          }
          arr[i] = number;
          for(int j = 0; j < i; j++) {
            if(arr[i] == arr[j]) {
              i--;
              break;
            }
          }
        } catch (Exception e) {
          System.out.println("해당 값은 숫자가 아닙니다.");
          i--;
          break outer;
        }

    }

    for (int i = 0; i <size -1; i++) {
      for(int j = 1; j< size-i; j++) {
        if (arr[j-1] > arr[j]) {
          int temp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = temp;
        }
      }
    }

    System.out.println();
    for(int i = 0 ; i< arr.length; i++) {
      System.out.println(arr[i]);
    }

  }
}
