package basic;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
  // main 함수에서 받을 스캐너 객체
  Scanner sc;
  
  // 난수배열 및 사용자 숫자 선택 배열
  int[] lotto;
  int[] yourChoose;
  
  // Set인터페이스로 난수Set 및 사용자 숫자 선택 Set
  Set<Integer> lottoSet;
  Set<Integer> chooseSet;
  
  // 맞은 갯수 저장 변수
  int count;
  
  // 파일 출력 객체 
  PrintWriter writer; 
  
  // 생성자에서 배열 초기화 및 스캐너 객체 주입.
  public Lotto(Scanner sc) {
    lotto = new int[6];
    yourChoose = new int[6];
    this.sc = sc;
  }

  public void randomNumberInit() {
    // 난수 (중복된 값 제외)입력
    for (int i = 0; i < lotto.length; i++) {
      int num = (int) (Math.random() * 45) + 1;
      lotto[i] = num;
      for(int j = 0; j < i; j++) {
        if(lotto[j] == lotto[i]) {
          i--;
        }
      }
    } 
    System.out.print("로또 당첨 번호는? ");
    // 난수 정렬 및 출력;
    for (int i = 0; i < 6; i++) {
      for(int j = i + 1; j < lotto.length; j++) {
        if(lotto[i] >  lotto[j]) {
          int temp = lotto[j];
          lotto[j] = lotto[i];
          lotto[i] = temp;
        }
      }
      System.out.print(lotto[i] + "\t");
    }
    System.out.println();
  }

  public void myNumber() {
    // 사용자 로또 숫자 입력 
    for (int i = 0; i < yourChoose.length; i++) {
      int num;
      outer:
      try {
        num = Integer.parseInt(sc.nextLine());
        if(num <= 0 || num > 45) {
          System.out.println("1에서 45 사이의 숫자를 입력해주세요.");
          i--;
          break outer;
        }
        for(int j = 0; j < i; j++) {
          if(yourChoose[j] == num) {
            System.out.println("같은 수를 입력하셨습니다. 다시 입력해주세요.");
            i--;
            break outer;
          }
        }
        yourChoose[i] = num;
      } catch (Exception e) {
        i--;
        System.out.println("숫자가 아닌 글자를 입력하셨네요. 다시 입력해주세요.");
      }

    }
    System.out.print("사용자 입력 한 로또 숫자");
    for (int i = 0; i < 6; i++) {
      for(int j = i + 1; j < yourChoose.length; j++) {
        if(yourChoose[i] >  yourChoose[j]) {
          int temp = yourChoose[j];
          yourChoose[j] = yourChoose[i];
          yourChoose[i] = temp;
        }
      }
      System.out.print(yourChoose[i] + "\t");
    }
    System.out.println();
  }

  public void answer() {
    count = 0;

    System.out.println("정답을 맞춥니다.");
    for (int i = 0; i < 6; i++) {
      for (int j= 0; j < 6; j++) {
        if(lotto[i] ==  yourChoose[j]) {
          count++;
        }
        try {
          writer= new PrintWriter("/Users/seung-minyeom/lotto.txt");
          writer.println("이번 로또는? ");
          int index = 1;
          for(int k : lotto) {
            writer.println(index + "번째 값 : " + k);
            index ++;
          }
          writer.println();
          writer.println("이번 당신이 선택한 숫자는? ");
          index = 1;
          for(int k : yourChoose) {
            writer.println(index + "번째 값 : " + k);
            index ++;
          }
          writer.println("\n총 맞은 갯수 : " + count + "개 입니다.");

        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          writer.close();
        }
      }
    }
  }

  public void setRandomNumberInit() {
    lottoSet = new TreeSet<>();
    while (lottoSet.size() < 6) {
      lottoSet.add((int) (Math.random() * 45) + 1);
    }
    System.out.println(lottoSet.toString());
  }

  public void setMyNumber() {
    chooseSet = new TreeSet<>();
    while (chooseSet.size() < 6) {
      int num;
      outer:
      try {
        num = Integer.parseInt(sc.nextLine());
        if(num <= 0 || num > 45) {
          System.out.println("1에서 45 사이의 숫자를 입력해주세요.");
          break outer;
        }
        if (chooseSet.contains(num)) {
          System.out.println("같은 수를 입력하셨습니다. 다시 입력해주세요.");
          break outer;
        }
        chooseSet.add(num);
      } catch (Exception e) {
        System.out.println("숫자가 아닌 글자를 입력하셨네요. 다시 입력해주세요.");
      }
     
    }
    System.out.println(chooseSet.toString());
  }
  
  public void setAnswer() {
    count=0;
    List<Integer> lottoList = new ArrayList<>(lottoSet);
    List<Integer> chooseList = new ArrayList<>(chooseSet);
    
    System.out.println("정답을 맞춥니다.");
    
    for(int i = 0; i < 6; i++) {
      for(int j = 0; j < 6; j++) {
        if(lottoList.get(i) == chooseList.get(j)) {
          count++;
        }
      }
    }

    try {
      writer= new PrintWriter("/Users/seung-minyeom/lottoSet.txt");
      writer.println("이번 로또는? ");
      int index = 1;
      for(int k : lottoSet) {
        writer.println(index + "번째 값 : " + k);
        index ++;
      }
      writer.println();
      writer.println("이번 당신이 선택한 숫자는? ");
      index = 1;
      for(int k : chooseSet) {
        writer.println(index + "번째 값 : " + k);
        index ++;
      }
      writer.println("\n총 맞은 갯수 : " + count + "개 입니다.");

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      writer.close();
    }
    
  }
}
