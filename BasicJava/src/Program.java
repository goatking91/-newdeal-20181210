import java.util.Scanner;

public class Program {
  static Scanner sc;
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    Lotto lotto = new Lotto(sc);
    
    // lotto.number(); 번호 추출
    // lotto.writenuber(); 파일 쓰기 ..
    
     
     
     
    while (true) {
      System.out.println("\n원하시는 작업을 선택하세요. \n");
      System.out.print("1. 로또 번호 난수 발생");
      System.out.print("\t\t2. 사용자 로또 번호 입력");
      System.out.print("\t\t3. 결과 출력\n");
      System.out.print("4. 로또 번호 난수 발생(treeset)");
      System.out.print("\t5. 사용자 로또 번호 입력(treeset)");
      System.out.print("\t6. 결과 출력(treeset)\n");
      System.out.print("q or Q. 프로그램 종료! ");
      
      String choose = sc.nextLine();
      if (choose.equals("1")) {
        lotto.randomNumberInit();
      } else if(choose.equals("2")) {
        lotto.myNumber();
      } else if(choose.equals("3")) {
        lotto.answer();
      } else if(choose.equals("4")) {
        lotto.setRandomNumberInit();
      } else if(choose.equals("5")) {
        lotto.setMyNumber();
      } else if(choose.equals("6")) {
        lotto.setAnswer();
      } else if(choose.toLowerCase().equals("q")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      } else {
        System.out.println("해당하는 작업은 존재하지 않습니다. 다시 입력해주세요.");
      }
    }
  }
}
