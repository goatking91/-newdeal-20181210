package basic;

import java.util.Scanner;

public class StringQuiz {

  //주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자
  //main 함수 Scanner  사용 주민번호 입력받고
  //앞:6자리 뒷:7자리
  //입력값 : 123456-1234567 
  //1. 자리수 체크 (기능)함수 (14 ok)
  //2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수
  //3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수
  //3개의 함수 static 를 만들고 1,2번을 만족하지 않으면 계속 입력을 받으세요
 
  public static boolean sizeCheck(String jumin) {
    return (jumin.length() == 14) ? true : false;
  }
  
  public static boolean validityheck(String jumin) {
    switch (jumin.charAt(7)) {
      case '1':
      case '2':
      case '3':
      case '4':
        return true;
      default:
        System.out.println("뒷번호는 1~4 입니다.");
        return false;
    }
   
  }
  
  public static void print(String jumin) {
    switch (jumin.charAt(7)) {
      case '1':
      case '3':
        System.out.println("남성입니다.");
        break;
      case '2':
      case '4':
        System.out.println("여성입니다.");
        break;
      default:
        break;
    }
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
      System.out.print("주민등록번호를 입력하세요. ");
      String jumin = scanner.nextLine();
      if (sizeCheck(jumin)) {
        if (validityheck(jumin)) {
          print(jumin);
          scanner.close();
          return;
        }
      }
    }
    
  }
}
