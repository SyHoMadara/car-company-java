package libs;


public class DoubleLinkList<T> {
    Node<T> head, tail;
    int length;

    public DoubleLinkList() {
        head = null;
        tail = null;
        length = 0;
    }

    public Node<T> insertAfter(Node<T> node, T data) {
        Node<T> newNode = new Node<T>(data);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            if (node == tail) pushTail(data);
            else {
                newNode.pre = node;
                newNode.next = node.next;
                node.next.pre = newNode;
                node.next = newNode;
            }
        }
        length++;
        return newNode;
    }

    public Node<T> pushBack(T data) {
        Node<T> node = new Node<T>(data);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }

        length++;
        return node;
    }

    public Node<T> pushTail(T data) {
        Node<T> node = new Node<T>(data);
        if (length == 0) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        length++;
        return node;
    }

    public Node<T> getAt(int i) {
        if (i > length) return null;
        Node<T> node = tail;
        for (int j = 0; j < i; j++) {
            node = node.pre;
        }
        return node;
    }

    public void traverse(){

    }

}