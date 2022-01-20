import libs.DoubleLinkList;
import libs.Node;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        Node<Agency_properties> a = new Node<>();
        DoubleLinkList<Agency_properties> dll = new DoubleLinkList<>();
        ArrayList<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(2);
        d.add(3);
        d.add(4);
        Agency_properties agency_properties = new Agency_properties(d);
        dll.pushTail(agency_properties);
        System.out.print(dll.getAt(0).data.name().get(2));
    }
}
