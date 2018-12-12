package basic;

public class Productor {

  public static void main(String[] args) {
    AirPlane airPlane1 = new AirPlane(1111, "보이");
    AirPlane airPlane2 = new AirPlane(2222, "보이");
    AirPlane airPlane3 = new AirPlane(3333, "보이");
    AirPlane airPlane4 = new AirPlane(4444, "보이");
    
    airPlane1.plainInfo();
    airPlane2.plainInfo();
    airPlane3.plainInfo();
    airPlane4.plainInfo();
    
    AirPlane.getCount();
  }

}
