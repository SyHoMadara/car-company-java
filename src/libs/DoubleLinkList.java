package libs;

public class DoubleLinkList<T> {
    Node<T> head, tail;
    int length;

    public DoubleLinkList() {
        head = null;
        tail = null;
        length = 0;
    }

    public int getLength() {
        return this.length;
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

    public void traverse(DListTraverseMethod<T> method) {
        Node<T> node = tail;
        int i = 0;
        while (i < length) {
            method.start(node);
            node = node.pre;
            i++;
        }
    }

    public boolean removeHead(){
        if(length==0) return false;
        if(head.next != null){
            head.next.pre = null;
            head = head.next;
        } else {
            head = null;
        }
        length--;
        return true;
    }

    public  boolean removeTail(){
        if(length==0) return false;
        if(tail.pre != null){
            tail.pre.next = null;
            tail = tail.pre;
        } else {
            tail = null;
        }
        length--;
        return true;
    }

    public boolean remove(Node<T> node) {
        if (length == 0) return false;
        if (node == tail) return  removeTail();
        if (node == head) return removeHead();
        node.next.pre = node.pre;
        node.pre.next = node.next;
        length--;
        return true;
    }

    public static void main(String[] args) {
        DoubleLinkList<Integer> l = new DoubleLinkList<>();
        for (int i = 0; i < 10; i++) {
            l.pushBack(i);
        }
        Node<Integer> node = l.getAt(5);
        l.remove(node);
        try {
            l.traverse(new DListTraverseMethod<Integer>() {
                @Override
                public void start(Node<Integer> node) {
                    System.out.println(node.data);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
