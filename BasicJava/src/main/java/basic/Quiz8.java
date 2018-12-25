package basic;

class Arr {

  public void select(int[] array) {
    int temp = 0;
    for (int i = 0; i < array.length; i++) {
      temp = array[i];
      System.out.println("현재 PASS");
      for(int j = i+1; j < array.length; j++) {
        System.out.printf("%d와 %d 비교\n", array[i], array[j]);
        if(temp > array[j]) {
          array[i] = array[j];
          array[j] = temp;
          temp = array[i];
        }
      }
    }
    print(array);
  }

  public void bubble(int[] array) {
    for(int i = 0; i < array.length - 1; i++) {
      System.out.println("현재 PASS");
      for(int j = 0; j < array.length - (i+1) ; j++) {
        System.out.printf("%d와 %d 비교\n", array[j], array[j+1]);
        if(array[j] > array[j+1]) {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
    print(array);
  }
  
  private void print(int[] array) {
    System.out.print("[");
    for(int i = 0; i < array.length; i++) {
      if(i==array.length-1) {
        System.out.print(array[i] + "]\n");
      }else {
        System.out.print(array[i] + ", ");
      }
    }
  }
}

public class Quiz8 {

  public static void main(String[] args) {
    int[] array1 = {3, 4, 2, 5, 1};
    int[] array2 = {3, 4, 2, 5, 1};
    Arr arr = new Arr();

    System.out.println("선택정렬입니다:");
    arr.select(array1);
    System.out.println();
    System.out.println("버블정렬입니다:");
    arr.bubble(array2);
  }


}
