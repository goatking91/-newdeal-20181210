package basic;

import java.util.Scanner;

class Anagram {
  public String confirm(String first, String second) {
    
    char[] firstArray = first.toUpperCase().trim().toCharArray();
    char[] secondArray = second.toUpperCase().trim().toCharArray();
    
    if (firstArray.length == secondArray.length) {
      for(int i = 0; i < firstArray.length-1; i++) {
        for(int j = i+1; j<firstArray.length; j++) {
          if(firstArray[i] > firstArray[j]) {
            char temp  = firstArray[i] ;
            firstArray[i] = firstArray[j];
            firstArray[j] = temp;
          }
          if(secondArray[i] > secondArray[j]) {
            char temp = secondArray[i] ;
            secondArray[i] = secondArray[j];
            secondArray[j] = temp;
          }
        }
      }
      for(int i = 0; i < firstArray.length; i++) {
        if(firstArray[i] != secondArray[i]) {
          return "아니에요.";
        }
      }
      return "맞아요.";
    }
    
    return "아니에요.";
  }
}
public class Quiz2 {
  
  public static void main(String[] args) {
    Anagram anagram = new Anagram();
    
    String first;
    String second;

    Scanner input = new Scanner(System.in);

    // 문장을 받을 수도 있기에 nextLine() 활용
    System.out.print("첫번째 단어/문장 입력:");
    first = input.nextLine();

    System.out.print("두번째 단어/문장 입력:");
    second = input.nextLine();

    System.out.println("Anagram ? " + anagram.confirm(first,second));
    input.close();
  }
}
