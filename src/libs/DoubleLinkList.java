package libs;


import com.sun.javafx.image.IntPixelGetter;
import javafx.util.Pair;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
        PriorityQueue<Integer> a;
        return node;
    }

    public void traverse(DListTraverseMethod<T> method) throws Exception {
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



        PriorityQueue<Pair<Integer, Integer>> p = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int comp = o2.getKey().compareTo(o1.getKey());
                if(comp != 0) return comp;
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Pair<Integer, Integer> a = new Pair<>(3,5);
        Pair<Integer, Integer> b = new Pair<>(3,4);
        Pair<Integer, Integer> c = new Pair<>(3,2);
        Pair<Integer, Integer> d = new Pair<>(2,1);
        p.add(a);
        p.add(b);
        p.add(c);
        p.add(d);
        while(!p.isEmpty()){
            Pair pp = p.remove();
            System.out.println(pp.getKey() + " " + pp.getValue());
        }

    }
}
