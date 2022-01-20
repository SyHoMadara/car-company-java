import libs.DoubleLinkList;
import libs.Node;

public class Main {

    public static void main(String args[]) {

        Node<Agency> a = new Node<>();
        DoubleLinkList<Agency> dll = new DoubleLinkList<>();
        Agency agency_properties = new Agency("kabol");
        dll.pushTail(agency_properties);
        System.out.print(dll.getAt(0).data.name());
    }
}
