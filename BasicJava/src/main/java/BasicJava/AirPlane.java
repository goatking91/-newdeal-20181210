package BasicJava;

public class AirPlane {
  private int airplaneNum;
  private String airplaneName;
  
  private static int count = 0;
  
  public AirPlane(int airplaneNum, String airplaneName) {
    this.airplaneNum = airplaneNum;
    this.airplaneName = airplaneName;
    count++;
  }
  
  public void plainInfo() {
    System.out.printf("비행기 번호:%d 비행기 이름:%s\n", airplaneNum, airplaneName);
  }
  
  public static void getCount() {
    System.out.printf("총 비행기 댓수는 %d대입니다.", count);
  }
}
