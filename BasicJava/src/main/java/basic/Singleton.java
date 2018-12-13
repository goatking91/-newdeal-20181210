package basic;

class Computer {
  
  String name;
  SharedPrinter sharedPrinter;
  
  public Computer() {
    this("김철수");
  }
  
  public Computer(String name) {
    this.name = name;
    
  }
  
  public void connPrinter(SharedPrinter sharedPrinter) {
    this.sharedPrinter = sharedPrinter;
    System.out.println("사용자 이름: " + this.name + " 프린터 주소: " + sharedPrinter);
  }
}

class SharedPrinter {
  
  private static SharedPrinter instance;
  
  
  
  public static SharedPrinter getInstance() {
    if (instance != null) {
      return instance;
    } else {
      instance = new SharedPrinter();
      return instance;
    }
  }
}

public class Singleton {
  
  public static void main(String[] args) {
    SharedPrinter printer = SharedPrinter.getInstance();
    SharedPrinter printer2 = SharedPrinter.getInstance();
    SharedPrinter printer3 = SharedPrinter.getInstance();
    Computer c1 = new Computer();
    Computer c2 = new Computer("홍길동");
    Computer c3 = new Computer("염승민");
    
    c1.connPrinter(printer);
    c2.connPrinter(printer2);
    c3.connPrinter(printer3);
  }
}