package basic;

public class ArrayQuiz {


  public static void main(String[] args) {
    //1. 수학과 학생들의 기말고사 시험 점수
    int[] score = new int[] {79,88,97,54,56,95};
    int max = score[0]; //79
    int min = score[0]; //79

    //1.제어문을 사용해서 
    //max 변수에 최대값 : 97
    //min 변수에 최소값 : 54 들어가게 해서 max , min 값을 출력

    for(int i : score) {
      max = (i > max) ? i : max;
      min = (i < min) ? i : min;
    }
    System.out.printf("최대값 : %d\n", max);
    System.out.printf("최소값 : %d\n", min);
  }

}