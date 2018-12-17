package basic;

import java.util.Scanner;

public class StairsQuiz {
  /*
  가위바위보 계단오르기 게임

  1. 계단 개수를 지정한다

  2. 컴퓨터와 가위바위보를 해서 이긴 사람이 계단을 올라간다(입력값 : 가위/바위/보)
      가위로 이기면 : 2칸
      바위로 이기면 : 3칸
      보로 이기면 :5칸

  3. 이기면 '이겼습니다' 출력
     지면 '졌습니다' 출력

  4. 게임이 끝나면 
      '다시 하시겠습니까?'를 출력
    y -> 1번부터 다시 시작
    n -> 게임 끝
   */

  static int count;
  static Scanner sc;
  public static void main(String[] args) {
    sc = new Scanner(System.in);


    while(true) {
      System.out.print("계단수를 입력해주세요. ");
      count = Integer.parseInt(sc.nextLine());
      wins();

      System.out.print("\n 다시하시겠습니까?(y or N)");
      String yesOrNo = sc.nextLine().toLowerCase();
      if(yesOrNo.equals("n")) break;
    }

    sc.close();
  }

  public static void wins() {
    int computerCount = 0;
    int personCount = 0;

    while(true) {
      if(Math.max(computerCount, personCount) >= count) break;
      int computer = (int) (Math.random() * 3 + 1);
      System.out.println("가위바위보를 선택하세요.");
      System.out.print("1. 가위, 2.바위, 3.보 ");
      int person = Integer.parseInt(sc.nextLine());
      
     
      if (computer == 1) {
        if (person == 1) {
          System.out.println("비겼습니다.");
        } else if(person == 2) {
          System.out.println("유저가 이겼습니다.");
          personCount += 3;
        } else if(person == 3) {
          System.out.println("컴퓨터가 이겼습니다.");
          computerCount += 2;
        }
      } else if (computer == 2) {
        if (person == 1) {
          System.out.println("컴퓨터가 이겼습니다.");
          computerCount += 3;
        } else if(person == 2) {
          System.out.println("비겼습니다.");
        } else if(person == 3) {
          System.out.println("유저가 이겼습니다.");
          personCount += 5;
        }
      } else if (computer == 3) {
        if (person == 1) {
          System.out.println("유저가 이겼습니다.");
          personCount += 2;
        } else if(person == 2) {
          System.out.println("컴퓨터가 이겼습니다.");
          computerCount += 5;
        } else if(person == 3) {
          System.out.println("비겼습니다.");
        }
      }
      
    }
    
    if(computerCount > personCount) {
      System.out.println("컴퓨터가 최종 승리.");
    } else if(computerCount < personCount) {
      System.out.println("유저가 최종 승리.");
    } else {
      System.out.println("비겼습니다.");
    }
    
  }
}
