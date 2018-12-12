package basic;

public class StarCreate {

  public void getStar(int num) {
    for(int i = 0; i < num; i++) {
      for(int j = 0; j< i+1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
