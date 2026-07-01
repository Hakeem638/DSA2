// Below is an implementation of a stack using a linked list instead of an array 

public class LinkedStack {
  private static class Node {
    int value;
    Node next;

    public Node (int value, Node next) {
      this.value = value;
      this.next = next;
    }

  }

  private Node top;

  private int size = 0;

  public int size() {
      return size;
  }

  public void push(int value) {
    top = new Node(value, top);
    size++;
  }

  public int pop() {
    if (top == null) {
      throw new IllegalStateException("The stack is empty");
    }
    int item = top.value;
    top = top.next;
    size--;
    return item;
  }

  public int peek() {
    if (top == null) {
      throw new IllegalStateException("The stack is empty");
    }
    return top.value;
  }
}