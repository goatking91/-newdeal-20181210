package basic;

public class Quiz3 {
  
  private static int solution(int number) {
    int sequence = 0;
    
    if (Integer.bitCount(number) <= 1) {
      return sequence;
    } else {
      char[] str = Integer.toBinaryString(number).toCharArray();
      int[] count = new int[str.length];
      int size = 0;
      for(int i = 0; i< str.length; i++) {
        if(str[i] == '1')
          count[size++] = i;
      }
      
      for(int i = 0; i < size - 1; i++) {
        if((count[i+1] - count[i] -1) > sequence) {
          sequence = count[i+1] - count[i] -1;
        }
      }
    }
    
   
    return sequence;
  }
  
  public static void main(String[] args) {
    System.out.println("해당숫자의 이진 간격은 " + solution(529));
  }
}
