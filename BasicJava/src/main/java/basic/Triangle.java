package basic;

class Shape{
  String color="gold"; //공통속성
  void draw() {
    System.out.println("그리다"); //공통기능
  }
}
class Point{
  int x;
  int y;

  Point(){
    //this.x = 1;
    //this.y = 2;
    this(1,2);
  }
  Point(int x , int y){
    this.x = x;
    this.y = y;
  }
}

// --------------------------------------------------------------------------------------
//위 코드를 활용해서 

//문제
//삼각형 클래스를 만드세요
//정의 : 삼각형은 3개의 점과 색과 그리고 그리다 라는 기능을 가지고 있다

//Shape , Point 클래스 제공
//삼각형은 도형이다
//삼각형은 3개의 점을 가지고 있다
//hint) 점 3개 : (x,y) (x,y) (x,y)
//주의) default 그릴수  있고  , 3개의 좌표값을 받아서 그릴 수 있다

public class Triangle extends Shape {
  private Point[] points = new Point[3];
  private int count;
  Triangle() {
    this(1,2);
  }

  Triangle(int x, int y) {
    points[count] = new Point(x,y);
    count++;
  }

  Triangle(Point[] points) {
    this.points = points;
  }

  void draw(Point[] points) {
    this.points = points;
    for(Point point : this.points) {
      System.out.printf("(%d, %d) \t", point.x, point.y);
    }
    super.draw();
  }

}
/*
 * 
 * class Triangle extends Shape{
    Point x;
    Point y;
    Point z;
    public Triangle() {
        //x = new Point(10, 20);
        //y = new Point(20, 30);
        //z = new Point(40, 50);
        this(new Point(10, 20), new Point(20, 30), new Point(40, 50));
    }
    public Triangle(Point x , Point y , Point z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void triangePoint() {
        System.out.printf("x :(%d,%d)",x.x,x.y);
        System.out.printf(" y :(%d,%d)",y.x,y.y);
        System.out.printf(" z :(%d,%d)",z.x,z.y);
    }
}

// 왠만하면 중복이 생기면 배열을 사용!

class Triangle extends Shape{
    private Point[] pointarray; 
    public Triangle() {

        this(new Point[]{new Point(1,2),new Point(3,4),new Point(5,6)});
    }
    public Triangle(Point[] pointarray) {
        this.pointarray = pointarray;
    }
    public void triangePoint() {
        for(Point point : pointarray) {
            System.out.println("좌표: " + point.x + "," + point.y);
        }
    }
}
 *
 * //Triangle triangle = new Triangle();
//triangle.triangePoint();

Point[] newpoint = {new Point(1,2),new Point(3,4),new Point(5,6)};
Triangle triangle = new Triangle(newpoint);
triangle.triangePoint();

 * 
 */

