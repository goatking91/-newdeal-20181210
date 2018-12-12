package basic;

public class ArrayQuiz2 {

  
  public static void main(String[] args) {
  //2. 어느 학생의 기말 성적
    int sum=0;
    float average = 0f;
    int[] jumsu = {100,55,90,60,78};
    //1. 총 과목수
    //2. 점수의 합
    //3. 점수의 평균을 구하세요  (2,3 번은 하나의 for문에서)
    for(int i : jumsu) {
      sum += i;
    }
    average = sum / jumsu.length;
    
    System.out.printf("총 과목수 : %d\n", jumsu.length);
    System.out.printf("점수의 합 : %d\n", sum);
    System.out.printf("점수의 평균 : %f", average);
    
    /*
     * 원하시는 답
     * for(int i = 0 ; i < jumsu.length ; i++) {
            sum+=jumsu[i];
            //평균 sum 누적 후에
            if(i == jumsu.length -1) {
                average = sum / (float)jumsu.length;
            }
        }
        System.out.printf("총과목수 :[%d], 총점:[%d] , 평균:[%f]"
                ,jumsu.length, sum,average);
     */
  }
}
