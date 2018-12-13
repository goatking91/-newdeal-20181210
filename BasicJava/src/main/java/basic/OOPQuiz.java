package basic;

/*
시나리오 (요규사항)
저희는 가전제품 매장 솔루션 개발 사업팀 입니다
A라는 가전제품 매장이 오픈 되면 ....

[ 클라이언트 요구사항 ]
가전제품은 제품의 가격 , 제품의 포인트 정보를 공통적으로 가지고 있다
각각의 가전제품은 제품별 이름을 가지고 있다 

각각의 전자제품은 이름을 가지고 있다 (ex : Tv , Audio , Computer)
각각의 전자제품은 다른 가격을 가지고 있다(ex : Tv:5000 , Audio:6000)
제품의 포인트는 가격의 10%를 가진다

 */
class Product{
  int price;
  int bonuspoint;

  public Product() {

  }
  Product(int price) {
    this.price = price;
    this.bonuspoint = (int)(this.price/10.0);
  }
}




class KtTv extends Product{
  KtTv(){
    super(500);
  }
  @Override
  public String toString() {
    return "KtTv";
  }
}

class Audio extends Product{
  Audio(){
    super(100);
  }
  @Override
  public String toString() {
    return "Audio";
  }
}
class NoteBook extends Product{
  NoteBook(){
    super(150);
  }
  @Override
  public String toString() {
    return "NoteBook";
  }
}
/*
시뮬레이션 시나리오
구매자 : 제품을 구매하기 위한 금액정보 , 포인트 정보를 가지고 있다
구매자는 제품을 구매할 수 있다 , 구매행위를 하게 되면 가지고 있는 금액은
감소하고 포인트는 올라간다
구매자는 처음 초기 금액을 가진다
 */
//구매행위 
//구매행위 (잔액금액 - 제품의 가격 , 포인트 갱신)
//구매자는 매장이 있는 모든 제품을 구매할 수 있다
//구현 함수
//매장에 있는 (Kttv , audio , notebook) 구매 하세요
//kttvbuy(){} , audiotbuy(){} , notebookbuy(){}
/*
문제) 위 시나리오 기반으로 구매자 클래스를 구현하세요
 */

//다형성 : 하나의 [참조 변수]가  [여러개의 타입]을 가질 수 있다
class Buyer {
  
  int cash;
  int bonuspoint;
  Product[] cart;
  int count;
  
  public Buyer() {
    this(1000);
    
  }
  
  Buyer(int cash) {
    this.cash = cash;
    this.bonuspoint = 0;
    cart = new Product[10];
  }
 
  public void buy(Product product) {
    if(cart.length >= 10) {
      System.out.println("고객님 충동구매 하지 마세요 ㅠㅠ");
    }
    cart[count] = product;
    count++;
  }
  
  public void summary() {
    int i = 0;
    int totalCash = 0;
    while(true) {
      if (cart[i] == null) {
        break;
      }
      System.out.println("물품: " + cart[i].toString() + ", 가격: " + cart[i].price);
      totalCash += cart[i].price;
      i++;
    }
    System.out.println("총 누적 금액: " + totalCash);
    Product totalProduct = new Product(totalCash);
    this.cash -= totalProduct.price;
    this.bonuspoint += totalProduct.bonuspoint;
    System.out.printf("현재 잔액: %d \t보너스 포인트: %d\n", this.cash, this.bonuspoint);
  }

}
/*
OOP 확인문제 2 에 추가사항 입니다
요구사항
카트 (Cart)
카트에는 매장에 있는 모든 전자제품을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... 카트에 담는다

계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy())
hint) summary()  main 함수에서 계산할때

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다

*/




public class OOPQuiz {

  public static void main(String[] args) {
    KtTv kttv = new KtTv();
    Audio audio = new Audio();
    NoteBook notebook = new NoteBook();

    Buyer buyer = new Buyer();
    
    
    // 아래처럼 가능
    buyer.buy(kttv);
    buyer.buy(audio);
    buyer.buy(notebook);
    
    buyer.summary();
  }
}
