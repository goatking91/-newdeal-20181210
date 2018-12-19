package basic;

import java.util.Scanner;

class StringCompress {
  
  public void compress(String str) {
    String result = "";
    int count = 1;
    result += str.charAt(0); 
    for (int i = 1; i < str.length(); i++) {
      if(result.charAt(result.length()-1) != str.charAt(i)) {
        result += count;
        result += str.charAt(i);
        count = 1;
      } else {
        count++;
      }
    }
    result += count;
    
    System.out.println(result);
  }
}

public class Quiz4 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("문자 입력 >> ");
    String str = sc.nextLine();
    StringCompress compress = new StringCompress();
    compress.compress(str);
    sc.close();
  }
}
