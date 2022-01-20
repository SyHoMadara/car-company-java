package libs;

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> pre;

    Node(T data) {
        next = null;
        pre = null;
    }
    public Node(){
        next = null;
        pre = null;
    }
}