package basic;

// Stack 자료 구조를 설명하고 아래 코드를 완성 하세요

public class MyStack<T> {


  private T[] stackArr;
  
  private int pointer;

  public MyStack() {
    this(3);
  }

  @SuppressWarnings("unchecked")
  public MyStack(int stackSize) {
    this.stackArr = (T []) new Object[stackSize];
    this.pointer = 0;
  }
  public boolean empty() { // 스택이 비었는지 확인
    return (pointer==0) ? true : false;
  }

  public boolean full() { //스택이 풀인지 확인
    return (pointer==stackArr.length) ? true : false;
  }

  public void push(T i) {
    if(full()) {
      System.out.println("스택이 꽉찼습니다.");
      return;
    } else {
      stackArr[pointer++] = i;
      System.out.println("스택에 Push했습니다.");
    }
  }

  public T pop() {
    if(empty()) {
      System.out.println("스택이 비어져있습니다.");
      return null;
    } else {
      T i = stackArr[--pointer];
      System.out.println("스택에 Push했습니다.");
      return i;
    }
  }

  
  public static void main(String[] args) {
    MyStack<Integer> myStack = new MyStack<>();
    System.out.println(myStack.empty());
    System.out.println(myStack.full());
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    myStack.push(1);
    System.out.println(myStack.empty());
    System.out.println(myStack.full());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.empty());
    System.out.println(myStack.full());
    
  }
}