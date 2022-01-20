class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> pre;

    Node(T data) {
        next = null;
        pre = null;
    }
    Node(){
        next = null;
        pre = null;
    }
}

public class DoubleLinkList<T> {
    Node<T> head, tail;
    int size;
    public DoubleLinkList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertAfter(Node<T> node ,T data){

    }

    public void pushBack(T data){

    }
    public void pushTail(T data){

    }
}
