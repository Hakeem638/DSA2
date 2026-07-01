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

  public void push(int value) {
    top = new Node(value, top);
  }

  public int pop() {
    if (top == null) {
      throw new IllegalStateException("The stack is empty");
    }
    int item = top.value;
    top = top.next;
    return item;
  }

  public int peek() {
    if (top == null) {
      throw new IllegalStateException("The stack is empty");
    }
    return top.value;
  }
}